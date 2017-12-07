package com.gds.dao;

import com.gds.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("StudentDao")
public interface StudentDao {

    List<Student> findAllStudent();
}
