package com.gds.controller.back;

import com.gds.entity.Student;
import com.gds.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/back")
public class AdminController {

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

    @Resource(name="StudentService")
    private StudentService studentService;

    /**
     * 社员列表
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("/stuMag.do")
    public String stuMag(HttpServletRequest request,HttpServletResponse response,ModelMap model){
        List<Student> list = studentService.findAllStudent();
        model.addAttribute("list",list);
        System.out.println(list.toString());
        return "back/stuMag";
    }





}
