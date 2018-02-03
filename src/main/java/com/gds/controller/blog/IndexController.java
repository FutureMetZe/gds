package com.gds.controller.blog;

import com.gds.entity.Banners;
import com.gds.entity.Dict;
import com.gds.entity.Post;
import com.gds.entity.PostReview;
import com.gds.service.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        List<PostReview> newReviews = postReviewService.selectReviewByTime();
        model.addAttribute("newReviews",newReviews);

        //5,查询广告列表
        List<Banners> banners = bannersService.selectAllBanners();
        model.addAttribute("banners",banners);

        System.out.println(banners);
        return "blog/index";
    }


    /**
     * 登录
     * @return
     */
    @RequestMapping("/userLogin.do")
    public String userLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                            @RequestParam(value = "username", required = false)String username,
                            @RequestParam(value = "password", required = false)String password){
        String message = "";
        Integer integer = studentService.selectByUsernameAndPassword(username,password);
        HttpSession session = request.getSession(true);
        if (integer==1){
            session.setAttribute("UserName",username);
            //用户存在
            return index(request,response,model);
        }else {
            //用户不存在
            message = "帐号或密码不正确！";
            model.addAttribute("message",message);
            return "blog/login";
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
        return index(request,response,model);
    }


    /**
     * 列表任务栏目
     * @return
     */
    @RequestMapping("/list.do")
    public String list(){
        return "blog/list";
    }

    /**
     * 文章详情
     * @return
     */
    @RequestMapping("/show.do")
    public String show(){
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
    public String toRegisterPage(){
        return "blog/register";
    }

}
