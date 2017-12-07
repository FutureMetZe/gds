package com.gds.service;

import com.gds.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StudentService")
public interface StudentService {
    List<Student> findAllStudent();
}
