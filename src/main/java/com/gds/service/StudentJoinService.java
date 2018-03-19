package com.gds.service;

import com.gds.entity.StudentJoinClub;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StudentJoinService")
public interface StudentJoinService {

    List<StudentJoinClub> selectBeanByClubId(Integer clubId);

    void deleteStudentJoin(Integer clubId, String stuNum);

    void insertJoin(StudentJoinClub studentJoinClub);

    Integer selectCountByNumAndId(String studentNum, Integer clubId);
}
