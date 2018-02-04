package com.gds.service;

import com.gds.entity.Club;
import com.gds.entity.StuAndClub;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StuAndClubService")
public interface StuAndClubService {
    void insertRelation(String stuNum, Integer club_id);

    List<StuAndClub> selectStudentClubByStu_num(String stu_num);
}
