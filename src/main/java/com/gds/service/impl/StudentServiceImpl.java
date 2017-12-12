package com.gds.service.impl;

import com.gds.dao.StudentDao;
import com.gds.entity.Student;
import com.gds.service.StudentService;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    @Resource(name="StudentDao")
    private StudentDao studentDao;

    /**
     * 查询分页对象（beans为社员）
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Student> findAllStudent(Integer currentPage,Integer pageSize) {
        //1 调用Dao查询总记录数
        Integer totalCount = studentDao.selectTotalCount();

        //2 创建PageBean对象
        PageBean<Student> pb = new PageBean(currentPage, totalCount, pageSize);

        //3 调用Dao查询分页列表数据
        Integer startRow = pb.getStart();
        Integer size = pb.getPageSize();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("startRow",startRow);
        map.put("size",size);
        List<Student> students = studentDao.selectPageList(map);

        //4 列表数据放入pageBean中.并返回
        pb.setBeans(students);

        return pb;
    }

    @Override
    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }

    @Override
    public void deleteStuByUserId(Integer user_id) {
        studentDao.deleteStuByUserId(user_id);
    }
}
