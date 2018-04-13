package com.gds.controller.assets;

import com.gds.entity.*;
import com.gds.service.*;
import com.gds.service.impl.NoticeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
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
        model.addAttribute("NowTime",new Date());
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
        //4.获取到最新的公告
        AssetsNotice notice = noticeService.selectFirstNotice();
        model.addAttribute("notice",notice);
        model.addAttribute("NowTime",new Date());
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
        studentJoinService.deleteStudentJoin(clubId,studentNum);
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


        //4.获取到最新的公告
        AssetsNotice notice = noticeService.selectFirstNotice();
        model.addAttribute("notice",notice);
        model.addAttribute("NowTime",new Date());
        model.addAttribute("club",club);
        model.addAttribute("students",students);
        model.addAttribute("stuCount",students.size());

        return "assets/studentList";
    }

    /**
     * 注销学生与社团关联 deleteStudent
     */
    @RequestMapping("/deleteStudent.do")
    public String deleteStudent(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                @RequestParam(value = "stuNum", required = false)String stuNum) {
        HttpSession session = request.getSession();
        Integer clubId = Integer.parseInt(session.getAttribute("clubId").toString());
        if(clubId == null ){
            return "redirect:/blog/login.do";
        }
        stuAndClubService.deleteSCAById(clubId,stuNum);
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

        Integer clubId = Integer.parseInt(session.getAttribute("clubId").toString());
        if(clubId == null ){
            return "redirect:/blog/login.do";
        }

        Club club = clubService.selectClubById(clubId);


        //4.获取到最新的公告
        AssetsNotice notice = noticeService.selectFirstNotice();
        model.addAttribute("notice",notice);
        model.addAttribute("club",club);

        if( clubName==null || !clubName.equals("") ){
            List<Goods> goods = goodsService.selectGoodByName(clubName);
            //System.out.println(goods);
            if (goods!=null){
                model.addAttribute("goods",goods);
                model.addAttribute("Count",goods.size());

                return "assets/studentGoods";
            }
        }

        model.addAttribute("NowTime",new Date());
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

        Integer clubId = Integer.parseInt(session.getAttribute("clubId").toString());
        if(clubId == null ){
            return "redirect:/blog/login.do";
        }

        Club club = clubService.selectClubById(clubId);


        //4.获取到最新的公告
        AssetsNotice notice = noticeService.selectFirstNotice();
        model.addAttribute("notice",notice);
        model.addAttribute("club",club);

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

        Integer clubId = Integer.parseInt(session.getAttribute("clubId").toString());
        if(clubId == null ){
            return "redirect:/blog/login.do";
        }

        Club club = clubService.selectClubById(clubId);


        //4.获取到最新的公告
        AssetsNotice notice = noticeService.selectFirstNotice();
        model.addAttribute("notice",notice);
        model.addAttribute("club",club);

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




    /**
     * 发布公告
     * @return
     */
    @RequestMapping("/admin-user.do")
    public String addNotice(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        HttpSession session = request.getSession();
        String clubName = session.getAttribute("clubName").toString();

        Integer clubId = Integer.parseInt(session.getAttribute("clubId").toString());
        if(clubId == null ){
            return "redirect:/blog/login.do";
        }

        Club club = clubService.selectClubById(clubId);


        //4.获取到最新的公告
        AssetsNotice notice = noticeService.selectFirstNotice();
        model.addAttribute("notice",notice);
        model.addAttribute("club",club);

        return "assets/toAddNoticePage";
    }


    @RequestMapping("/saveNotice.do")
    public String table(AssetsNotice notice,HttpServletRequest request, HttpServletResponse response, ModelMap model){
        noticeService.insert(notice);
        return studentNotice(request,response,model);
    }

    /**
     * deleteNotice
     */
    @RequestMapping("/deleteNotice.do")
    public String deleteNotice( HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                @RequestParam(value = "noticeId", required = false)Integer noticeId){
        noticeService.deleteNoticeByID(noticeId);
        return studentNotice(request,response,model);
    }

    /**
     * toAddGoods 跳转到接物资页面
     */
    @RequestMapping("/toAddGoods.do")
    public String toAddGoods(HttpServletRequest request, HttpServletResponse response, ModelMap model){

        HttpSession session = request.getSession();
        String clubName = session.getAttribute("clubName").toString();
        Integer clubId = Integer.parseInt(session.getAttribute("clubId").toString());
        if(clubId == null ){
            return "redirect:/blog/login.do";
        }


        Club club = clubService.selectClubById(clubId);
        List<Goods> goods = goodsService.selectByRemain();

        //4.获取到最新的公告
        AssetsNotice notice = noticeService.selectFirstNotice();
        model.addAttribute("notice",notice);
        model.addAttribute("goods",goods);
        model.addAttribute("club",club);
        return "assets/toAddGoods";
    }

    /**
     * submitGood
     */
    @RequestMapping("/submitGood.do")
    public String submitGood(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                             @RequestParam(value = "goodsId", required = false)Integer goodsId){
        HttpSession session = request.getSession();
        String clubName = session.getAttribute("clubName").toString();
        Integer clubId = Integer.parseInt(session.getAttribute("clubId").toString());
        if(clubId == null ){
            return "redirect:/blog/login.do";
        }

        Club club = clubService.selectClubById(clubId);
        Goods good = goodsService.selectById(goodsId);
        good.setStandby003(club.getClub_name());
        goodsService.updateGoods(good);
        return studentGoods(request,response,model);
    }

    /**
     * returnGoods
     */
    @RequestMapping("/returnGoods.do")
    public String returnGoods(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                             @RequestParam(value = "goodId", required = false)Integer goodId){
        Goods good = goodsService.selectById(goodId);
        good.setStandby003("");
        good.setStandby002("");
        goodsService.updateGoods(good);

        return studentGoods(request,response,model);
    }


    /**
     * 借用新场地页面
     * toAddRoomPage
     */
    @RequestMapping("/toAddRoomPage.do")
    public String toAddRoomPage(HttpServletRequest request, HttpServletResponse response, ModelMap model){

        HttpSession session = request.getSession();
        String clubName = session.getAttribute("clubName").toString();
        Integer clubId = Integer.parseInt(session.getAttribute("clubId").toString());
        if(clubId == null ){
            return "redirect:/blog/login.do";
        }

        Club club = clubService.selectClubById(clubId);
        //获取到最新的公告
        AssetsNotice notice = noticeService.selectFirstNotice();
        model.addAttribute("notice",notice);
        model.addAttribute("club",club);
        List<ActivityRoom> rooms = activityRoomService.selectRemainRoom();
        model.addAttribute("rooms",rooms);
        return "assets/toAddRoomPage";
    }

    /**
     * submitRoom
     */
    @RequestMapping("/submitRoom.do")
    public String submitRoom(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                             @RequestParam(value = "roomId", required = false)Integer roomId,
                             @RequestParam(value = "plan02", required = false)String plan02
                             ){
        HttpSession session = request.getSession();
        String clubName = session.getAttribute("clubName").toString();
        Integer clubId = Integer.parseInt(session.getAttribute("clubId").toString());
        if(clubId == null ){
            return "redirect:/blog/login.do";
        }

        Club club = clubService.selectClubById(clubId);
        ActivityRoom room = activityRoomService.selectRoomById(roomId);
        room.setPlan02(plan02);
        room.setPlan01(club.getClub_name());
        activityRoomService.update(room);
        return studentRooms(request,response,model);
    }

    /**
     * returnRoom
     */
    @RequestMapping("/returnRoom.do")
    public String returnRoom(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                              @RequestParam(value = "roomId", required = false)Integer roomId){
        ActivityRoom room = activityRoomService.selectRoomById(roomId);
        room.setPlan01("");
        room.setRoomUseName("");
        room.setPlan02("");
        room.setRoomIsuse("");
        activityRoomService.update(room);

        return studentRooms(request,response,model);
    }




}