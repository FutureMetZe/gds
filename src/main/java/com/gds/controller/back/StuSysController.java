package com.gds.controller.back;

import com.gds.entity.Club;
import com.gds.entity.Dict;
import com.gds.entity.StuAndClub;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
     * 社员(学生)列表
     */
    @RequestMapping("/stuMag.do")
    public String stuMag(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                         @RequestParam(value = "pageSize", required = false)Integer pageSize,
                         @RequestParam(value = "currentPage", required = false)Integer currentPage,
                         @RequestParam(value = "username", required = false)String username,
                         @RequestParam(value = "stu_name", required = false)String stu_name,
                         @RequestParam(value = "standby001", required = false)String standby001 ){
        PageBean<Student> pageBeans = studentService.selectPageList(currentPage,pageSize,username,stu_name,standby001);

        model.addAttribute("page",pageBeans);
        model.addAttribute("beans",pageBeans.getBeans());
        model.addAttribute("username",username);
        model.addAttribute("stu_name",stu_name);
        model.addAttribute("standby001",standby001);

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
        List<Dict> facultys = dictService.selectDiceByKey("002");
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
        student.setRegisterTime(df.format(day));

        studentService.insertStudent(student);
        String stuNum = student.getStuNum();
        //添加学号--社团id映射关系
        stuAndClubService.insertRelation(stuNum,club01);
        return stuMag(request,response,model,null,null,null,null,null);
    }

    /**
     * 删除操作
     */
    @RequestMapping("/stuDelete.do")
    public String stuDelete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                          @RequestParam(value = "user_id", required = false)Integer user_id){
        logger.info("访问【stuDelete.do】接口；接收到的数据为：user_id="+user_id);
        studentService.deleteStuByUserId(user_id);
        return stuMag(request,response,model,null,null,null,null,null);
    }

    /**
     *  跳转到修改页面
     */
    @RequestMapping("/stuEdit.do")
    public String stuEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model ,
                          @RequestParam(value = "user_id", required = false)Integer user_id){
        logger.info("访问【stuEdit.do】接口；接收到的数据为：user_id="+user_id);
        Student student = studentService.selectByUserId(user_id);
        //查询所有社团
        List<Club> clubs = clubService.selectAll();
        //从字典中获取 002学院
        List<Dict> facultys = dictService.selectDiceByKey("002");
        //获取制定学生绑定的社团关系列表
//        List<Club> stuClub = stuAndClubService.selectStudentClubByStu_num(student.getStu_num());
//        Integer stuClubId = null;
//        Club club01 = clubService.selectClubById(stuClubId);
//        if(stuClub.size()>0){
//            stuClubId = stuClub.get(0).getClub_id();
//        }

        model.addAttribute("clubs",clubs);
        model.addAttribute("facultys",facultys);
        model.addAttribute("student",student);

        return "back/stu/edit";
    }


    /**
     * stuIntroduce
     * 查看社员详情
     */
    @RequestMapping("/stuIntroduce.do")
    public String stuIntroduce(HttpServletRequest request, HttpServletResponse response, ModelMap model ,
                          @RequestParam(value = "user_id", required = false)Integer user_id){
        logger.info("访问【stuIntroduce.do】接口；接收到的数据为：user_id="+user_id);
        //查询学生信息
        Student student = studentService.selectByUserId(user_id);

        //根据学号查询社团列表
        List<StuAndClub> lists = stuAndClubService.selectStudentClubByStuNum(student.getStuNum());
        List<Club> clubs = new ArrayList<Club>();
        for (int i = 0; i < lists.size() ; i++) {
            Club club = clubService.selectClubById(lists.get(i).getDictClubId());
            clubs.add(club);
        }

        model.addAttribute("student",student);
        model.addAttribute("clubs",clubs);

        return "back/stu/introduce";
    }

}
