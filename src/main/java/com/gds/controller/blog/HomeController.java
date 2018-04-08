package com.gds.controller.blog;

import com.gds.entity.*;
import com.gds.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/blog/home")
public class HomeController {

    @Resource(name = "StuAndClubService")
    private StuAndClubService stuAndClubService;

    @Resource(name = "ClubService")
    private ClubService clubService;

    @Resource(name = "BlogPostService")
    private BlogPostService blogPostService;

    @Resource(name = "PostReviewService")
    private PostReviewService postReviewService;

    @Resource(name = "NoticeService")
    private NoticeService noticeService;

    @Resource(name = "StudentService")
    private StudentService studentService;

    @Resource(name = "StudentJoinService")
    private StudentJoinService studentJoinService;


    /**
     * 进入用户主页
     */
    @RequestMapping("/goHome.do")
    public String goHome(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("UserName");
        Student student = (Student) session.getAttribute("Student");

        String clubMessage = "";    //社团模块错误信息提示
        String reviewMessage = "";    //发布模块错误信息提示

        if (username!=null && !username.equals("")){

            //1,把学生对象传入个人主页
            model.addAttribute("student",student);

            //2,把学生所加入的社团信息传入主页
            List<Club> clubs = new ArrayList<Club>();
            List<StuAndClub> links = stuAndClubService.selectStudentClubByStuNum(student.getStuNum());
            if (links != null){
                for (int i = 0; i < links.size() ; i++) {
                    Club club = clubService.selectClubById(links.get(i).getDictClubId());
                    clubs.add(club);
                }
            }else{
                //您还没有加入社团
                clubMessage = "您还没有加入社团";
            }
            model.addAttribute("clubs",clubs);
            model.addAttribute("clubMessage",clubMessage);


            if(clubs.size()!=0){
                //2-2查找相关类型的社团
                List<Club> sameClub = clubService.selectClubByType(clubs.get(0).getClub_type());
                model.addAttribute("sameClub",sameClub);

                //2-3查找相关类型的文章
                List<Post> samePosts = blogPostService.selectPostByTypeOrKeyword(clubs.get(0).getClub_type());
                model.addAttribute("samePosts",samePosts);
            }

            //3,把学生发布的评论传入主页
            List<PostReview> myReviews = postReviewService.selectReviewByUsername(student.getUsername());
            model.addAttribute("myReviews",myReviews);

            //4,把学生发布的文章ID，标题，日期，介绍，类型传入主页
            List<Post> myPosts = blogPostService.selectPostByUsername(student.getUsername());
            model.addAttribute("myPosts",myPosts);


            //5,查找对应社团公告
            if (clubs.size()!=0){
                String clubNmae = clubs.get(0).getClub_name();
                List<AssetsNotice> notices = noticeService.selectNoticesByClubName(clubNmae);
                if (notices!=null){
                    AssetsNotice notice = notices.get(0);
                    model.addAttribute("notice",notice);
                }
            }

            System.out.println("myReviews:"+myReviews);
            System.out.println("myPosts:"+myPosts);

            return "blog/home/HomePage";
        }else {
            return "blog/login";
        }
    }


    /**
     * 跳转到选择加入新社团页面
     */
    @RequestMapping("/ChooseClub.do")
    public String ChooseClub(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                             @RequestParam(value = "studentNum", required = false)String studentNum){

        //将学生学号接收到转发到页面
        Student student = studentService.selectByStuNum(studentNum);

        //把社团列表转发到页面
        List<Club> Clubs = clubService.selectAll();
        model.addAttribute("Clubs",Clubs);
        model.addAttribute("Student",student);

        return "blog/joinClub";
    }

    /**
     *  发送加入社团申请
     */
    @RequestMapping("/sendJoin.do")
    public String sendJoin(HttpServletRequest request, HttpServletResponse response, ModelMap model){

        //接受到社团id和学生学号
        String studentNum = request.getParameter("studentNum");
        Integer clubId = Integer.parseInt(request.getParameter("clubId"));
        String message = "";

        //先查询是否有对应的映射
        Integer countSAC = stuAndClubService.selectCountByNumAndId(studentNum,clubId);
        Integer countJAC = studentJoinService.selectCountByNumAndId(studentNum,clubId);

        if(clubId==null){
            //请选择正确的社团名称
            message = "请选择正确的社团名称";
            request.getSession().setAttribute("joinMessage",message);
            return ChooseClub(request,response,model,studentNum);
        }else if(countSAC>0){
            //如果有映射表示已经加入该社团
            message = "您已经是该社团成员！";
            request.getSession().setAttribute("joinMessage",message);
            return ChooseClub(request,response,model,studentNum);
        }else if (countJAC>0){
            //再查询是否申请过
            message = "您已经提交过申请了！";
            request.getSession().setAttribute("joinMessage",message);
            return ChooseClub(request,response,model,studentNum);
        }

        StudentJoinClub studentJoinClub = new StudentJoinClub();
        studentJoinClub.setStudentNum(studentNum);
        studentJoinClub.setWishClubId(clubId);
        studentJoinClub.setApplicationTime(new Date());
        studentJoinService.insertJoin(studentJoinClub);

        return "redirect:/blog/home/goHome.do";
    }


    /**
     * 跳转到学生发布文章页面
     */
    @RequestMapping("/studentPost.do")
    public String studentPost(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                         @RequestParam(value = "studentUserName", required = false)String studentUserName){

        //1.学生帐号非空判断
        if(studentUserName==null || studentUserName.equals("") ){
            //1.1.空重新登录
            return "/blog/index";
        }else{
            //1.2.非空转发到发布文章页面
            model.addAttribute("studentUserName",studentUserName);
            return "/blog/editor";
        }
    }

    /**
     * 保存文章操作
     * @param request
     * @param model
     * @throws IOException
     */
    @RequestMapping("/savePost.do")
    public String savePost(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                           Post post){
        post.setStatus(1);
        post.setBlogCreatTime(new Date());
        post.setView(1);
        post.setBlogLevel("0");
        blogPostService.insertPost(post);
        return "redirect:/blog/index.do";
    }



    @RequestMapping(value="/fileUpload.do",method= RequestMethod.POST)
    public void upload(MultipartFile file, HttpServletRequest request, ModelMap model) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        String filePath = path+"\\"+fileName;

        File dir = new File(path,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        model.addAttribute("filePath",filePath);
        model.addAttribute("fileName",fileName);

    }

}
