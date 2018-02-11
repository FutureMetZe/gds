package com.gds.controller.back;

import com.gds.entity.ActivityRoom;
import com.gds.service.ActivityRoomService;
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
import java.util.List;

@Controller
@RequestMapping("back")
public class ActivityRoomController {
    private Logger logger = Logger.getLogger(ActivityRoomController.class);

    @Resource(name = "ActivityRoomService")
    private ActivityRoomService activityRoomService;


    /**
     * 活动列表
     */
    @RequestMapping("/roomList.do")
    public String roomList(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                           @RequestParam(value = "pageSize", required = false)Integer pageSize,
                           @RequestParam(value = "currentPage", required = false)Integer currentPage,
                           @RequestParam(value = "roomName", required = false)String roomName,
                           @RequestParam(value = "roomIsUse", required = false)String roomIsUse){
        PageBean<ActivityRoom> pageBeans = activityRoomService.selectRoomPageList(currentPage,pageSize,roomName,roomIsUse);
        model.addAttribute("page",pageBeans);
        model.addAttribute("beans",pageBeans.getBeans());
        model.addAttribute("roomName",roomName);
        model.addAttribute("roomIsUse",roomIsUse);
        logger.info("访问【roomList.do】接口；返回数据为："+pageBeans.toString());
        return "back/activityRoom/list";
    }

    /**
     *  跳转到新增页面
     */
    @RequestMapping("/roomAdd.do")
    public String clubAdd(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                          @RequestParam(value = "roomId", required = false)Integer roomId ){
        ActivityRoom activityRoom = new ActivityRoom();
        if (roomId !=null){
            activityRoom = activityRoomService.selectRoomById(roomId);
            model.addAttribute("activityRoom",activityRoom);
        }
        return "back/activityRoom/add";
    }

    /**
     *  保存活动数据
     */
    @RequestMapping("/roomSave.do")
    public String save(ActivityRoom activityRoom,HttpServletRequest request, HttpServletResponse response,ModelMap model){

        activityRoomService.insert(activityRoom);

        return roomList(request,response,model,null,null,null,null);
    }

    /**
     * roomDelete
     */
    @RequestMapping("/roomDelete.do")
    public String roomDelete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                          @RequestParam(value = "roomId", required = false)Integer roomId ){
        activityRoomService.deleteRoomById(roomId);
        return "back/activityRoom/add";
    }


}
