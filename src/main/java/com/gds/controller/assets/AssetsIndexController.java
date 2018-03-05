package com.gds.controller.assets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assets")
public class AssetsIndexController {


    @RequestMapping("/admin-index.do")
    public String main(){
        return "assets/admin-index";
    }

    @RequestMapping("/admin-form.do")
    public String form(){
        return "assets/admin-form";
    }

    @RequestMapping("/admin-gallery.do")
    public String gallery(){
        return "assets/admin-gallery";
    }

    @RequestMapping("/admin-help.do")
    public String help(){
        return "assets/admin-help";
    }

    @RequestMapping("/admin-log.do")
    public String log(){
        return "assets/admin-log";
    }

    @RequestMapping("/admin-table.do")
    public String table(){
        return "assets/admin-table";
    }

    @RequestMapping("/admin-user.do")
    public String user(){
        return "assets/admin-user";
    }

    @RequestMapping("/index.do")
    public String index(){
        return "assets/index";
    }


}
