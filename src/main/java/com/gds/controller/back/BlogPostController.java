package com.gds.controller.back;

import com.gds.entity.Club;
import com.gds.entity.Dict;
import com.gds.entity.Post;
import com.gds.service.BlogPostService;
import com.gds.service.DictService;
import com.gds.utils.PageBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 后台管理员控制博客相关操作
 */
@Controller
@RequestMapping("back")
public class BlogPostController {
    private Logger logger = Logger.getLogger(BlogPostController.class);

    @Resource(name = "BlogPostService")
    private BlogPostService blogPostService;

    @Resource(name = "DictService")
    private DictService dictService;

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

    /**
     * 文章发布页面
     */
    @RequestMapping("/blogAddPage.do")
    public String blogAddPage(HttpServletRequest request, HttpServletResponse response, ModelMap model){

        //所属分类
        List<Dict> postType =  dictService.selectDiceByKey("006");
        model.addAttribute("postType",postType);

        //社团类型
        List<Dict> clubType =  dictService.selectDiceByKey("001");
        model.addAttribute("clubType",clubType);

        return "back/blog/add";
    }

    /**
     * 保存文章操作
     */
    @RequestMapping("/postSave.do")
    public String postSave(HttpServletRequest request, HttpServletResponse response, ModelMap model,Post post){
        post.setBlogCreatTime(new Date());
        post.setView(0);
        post.setStatus(1);
        blogPostService.insertPost(post);

        return clubList(request,response,model,null,null,null,null,null);
    }

    /**
     * postEdit
     */
    @RequestMapping("/postEdit.do")
    public String postEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                           @RequestParam(value = "blogId", required = false)Integer blogId){
        Post post = blogPostService.selectPostById(blogId);
        //所属分类
        List<Dict> postType =  dictService.selectDiceByKey("006");
        model.addAttribute("postType",postType);
        //社团类型
        List<Dict> clubType =  dictService.selectDiceByKey("001");
        model.addAttribute("clubType",clubType);
        model.addAttribute("Post",post);
        return "back/blog/edit";
    }

    /**
     * postUpdate
     */
    @RequestMapping("/postUpdate.do")
    public String postUpdate(HttpServletRequest request, HttpServletResponse response, ModelMap model,Post post){
        blogPostService.update(post);
        return clubList(request,response,model,null,null,null,null,null);
    }

    /**
     * postDelete
     */
    @RequestMapping("/postDelete.do")
    public String postDelete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                             @RequestParam(value = "blogId", required = false)Integer blogId){
        blogPostService.deleteById(blogId);
        return clubList(request,response,model,null,null,null,null,null);
    }


    /**
     * 文件上传功能
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/imgUpload.do",method= RequestMethod.POST)
    public String imgUpload(MultipartFile file, HttpServletRequest request, ModelMap model) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        String filePath = "/upload/"+fileName;

        File dir = new File(path,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);

        //所属分类
        List<Dict> postType =  dictService.selectDiceByKey("006");
        model.addAttribute("postType",postType);

        //社团类型
        List<Dict> clubType =  dictService.selectDiceByKey("001");
        model.addAttribute("clubType",clubType);

        model.addAttribute("filePath",filePath);
        model.addAttribute("fileName",fileName);
        return "back/blog/add";
    }
}
