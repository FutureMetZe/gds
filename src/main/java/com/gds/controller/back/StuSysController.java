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
     * @param request
     * @param response
     * @param model
     * @return
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
     *  跳转到新增页面，将社团列表发送出去
     * @return
     */
    @RequestMapping("/stuAdd.do")
    public String add(HttpServletRequest request, HttpServletResponse response, ModelMap model ){
        //查询所有社团
        List<Club> clubs = clubService.selectAll();
        // 002 学院
        List<Dict> facultys = dictService.selectAllFaculty("002");
        model.addAttribute("clubs",clubs);
        model.addAttribute("facultys",facultys);
        logger.info("访问【stuAdd.do】接口；返回数据为："+clubs.toString());
        logger.info(facultys.toString());
        return "back/stu/add";
    }

    @RequestMapping("/stuSave.do")
    public String stuSave(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                          Student student, @RequestParam(value = "club_id", required = false)Integer club_id){
        logger.info("访问【stuSave.do】接口；接收到的数据为："+student.toString());
        studentService.insertStudent(student);
        stuAndClubService.insertRelation(student.getUser_id(),club_id);
        return stuMag(request,response,model,null,null);
    }

}
