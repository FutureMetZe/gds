package com.gds.dao;

import com.gds.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("StudentDao")
public interface StudentDao {

    List<Student> findAllStudent();

    Integer selectTotalCount();

    List<Student> selectPageList(Map<String,Object> map);

    void insertStudent(Student student);

    void deleteStuByUserId(Integer user_id);
}
