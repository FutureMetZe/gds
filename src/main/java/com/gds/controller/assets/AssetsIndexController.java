package com.gds.controller.assets;

import com.gds.entity.*;
import com.gds.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/assets")
public class AssetsIndexController {

    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AssetsIndexController.class);

    @Resource(name = "ClubService")
    private ClubService clubService;

    @Resource(name = "StuAndClubService")
    private StuAndClubService stuAndClubService;

    @Resource(name = "StudentService")
    private StudentService studentService;

    @Resource(name = "StudentJoinService")
    private StudentJoinService studentJoinService;

    @Resource(name = "GoodsService")
    private GoodsService goodsService;

    @Resource(name = "ActivityRoomService")
    private ActivityRoomService activityRoomService;

    @Resource(name = "NoticeService")
    private NoticeService noticeService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("/admin-index.do")
    public String main(HttpServletRequest request, HttpServletResponse response, ModelMap model){

        //1.获取到社团的信息
        Integer clubId = Integer.parseInt(request.getSession().getAttribute("clubId").toString());
        Club club = clubService.selectClubById(clubId);

        model.addAttribute("club",club);

        //2.获取到学生的list
        List<Student> students = new ArrayList<Student>();
        List<StuAndClub> list1 = stuAndClubService.selectBeanByClubId(clubId);
        if (list1 != null){
            for (int i = 0; i <list1.size() ; i++) {
                Student student = studentService.selectByStuNum(list1.get(i).getStuNum());
                students.add(student);
            }
        }

        model.addAttribute("students",students);

        //3.获取到新的申请
        List<Student> joins = new ArrayList<Student>();
        //申请映射列表
        List<StudentJoinClub> lists = studentJoinService.selectBeanByClubId(clubId);
        if (lists != null){
            for (int i = 0; i <lists.size() ; i++) {
                Student student = studentService.selectByStuNum(lists.get(i).getStudentNum());
                joins.add(student);
            }
        }

        model.addAttribute("joinSize",joins.size());


        //4.获取到最新的公告
        AssetsNotice notice = noticeService.selectFirstNotice();
        model.addAttribute("notice",notice);

        return "assets/admin-index";
    }

    /**
     *  学生加入社团申请列表
     */
    @RequestMapping("/studentJoinList.do")
    public String studentJoinList(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        HttpSession session = request.getSession();
        Integer clubId = Integer.parseInt(session.getAttribute("clubId").toString());
        if(clubId == null ){
            return "redirect:/blog/login.do";
        }
        Club club = clubService.selectClubById(clubId);

        List<Student> students = new ArrayList<Student>();

        //申请映射列表
        List<StudentJoinClub> lists = studentJoinService.selectBeanByClubId(clubId);
        if (lists != null){
            for (int i = 0; i <lists.size() ; i++) {
                Student student = studentService.selectByStuNum(lists.get(i).getStudentNum());
                students.add(student);
            }
        }

        model.addAttribute("club",club);
        model.addAttribute("students",students);
        model.addAttribute("stuCount",students.size());

        return "assets/studentJoinList";

    }

    /**
     * 同意学生的申请
     */
    @RequestMapping("/agreeStudent.do")
    public String agreeStudent(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                               @RequestParam(value = "studentNum", required = false)String studentNum) {
        HttpSession session = request.getSession();
        Integer clubId = Integer.parseInt(session.getAttribute("clubId").toString());

        stuAndClubService.insertRelation(studentNum,clubId);
        return studentJoinList(request,response,model);

    }

    /**
     * 拒绝学生请求 disagreeStudent
     */
    @RequestMapping("/disagreeStudent.do")
    public String disagreeStudent(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                  @RequestParam(value = "studentNum", required = false)String studentNum) {
        HttpSession session = request.getSession();
        Integer clubId = Integer.parseInt(session.getAttribute("clubId").toString());

        studentJoinService.deleteStudentJoin(clubId,studentNum);

        return studentJoinList(request,response,model);

    }


    /**
     *   社团成员列表
     */
    @RequestMapping("/studentList.do")
    public String studentList(HttpServletRequest request, HttpServletResponse response, ModelMap model){

        HttpSession session = request.getSession();
        Integer clubId = Integer.parseInt(session.getAttribute("clubId").toString());
        if(clubId == null ){
            return "redirect:/blog/login.do";
        }

        Club club = clubService.selectClubById(clubId);
        List<Student> students = new ArrayList<Student>();
        List<StuAndClub> lists = stuAndClubService.selectBeanByClubId(clubId);
        if (lists != null){
            for (int i = 0; i <lists.size() ; i++) {
                Student student = studentService.selectByStuNum(lists.get(i).getStuNum());
                students.add(student);
            }
        }
        logger.info("club:"+club);
        model.addAttribute("club",club);
        model.addAttribute("students",students);
        model.addAttribute("stuCount",students.size());

        return "assets/studentList";
    }

    /**
     * 注销学生 deleteStudent
     */
    @RequestMapping("/deleteStudent.do")
    public String deleteStudent(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                @RequestParam(value = "studentId", required = false)Integer studentId) {
      //  Integer studentId = (Integer) request.getAttribute("studentId");
        studentService.deleteStuByUserId(studentId);
        return studentList(request,response,model);
    }


    /**
     * 社团物资管理
     * @return
     */
    @RequestMapping("/studentGoods.do")
    public String studentGoods(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        HttpSession session = request.getSession();
        String clubName = session.getAttribute("clubName").toString();

        if( clubName==null || !clubName.equals("") ){
            List<Goods> goods = goodsService.selectGoodByName(clubName);
            //System.out.println(goods);
            if (goods!=null){
                model.addAttribute("goods",goods);
                model.addAttribute("Count",goods.size());

                return "assets/studentGoods";
            }
        }
        model.addAttribute("goods","");
        return "assets/studentGoods";



    }

    /**
     * 活动室管理
     * @return
     */
    @RequestMapping("/studentRooms.do")
    public String studentRooms(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        HttpSession session = request.getSession();
        String clubName = session.getAttribute("clubName").toString();

        if( clubName==null || !clubName.equals("") ){
            List<ActivityRoom> rooms = activityRoomService.selectRoomsByClubName(clubName);
            //System.out.println(goods);
            if (rooms!=null){
                model.addAttribute("rooms",rooms);
                model.addAttribute("Count",rooms.size());
                return "assets/studentRooms";
            }
        }
        model.addAttribute("rooms","");
        return "assets/studentRooms";
    }

    /**
     * 公告管理
     * @return
     */
    @RequestMapping("/studentNotice.do")
    public String studentNotice(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        HttpSession session = request.getSession();
        String clubName = session.getAttribute("clubName").toString();

        if( clubName==null || !clubName.equals("") ){
            List<AssetsNotice> notices = noticeService.selectNoticesByClubName(clubName);
            if (notices!=null){
                model.addAttribute("notices",notices);
                model.addAttribute("Count",notices.size());
                return "assets/studentNotice";
            }
        }

        model.addAttribute("notices","");
        return "assets/studentNotice";
    }


        @RequestMapping("/admin-form.do")
    public String form(){
        return "assets/admin-form";
    }

    @RequestMapping("/admin-help.do")
    public String help(){
        return "assets/admin-help";
    }

    @RequestMapping("/admin-table.do")
    public String table(){
        return "assets/admin-table";
    }


    /**
     * 新增会员
     * @return
     */
    @RequestMapping("/admin-user.do")
    public String addUser(){


        return "assets/admin-user";
    }


}
