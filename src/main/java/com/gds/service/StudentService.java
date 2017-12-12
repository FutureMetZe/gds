package com.gds.service;

import com.gds.entity.Student;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

@Service("StudentService")
public interface StudentService {
    PageBean<Student> selectPageList(Integer currentPage, Integer pageSize, String username, String stu_name, String standby001);

    void insertStudent(Student student);

    void deleteStuByUserId(Integer user_id);
}
