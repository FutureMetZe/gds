package com.gds.controller.back;

import com.gds.entity.Activity;
import com.gds.entity.Dict;
import com.gds.service.ActivityService;
import com.gds.service.DictService;
import com.gds.utils.DateUtils;
import com.gds.utils.PageBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("back")
public class ActivityController {

    private Logger logger = Logger.getLogger(ActivityController.class);

    @Resource(name="ActivityService")
    private ActivityService activityService;
    @Resource(name="DictService")
    private DictService dictService;

    /**
     * 活动列表
     */
    @RequestMapping("/activityList.do")
    public String clubList(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                           @RequestParam(value = "pageSize", required = false)Integer pageSize,
                           @RequestParam(value = "currentPage", required = false)Integer currentPage,
                           @RequestParam(value = "activityTitle", required = false)String activityTitle,
                           @RequestParam(value = "sponsor", required = false)String sponsor ){
        PageBean<Activity> pageBeans = activityService.selectActivityPageList(currentPage,pageSize,activityTitle,sponsor);
        model.addAttribute("page",pageBeans);
        model.addAttribute("beans",pageBeans.getBeans());
        model.addAttribute("activityTitle",activityTitle);
        model.addAttribute("sponsor",sponsor);
        logger.info("访问【activityList.do】接口；返回数据为："+pageBeans.toString());
        return "back/activity/list";
    }

    /**
     *  跳转到新增页面
     */
    @RequestMapping("/activityAdd.do")
    public String clubAdd(HttpServletRequest request, HttpServletResponse response, ModelMap model ){
        //从字典中获取 005活动类型
        List<Dict> activityTypes = dictService.selectDiceByKey("005");
        model.addAttribute("activityTypes",activityTypes);
        logger.info("访问【activityAdd.do】接口；返回数据为："+activityTypes.toString());
        return "back/activity/add";
    }

    /**
     *  保存活动数据
     */
    @RequestMapping("/activitySave.do")
    public String save(Activity activity,HttpServletRequest request, HttpServletResponse response,ModelMap model,
                       @RequestParam(value = "begintimeStr", required = false)String begintimeStr,
                       @RequestParam(value = "overtimeStr", required = false)String overtimeStr){
        activity.setBegintime(DateUtils.strToDateLong(begintimeStr));
        activity.setOvertime(DateUtils.strToDateLong(overtimeStr));
        activityService.insertSelective(activity);
        return clubList(request,response,model,null,null,null,null);
    }
}
