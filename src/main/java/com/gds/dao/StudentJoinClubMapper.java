package com.gds.dao;

import com.gds.entity.StudentJoinClub;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("StudentJoinClubMapper")
public interface StudentJoinClubMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentJoinClub record);

    int insertSelective(StudentJoinClub record);

    StudentJoinClub selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentJoinClub record);

    int updateByPrimaryKey(StudentJoinClub record);

    List<StudentJoinClub> selectBeanByClubId(Integer clubId);

    void deleteStudentJoin(Map map);

    Integer selectCountByNumAndId(Map map);
}