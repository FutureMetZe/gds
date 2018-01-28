package com.gds.controller.blog;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class IndexBlogController {
    private Logger logger = Logger.getLogger(IndexBlogController.class);

    /**
     * 跳转到博客首页
     * @return
     */
    @RequestMapping("/index.do")
    public String index(){
        return "blog/index";
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
}
