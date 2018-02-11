package com.gds.dao;

import com.gds.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("StudentDao")
public interface StudentDao {

    int insertSelective(Student record);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Integer selectTotalCount(Map map);

    List<Student> selectPageList(Map<String,Object> map);

    void insertStudent(Student student);

    void deleteStuByUserId(Integer user_id);

    Student selectByUserId(Integer user_id);

    Student selectByUsernameAndPassword(Map<String, String> map);

    Student selectByStuNum(Map<String,String> map );
}
