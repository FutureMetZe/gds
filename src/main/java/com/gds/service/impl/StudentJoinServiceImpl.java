package com.gds.service.impl;

import com.gds.dao.StudentJoinClubMapper;
import com.gds.entity.StudentJoinClub;
import com.gds.service.StudentJoinService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("StudentJoinService")
public class StudentJoinServiceImpl implements StudentJoinService {

    @Resource(name = "StudentJoinClubMapper")
    private StudentJoinClubMapper studentJoinClubMapper;


    public List<StudentJoinClub> selectBeanByClubId(Integer clubId) {

        return studentJoinClubMapper.selectBeanByClubId(clubId);
    }


    public void deleteStudentJoin(Integer clubId, String stuNum) {
        Map map = new HashMap();
        map.put("clubId",clubId);
        map.put("stuNum",stuNum);
        studentJoinClubMapper.deleteStudentJoin(map);
    }


    public void insertJoin(StudentJoinClub studentJoinClub) {
        studentJoinClubMapper.insert(studentJoinClub);
    }

    @Override
    public Integer selectCountByNumAndId(String studentNum, Integer clubId) {
        Map map = new HashMap();
        map.put("studentNum",studentNum);
        map.put("clubId",clubId);
        return studentJoinClubMapper.selectCountByNumAndId(map);
    }
}
