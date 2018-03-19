package com.gds.dao;

import com.gds.entity.StuAndClub;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("StuAndClubMapper")
public interface StuAndClubMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StuAndClub record);

    int insertSelective(StuAndClub record);

    StuAndClub selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuAndClub record);

    int updateByPrimaryKey(StuAndClub record);

    List<StuAndClub> selectStudentClubByStuNum(String stu_num);

    List<StuAndClub> selectByClubId(Integer clubId);

    Integer selectCountByNumAndId(HashMap map);
}