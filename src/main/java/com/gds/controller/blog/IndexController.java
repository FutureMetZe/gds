package com.gds.controller.blog;

import com.gds.entity.*;
import com.gds.service.*;
import com.gds.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.management.monitor.StringMonitor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class IndexController {
    private Logger logger = Logger.getLogger(IndexController.class);

    @Resource(name = "DictService")
    private DictService dictService;

    @Resource(name = "BlogPostService")
    private BlogPostService blogPostService;

    @Resource(name = "PostReviewService")
    private PostReviewService postReviewService;

    @Resource(name = "BannersService")
    private BannersService bannersService;

    @Resource(name = "StudentService")
    private StudentService studentService;

    @Resource(name = "ClubService")
    private ClubService clubService;

    @Resource(name = "StudentJoinService")
    private StudentJoinService studentJoinService;

    @Resource(name = "StuAndClubService")
    private StuAndClubService stuAndClubService;

    /**
     * 跳转到博客首页
     * @return
     */
    @RequestMapping("/index.do")
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        //1,查询导航栏字典
        List<Dict> blogPostType = dictService.selectDiceByKey("006");
        model.addAttribute("blogPostType",blogPostType);

        //2,查询推荐列表
        List<Post> levelPosts = blogPostService.selectPostByLevel();
        model.addAttribute("levelPosts",levelPosts);

        //3,查询最新发布文章列表
        List<Post> newPosts = blogPostService.selectPostByTime();
        model.addAttribute("newPosts",newPosts);

        //4,查询最新评论列表
        String reviewnum = dictService.selectDiceByKey("007").get(0).getValue();
        Integer rowNum = null;
        if(reviewnum !=null ){
            rowNum = Integer.valueOf(reviewnum);
        }
        List<PostReview> newReviews = postReviewService.selectReviewByTime(rowNum,"");
        model.addAttribute("newReviews",newReviews);
       /* Integer row_num = 8;
        List<PostReview> newReviews = postReviewService.selectReviewByTime(8,"");
        model.addAttribute("newReviews",newReviews);*/

        //5,查询广告列表
        List<Banners> banners = bannersService.selectAllBanners();
        model.addAttribute("banners",banners);

        //文章数量
        Integer postCount = blogPostService.selectCount();
        model.addAttribute("postCount",postCount);

        //用户数量
        Integer userCount = studentService.selectCount();
        model.addAttribute("userCount",userCount);
        return "blog/index";
    }


    /**
     * 列表栏目 （分页功能暂时未完成）
     * @return
     */
    @RequestMapping("/list.do")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @RequestParam(value = "postType", required = false)String postType ){

//        System.out.println(postType);
        //1,查询导航栏字典
        List<Dict> blogPostType = dictService.selectDiceByKey("006");
        model.addAttribute("blogPostType",blogPostType);

        //2,查询最新评论列表
        String reviewnum = dictService.selectDiceByKey("007").get(0).getValue();
        Integer rowNum = null;
        if(reviewnum !=null ){
            rowNum = Integer.valueOf(reviewnum);
        }
        model.addAttribute("postType",postType);
//        Integer row_num = 8;
        List<PostReview> newReviews = postReviewService.selectReviewByTime(rowNum,postType);
        model.addAttribute("newReviews",newReviews);


        //3,所属板块文章（包含分页信息）
        PageBean<Post> pageBeans = blogPostService.selectClubPageList(null,null,null,null,postType);
//        model.addAttribute("page",pageBeans);
        model.addAttribute("posts",pageBeans.getBeans());
        model.addAttribute("postType",postType);

        logger.info("访问【blog/list.do】接口；返回数据为："+pageBeans.toString());

        return "blog/list";

    }

    /**
     * 文章详情
     * @return
     */
    @RequestMapping("/show.do")
    public String show(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @RequestParam(value = "blogId", required = false)Integer blogId){
        //1,查询导航栏字典
        List<Dict> blogPostType = dictService.selectDiceByKey("006");
        model.addAttribute("blogPostType",blogPostType);

        //2,查询最新评论列表
        String reviewnum = dictService.selectDiceByKey("007").get(0).getValue();
        Integer rowNum = null;
        if(reviewnum !=null ){
            rowNum = Integer.valueOf(reviewnum);
        }
        List<PostReview> newReviews = postReviewService.selectReviewByTime(rowNum,"");
        model.addAttribute("newReviews",newReviews);

        //3,查询推荐列表
        List<Post> levelPosts = blogPostService.selectPostByLevel();
        model.addAttribute("levelPosts",levelPosts);

        //4,文章详情查询 blogId
        Post POST = blogPostService.selectPostById(blogId);
        model.addAttribute("POST",POST);
        POST.setView(POST.getView()+1);
        blogPostService.update(POST);
        //5,文章对应留言列表
        PageBean<PostReview> postReviewsList = postReviewService.selectPostReviewPageList(null,null,null,null,blogId);
        model.addAttribute("Reviews",postReviewsList.getBeans());

        return "blog/show";
    }



    /**
     * 错误页面
     * @return
     */
    @RequestMapping("/error.do")
    public String error(){
        return "blog/404";
    }



    /**
     * 发布评论
     */
    @RequestMapping("/submitReview.do")
    public String submitReview(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                               PostReview postReview ){
//        System.out.println("提交的评论："+postReview);
        Integer blogId = postReview.getBlogId();
        HttpSession session = request.getSession();
        String UserName = (String) session.getAttribute("UserName");

        if ( UserName !=null && !UserName.equals("")){
            //登录可以发布
            postReview.setReviewUserName(UserName);
            postReview.setReviewCreattime(new Date());
            postReviewService.insertReview(postReview);
            return show(request,response,model,blogId);
        }else {
            //没登录跳转到登录页面
            return "blog/login";
        }

    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping("/toLoginPage.do")
    public String toLoginPage(){
        return "blog/login";
    }

    /**
     * 跳转到注册页面
     */
    @RequestMapping("/toRegisterPage.do")
    public String toRegisterPage(HttpServletRequest request, HttpServletResponse response, ModelMap model){

        //将所有社团名称、ID发出去
        List<Club> Clubs = clubService.selectAll();
        model.addAttribute("Clubs",Clubs);
        return "blog/register";
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
     *  发送申请
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
     * 登录
     * @return
     */
    @RequestMapping("/userLogin.do")
    public String userLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                            @RequestParam(value = "username", required = false)String username,
                            @RequestParam(value = "password", required = false)String password,
                            @RequestParam(value = "code", required = false)String code,
                            @RequestParam(value = "loginType", required = false)String loginType ){
        String message = "";
        HttpSession session = request.getSession(true);

        String sessionCode = (String) session.getAttribute("code");
        if (!StringUtils.equalsIgnoreCase(code, sessionCode)) {  //忽略验证码大小写
            //用户不存在
            message = "验证码错误！";
            model.addAttribute("message",message);
            return "blog/login";
        }
        if(loginType.equals("2")){

            //匹配社团帐号密码
            Club club = clubService.selectClubByPassword(username,password);
            if(club != null){
                model.addAttribute("ClubAdmin",club);
                session.setAttribute("clubId",club.getClub_id());
                session.setAttribute("clubName",club.getClub_name());
                return "redirect:/assets/admin-index.do";
            }else{
                //用户不存在
                message = "该帐号无权限！";
                model.addAttribute("message",message);
                return "blog/login";
            }

        }else{
            Student student = studentService.selectByUsernameAndPassword(username,password);
            if (student != null){
                session.setAttribute("UserName",student.getStuName());
                session.setAttribute("Student",student);
                //用户存在
                return index(request,response,model);
            }else {
                //用户不存在
                message = "帐号或密码不正确！";
                model.addAttribute("message",message);
                return "blog/login";
            }
        }

    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/userExit.do")
    public String userExit(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        HttpSession session = request.getSession();
        session.setAttribute("UserName","");
        session.setAttribute("Student",null);
        return index(request,response,model);
    }


    /**
     * 进入管理员后台
     * @return
     */
    @RequestMapping("/admin-index.do")
    public String adminMain(){
        return "assets/admin-index";
    }

}
