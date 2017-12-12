package com.gds.dao;

import com.gds.entity.Club;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("StuAndClubDao")
public interface StuAndClubDao {

    void insertRelation(Map<String, Integer> map);

    List<Club> selectStudentClubByStu_num(String stu_num);
}
