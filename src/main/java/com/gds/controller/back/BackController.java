package com.gds.controller.back;

import com.gds.service.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/back")
public class BackController {
    private Logger logger = Logger.getLogger(BackController.class);

    @Resource(name = "HubestlService")
    private HubestlService hubestlService;

    @Resource(name = "GoodsService")
    private GoodsService goodsService;

    @Resource(name = "ActivityService")
    private ActivityService activityService;

    @Resource(name = "ActivityRoomService")
    private ActivityRoomService activityRoomService;

    @Resource(name = "FileService")
    private FileService fileService;

    @Resource(name = "StudentService")
    private StudentService studentService;

    @Resource(name = "ClubService")
    private ClubService clubService;

    @Resource(name = "BlogPostService")
    private BlogPostService blogPostService;

    @Resource(name = "PostReviewService")
    private PostReviewService postReviewService;
    /**
     * statisticsList
     */
    @RequestMapping("/statisticsList.do")
    public String statisticsList(Model model){
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        //1.社联成员数量
        Integer hubesCount = hubestlService.selectCount();
        map.put("社联成员数量",hubesCount);

        //2.物资数量
        Integer goodCount = goodsService.selectCount();
        map.put("物资数量",goodCount);

        //3.活动数量
        Integer actCount = activityService.selectCount();
        map.put("活动数量",actCount);

        //4.活动室数量
        Integer roomCount = activityRoomService.selectCount();
        map.put("活动室数量",roomCount);

        //5.电子文件数量
        Integer fileCount = fileService.selectCount();
        map.put("电子文件数量",fileCount);

        //6.社团成员数量
        Integer stuCount = studentService.selectCount();
        map.put("社团成员数量",stuCount);

        //7.社团数量
        Integer clubCount = clubService.selectCount();
        map.put("社团数量",clubCount);

        //8.发布文章数量
        Integer postCount = blogPostService.selectCount();
        map.put("发布文章数量",postCount);

        //9.总留言数
        Integer reviewCount = postReviewService.selectCount();
        map.put("总留言数",reviewCount);

        model.addAttribute("map",map);
        return "back/statistics/list";
    }



    @RequestMapping("/main.do")
    public String main(){
        return "back/main";
    }
    @RequestMapping("/top.do")
    public String top(){
        return "back/top";
    }
    @RequestMapping("/left.do")
    public String left(){
        return "back/left";
    }
    @RequestMapping("/index.do")
    public String index(){
        return "back/index";
    }
    @RequestMapping("/right.do")
    public String right(){
        return "back/right";
    }


}
