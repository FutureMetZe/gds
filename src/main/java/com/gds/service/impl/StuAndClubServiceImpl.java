package com.gds.service.impl;

import com.gds.dao.StuAndClubDao;
import com.gds.entity.Club;
import com.gds.service.StuAndClubService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("StuAndClubService")
public class StuAndClubServiceImpl implements StuAndClubService{

    @Resource(name="StuAndClubDao")
    private StuAndClubDao stuAndClubDao;

    @Override
    public void insertRelation(String stu_num, Integer club_id) {

        Map map = new HashMap();
        map.put("stu_num",stu_num);
        map.put("club_id",club_id);

        stuAndClubDao.insertRelation(map);

    }

    @Override
    public List<Club> selectStudentClubByStu_num(String stu_num) {
        return stuAndClubDao.selectStudentClubByStu_num(stu_num);
    }
}
