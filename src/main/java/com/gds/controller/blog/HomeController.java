package com.gds.controller.blog;

import com.gds.entity.*;
import com.gds.service.BlogPostService;
import com.gds.service.ClubService;
import com.gds.service.PostReviewService;
import com.gds.service.StuAndClubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
            List<StuAndClub> links = stuAndClubService.selectStudentClubByStuNum(student.getStu_num());
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

            //2-2查找相关类型的社团
            List<Club> sameClub = clubService.selectClubByType(clubs.get(0).getClub_type());
            model.addAttribute("sameClub",sameClub);
            //2-3查找相关类型的文章
            List<Post> samePosts = blogPostService.selectPostByTypeOrKeyword(clubs.get(0).getClub_type());
            model.addAttribute("samePosts",samePosts);

            //3,把学生发布的评论传入主页
            List<PostReview> myReviews = postReviewService.selectReviewByUsername(student.getUsername());
            model.addAttribute("myReviews",myReviews);

            //4,把学生发布的文章ID，标题，日期，介绍，类型传入主页
            List<Post> myPosts = blogPostService.selectPostByUsername(student.getUsername());
            model.addAttribute("myPosts",myPosts);
            System.out.println("myReviews:"+myReviews);
            System.out.println("myPosts:"+myPosts);

            return "blog/home/HomePage";
        }else {
            return "blog/login";
        }
    }


}
