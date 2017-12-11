package com.gds.service;

import com.gds.entity.Student;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StudentService")
public interface StudentService {
    PageBean<Student> findAllStudent(Integer currentPage, Integer pageSize);

    void insertStudent(Student student);

}
