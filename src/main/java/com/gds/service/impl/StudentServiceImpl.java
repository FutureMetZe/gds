package com.gds.service.impl;

import com.gds.dao.StudentDao;
import com.gds.entity.Student;
import com.gds.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    @Resource(name="StudentDao")
    private StudentDao studentDao;

    @Override
    public List<Student> findAllStudent() {
        return studentDao.findAllStudent();
    }
}
