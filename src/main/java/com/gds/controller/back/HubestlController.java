package com.gds.controller.back;

import com.gds.entity.Dict;
import com.gds.entity.Hubestl;
import com.gds.service.DictService;
import com.gds.service.HubestlService;
import com.gds.utils.PageBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/back")
public class HubestlController {
    private Logger logger = Logger.getLogger(HubestlController.class);

    @Resource(name="HubestlService")
    private HubestlService hubestlService;

    @Resource(name="DictService")
    private DictService dictService;

    /**
     * 社员(学生)列表
     */
    @RequestMapping("/hubestl_list.do")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                         @RequestParam(value = "pageSize", required = false)Integer pageSize,
                         @RequestParam(value = "currentPage", required = false)Integer currentPage,
                         @RequestParam(value = "name", required = false)String name,
                         @RequestParam(value = "department", required = false)String department){
        PageBean<Hubestl> pageBeans = hubestlService.selectPageList(currentPage,pageSize,name,department);
        model.addAttribute("page",pageBeans);
        model.addAttribute("beans",pageBeans.getBeans());
        model.addAttribute("name",name);
        model.addAttribute("department",department);
        logger.info("访问【stuMag.do】接口；返回数据为："+pageBeans.toString());
        return "back/hubestl/list";
    }

    /**
     *  跳转到新增页面
     */
    @RequestMapping("/hubestl_add.do")
    public String add(HttpServletRequest request, HttpServletResponse response, ModelMap model ){
        //查询学院002
        List<Dict> facultys = dictService.selectDiceByKey("002");
        //查询部门003
        List<Dict> departments = dictService.selectDiceByKey("003");
        //查询性别004
        List<Dict> sexs = dictService.selectDiceByKey("004");
        model.addAttribute("facultys",facultys);
        model.addAttribute("departments",departments);
        model.addAttribute("sexs",sexs);
        return "back/hubestl/add";
    }

    /**
     *  保存
     */
    @RequestMapping("/hubestl_save.do")
    public String add(HttpServletRequest request, HttpServletResponse response, ModelMap model ,Hubestl hubestl){
        logger.info("访问【hubestl_save.do】接口；接收到的数据为："+hubestl.toString());
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        hubestl.setCreatetime(df.format(day));
        hubestl.setIsquit(1);
        hubestlService.insertHubestl(hubestl);

        return list(request,response,model,null,null,null,null);
    }

    /**
     * hubestlEdit
     */
    @RequestMapping("/hubestlEdit.do")
    public String hubestlEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                              @RequestParam(value = "user_id", required = false)Integer user_id){

        Hubestl hubestl = hubestlService.selectUserById(user_id);
        model.addAttribute("hubestl",hubestl);
        //查询学院002
        List<Dict> facultys = dictService.selectDiceByKey("002");
        //查询部门003
        List<Dict> departments = dictService.selectDiceByKey("003");
        //查询性别004
        List<Dict> sexs = dictService.selectDiceByKey("004");
        model.addAttribute("facultys",facultys);
        model.addAttribute("departments",departments);
        model.addAttribute("sexs",sexs);
        return "back/hubestl/edit";
    }

    /**
     * hubestlUpdate
     */
    @RequestMapping("/hubestlUpdate.do")
    public String hubestlUpdate(HttpServletRequest request, HttpServletResponse response, ModelMap model ,Hubestl hubestl){
        hubestlService.update(hubestl);

        return list(request,response,model,null,null,null,null);
    }

}
