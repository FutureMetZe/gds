package com.gds.controller.back;

import com.gds.entity.Club;
import com.gds.entity.Post;
import com.gds.service.BlogPostService;
import com.gds.utils.PageBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台管理员控制博客相关操作
 */
@Controller
@RequestMapping("back")
public class BlogPostController {
    private Logger logger = Logger.getLogger(BlogPostController.class);

    @Resource(name = "BlogPostService")
    private BlogPostService blogPostService;

    /**
     * 所有文章列表
     *
     */
    @RequestMapping("/blogList.do")
    public String clubList(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                           @RequestParam(value = "pageSize", required = false)Integer pageSize,
                           @RequestParam(value = "currentPage", required = false)Integer currentPage,
                           @RequestParam(value = "blogAuthor", required = false)String blogAuthor,
                           @RequestParam(value = "blogSort", required = false)String blogSort,
                           @RequestParam(value = "postTitle", required = false)String postTitle
                           ){
        PageBean<Post> pageBeans = blogPostService.selectClubPageList(currentPage,pageSize,postTitle,blogAuthor,blogSort);
        model.addAttribute("page",pageBeans);
        model.addAttribute("beans",pageBeans.getBeans());
        model.addAttribute("blogAuthor",blogAuthor);
        model.addAttribute("blogSort",blogSort);
        logger.info("访问【blogList.do】接口；返回数据为："+pageBeans.toString());
        return "back/blog/list";
    }




}
