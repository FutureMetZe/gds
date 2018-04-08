package com.gds.controller.blog;

import com.alibaba.fastjson.JSONObject;
import com.gds.entity.Post;
import com.gds.entity.Student;
import com.gds.entity.User;
import com.gds.service.StuAndClubService;
import com.gds.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/blog")
public class UserController {
    private Logger logger = Logger.getLogger(UserController.class);

    @Resource(name = "StudentService")
    private StudentService studentService;

    @Resource(name = "StuAndClubService")
    private StuAndClubService stuAndClubService;

    /**
     * 用户注册 （需完善）
     * @param request
     * @param response
     * @param model
     * @param student
     * @return
     */
    @RequestMapping(value = "/registerUser.do" )
    public String registUser(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                      @RequestParam(value = "clubId", required = false)Integer clubId,
                             Student student){
        student.setRegisterTime(new Date().toString());
        studentService.insertStudent(student);

        //将学号与社团ID影射加入数据库
        if (clubId !=null ){
            stuAndClubService.insertRelation(student.getStuNum(),clubId);
        }
        model.addAttribute("message","您已注册成功！快来登陆试试吧。");

        return toLoginPage(request,response,model);
    }


    /**
     * 用户注册时异步校验用户是否存在（未完成）
     * @param map
     * @return
     */
    @RequestMapping("/usernameExist.do")
    @ResponseBody
    public String usernameExist(@RequestBody Map<String,String> map){
        String username = map.get("username");
        System.out.print(username);
        JSONObject jsonObject = new JSONObject();
        if (username.equals("admin")){
            //存在
            jsonObject.put("isExist",true);
        }else {
            //不存在
            jsonObject.put("isExist",false);
        }

        return jsonObject.toString();
    }


    /**
     * 全局404  error404
     */
    @RequestMapping("/error404.do")
    public String error404(){
        return "/blog/404";
    }


    /**
     * 跳转到登录页面
     */
    @RequestMapping("/toLoginPage.do")
    public String toLoginPage(HttpServletRequest request, HttpServletResponse response, ModelMap model){

        return "/blog/login";
    }

}
