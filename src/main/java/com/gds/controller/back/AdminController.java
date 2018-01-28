package com.gds.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
@RequestMapping("/back")
public class AdminController {

    @RequestMapping("/adminLogin.do")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @RequestParam(value = "pageSize", required = false)Integer pageSize,
                       @RequestParam(value = "currentPage", required = false)Integer currentPage,
                       @RequestParam(value = "name", required = false)String name,
                       @RequestParam(value = "department", required = false)String department){

        return "http://localhost:8090";
    }
}
