package com.gds.controller.back;

import com.gds.entity.Post;
import com.gds.entity.PostReview;
import com.gds.service.PostReviewService;
import com.gds.utils.PageBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("back")
public class BlogPostReviewController {
    private Logger logger = Logger.getLogger(BlogPostReviewController.class);

    @Resource(name = "PostReviewService")
    private PostReviewService postReviewService;

    /**
     * 所有留言列表
     */
    @RequestMapping("/postReviewList.do")
    public String clubList(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                           @RequestParam(value = "pageSize", required = false)Integer pageSize,
                           @RequestParam(value = "currentPage", required = false)Integer currentPage,
                           @RequestParam(value = "blogId", required = false)Integer blogId,
                           @RequestParam(value = "blogTitle", required = false)String blogTitle,
                           @RequestParam(value = "reviewUserName", required = false)String reviewUserName ){
        PageBean<PostReview> pageBeans = postReviewService.selectPostReviewPageList(currentPage,pageSize,blogTitle,reviewUserName,blogId);
        model.addAttribute("page",pageBeans);
        model.addAttribute("beans",pageBeans.getBeans());
        model.addAttribute("blogTitle",blogTitle);
        model.addAttribute("reviewUserName",reviewUserName);
        logger.info("访问【postReviewList.do】接口；返回数据为："+pageBeans.toString());
        return "back/blogReview/list";
    }



    /**
     * 删除留言
     */
    @RequestMapping("/postReviewDelete.do")
    public String postReviewDelete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                           @RequestParam(value = "reviewId", required = false)Integer reviewId){
        postReviewService.deleteReviewById(reviewId);
        return clubList(request,response,model,null,null,null,null,null);
    }
}
