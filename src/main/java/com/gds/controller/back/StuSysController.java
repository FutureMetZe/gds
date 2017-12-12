package com.gds.controller.back;

import com.gds.entity.Club;
import com.gds.entity.Dict;
import com.gds.entity.Student;
import com.gds.service.ClubService;
import com.gds.service.DictService;
import com.gds.service.StuAndClubService;
import com.gds.service.StudentService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/back")
public class StuSysController {

    private Logger logger = Logger.getLogger(StuSysController.class);

    @Resource(name="StudentService")
    private StudentService studentService;

    @Resource(name="ClubService")
    private ClubService clubService;

    @Resource(name="DictService")
    private DictService dictService;

    @Resource(name="StuAndClubService")
    private StuAndClubService stuAndClubService;

    /**
     * 条件查询
     */
    @RequestMapping("/stuFind.do")
    public String stuFind(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                          @RequestParam(value = "username", required = false)String username,
                          @RequestParam(value = "stu_name", required = false)String stu_name,
                          @RequestParam(value = "standby001", required = false)String standby001 ){
        logger.info("访问【stuFind.do】接口；接收到的数据为：username="+username+"；stu_name="+stu_name+"；standby001="+standby001);
        Map<String,String> map = new HashMap<String, String>();
      //  List<Student> list = studentService.selectStuByCondition(map);
        return stuMag(request,response,model,null,null);
    }

    /**
     * 社员(学生)列表
     */
    @RequestMapping("/stuMag.do")
    public String stuMag(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                         @RequestParam(value = "pageSize", required = false)Integer pageSize,
                         @RequestParam(value = "currentPage", required = false)Integer currentPage ){
        PageBean<Student> pageBeans = studentService.findAllStudent(currentPage,pageSize);
        model.addAttribute("page",pageBeans);
        model.addAttribute("beans",pageBeans.getBeans());
        logger.info("访问【stuMag.do】接口；返回数据为："+pageBeans.toString());
        return "back/stu/stuMag";
    }

    /**
     *  跳转到新增页面
     */
    @RequestMapping("/stuAdd.do")
    public String add(HttpServletRequest request, HttpServletResponse response, ModelMap model ){
        //查询所有社团
        List<Club> clubs = clubService.selectAll();
        //从字典中获取 002学院
        List<Dict> facultys = dictService.selectAllFaculty("002");
        model.addAttribute("clubs",clubs);
        model.addAttribute("facultys",facultys);
        logger.info("访问【stuAdd.do】接口；返回数据为："+clubs.toString());
        logger.info(facultys.toString());
        return "back/stu/add";
    }

    /**
     * 保存学生信息，保存学号--社团id映射
     */
    @RequestMapping("/stuSave.do")
    public String stuSave(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                          Student student, @RequestParam(value = "club01", required = false)Integer club01){

        logger.info("访问【stuSave.do】接口；接收到的数据为："+student.toString());
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        student.setRegister_time(df.format(day));

        studentService.insertStudent(student);
        String stuNum = student.getStu_num();
        //添加学号--社团id映射关系
        stuAndClubService.insertRelation(stuNum,club01);
        return stuMag(request,response,model,null,null);
    }

    /**
     * 删除操作
     */
    @RequestMapping("/stuDelete.do")
    public String stuDelete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                          @RequestParam(value = "user_id", required = false)Integer user_id){
        logger.info("访问【stuDelete.do】接口；接收到的数据为：user_id="+user_id);
        studentService.deleteStuByUserId(user_id);
        return stuMag(request,response,model,null,null);
    }



}
