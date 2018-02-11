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
import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("back")
public class ClubController {

    private Logger logger = Logger.getLogger(ClubController.class);

    @Resource(name="ClubService")
    private ClubService clubService;
    @Resource(name="DictService")
    private DictService dictService;

    @Resource(name = "StuAndClubService")
    private StuAndClubService stuAndClubService;

    @Resource(name = "StudentService")
    private StudentService studentService;

    /**
     * 组织列表
     */
    @RequestMapping("/clubList.do")
    public String clubList(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                         @RequestParam(value = "pageSize", required = false)Integer pageSize,
                         @RequestParam(value = "currentPage", required = false)Integer currentPage,
                         @RequestParam(value = "club_name", required = false)String club_name,
                         @RequestParam(value = "club_faculty", required = false)String club_faculty ){
        PageBean<Club> pageBeans = clubService.selectClubPageList(currentPage,pageSize,club_name,club_faculty);
        model.addAttribute("page",pageBeans);
        model.addAttribute("beans",pageBeans.getBeans());
        model.addAttribute("club_name",club_name);
        model.addAttribute("club_faculty",club_faculty);
        logger.info("访问【clubList.do】接口；返回数据为："+pageBeans.toString());
        return "back/club/list";
    }

    /**
     *  跳转到新增页面
     */
    @RequestMapping("/clubAdd.do")
    public String clubAdd(HttpServletRequest request, HttpServletResponse response, ModelMap model ){
        //从字典中获取 001社团类型
        List<Dict> clubType = dictService.selectDiceByKey("001");
        //从字典中获取 002学院
        List<Dict> facultys = dictService.selectDiceByKey("002");
        model.addAttribute("clubType",clubType);
        model.addAttribute("facultys",facultys);
        logger.info("访问【clubAdd.do】接口；返回数据为："+clubType.toString());
        logger.info(facultys.toString());
        return "back/club/add";
    }


    /**
     * 新增社团
     */
    @RequestMapping("/clubSave.do")
    public String clubSave(HttpServletRequest request, HttpServletResponse response, ModelMap model,Club club,
                           @RequestParam(value = "club_standby001", required = false)String club_standby001,
                           @RequestParam(value = "club_standby002", required = false)String club_standby002 ){

        logger.info("访问【clubSave.do】接口；接收到的数据为："+club.toString());
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        club.setClub_createtime(df.format(day));
        club.setClub_status(0);
        clubService.insertClub(club);
        //添加学生--社团id映射关系
        return clubList(request,response,model,null,null,null,null);
    }

    /**
     * 通过club_id删除社团
     */
    @RequestMapping("/clubDelete.do")
    public String clubDelete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                           @RequestParam(value = "club_id", required = false)Integer club_id ){
        clubService.deleteByClubId(club_id);
        return clubList(request,response,model,null,null,null,null);
    }


    /**
     * clubIntroduce
     * 查看社团详情
     */
    @RequestMapping("/clubIntroduce.do")
    public String clubIntroduce(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                             @RequestParam(value = "clubId", required = false)Integer clubId ){

        Club club = clubService.selectClubById(clubId);
        List<Student> students = new ArrayList<Student>();
        List<StuAndClub> lists = stuAndClubService.selectBeanByClubId(clubId);
        if (lists != null){
            for (int i = 0; i <lists.size() ; i++) {
                Student student = studentService.selectByStuNum(lists.get(i).getStuNum());
                students.add(student);
            }
        }
        model.addAttribute("club",club);
        model.addAttribute("students",students);
        model.addAttribute("stuCount",students.size());

        return "back/club/introduce";
    }

}
