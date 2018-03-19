package com.gds.service.impl;

import com.gds.dao.StuAndClubMapper;
import com.gds.entity.StuAndClub;
import com.gds.service.StuAndClubService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("StuAndClubService")
public class StuAndClubServiceImpl implements StuAndClubService{

    @Resource(name="StuAndClubMapper")
    private StuAndClubMapper stuAndClubDao;

    @Override
    public void insertRelation(String stu_num, Integer club_id) {
        StuAndClub stuAndClub = new StuAndClub();
        stuAndClub.setDictClubId(club_id);
        stuAndClub.setStuNum(stu_num);
        stuAndClubDao.insert(stuAndClub);

    }

    @Override
    public List<StuAndClub> selectStudentClubByStuNum(String stu_num) {
        return stuAndClubDao.selectStudentClubByStuNum(stu_num);
    }

    @Override
    public List<StuAndClub> selectBeanByClubId(Integer clubId) {
        return stuAndClubDao.selectByClubId(clubId);
    }

    /**
     * 根据 学号 和 社团ID 查询学生社团映射
     * @param studentNum
     * @param clubId
     * @return
     */
    @Override
    public Integer selectCountByNumAndId(String studentNum, Integer clubId) {
        HashMap map = new HashMap();
        map.put("studentNum",studentNum);
        map.put("clubId",clubId);


        return stuAndClubDao.selectCountByNumAndId(map);
    }
}
