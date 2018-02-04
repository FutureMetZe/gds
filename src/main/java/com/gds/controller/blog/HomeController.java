package com.gds.controller.blog;

import com.gds.entity.Club;
import com.gds.entity.StuAndClub;
import com.gds.entity.Student;
import com.gds.service.ClubService;
import com.gds.service.StuAndClubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blog/home")
public class HomeController {

    @Resource(name = "StuAndClubService")
    private StuAndClubService stuAndClubService;

    @Resource(name = "ClubService")
    private ClubService clubService;
    /**
     * 进入用户主页
     */
    @RequestMapping("/goHome.do")
    public String goHome(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("UserName");
        Student student = (Student) session.getAttribute("Student");

        String clubMessage = "";    //错误信息提示

        if (username!=null && !username.equals("")){

            //1,把学生对象传入个人主页
            model.addAttribute("student",student);

            //2,把学生所加入的社团信息传入主页
            List<Club> clubs = new ArrayList<Club>();
            List<StuAndClub> links = stuAndClubService.selectStudentClubByStu_num(student.getStu_num());
            if (links != null){
                for (int i = 0; i < links.size() ; i++) {
                    Club club = clubService.selectClubById(links.get(i).getDict_club_id());
                    clubs.add(club);
                }
            }else{
                //您还没有加入社团
                clubMessage = "您还没有加入社团";
            }
            model.addAttribute("clubs",clubs);
            model.addAttribute("clubMessage",clubMessage);

            System.out.println("student:"+student);
            System.out.println("clubs:"+clubs);
            System.out.println("clubMessage:"+clubMessage);

            //3,把学生发布的评论传入主页

            //4,把学生发布的文章ID，标题，日期，介绍，类型传入主页



            return "blog/home/HomePage";
        }else {
            return "blog/login";
        }
    }


}
