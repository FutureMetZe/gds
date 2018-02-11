package com.gds.service.impl;


import com.gds.dao.MyFileMapper;
import com.gds.entity.MyFile;
import com.gds.service.FileService;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("FileService")
public class FileServiceImpl implements FileService {

    @Resource(name = "MyFileMapper")
    private MyFileMapper myFileMapper;

    @Override
    public int deleteByPrimaryKey(Integer fileId) {
        return myFileMapper.deleteByPrimaryKey(fileId);
    }

    @Override
    public int insert(MyFile record) {
        return myFileMapper.insert(record);
    }

    @Override
    public int insertSelective(MyFile record) {
        return myFileMapper.insertSelective(record);
    }

    @Override
    public MyFile selectByPrimaryKey(Integer fileId) {
        return myFileMapper.selectByPrimaryKey(fileId);
    }

    @Override
    public int updateByPrimaryKeySelective(MyFile record) {
        return myFileMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MyFile record) {
        return myFileMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageBean<MyFile> selectFilePageList(Integer currentPage, Integer pageSize, String fileName, String uploadUsername) {

        Map map = new HashMap();
        map.put("fileName",fileName);
        map.put("uploadUsername",uploadUsername);

        //1.查询总数
        Integer totalCount = myFileMapper.selectClubCount(map);
        //2.创建分页对象
        PageBean<MyFile> pageBean = new PageBean<MyFile>(currentPage,totalCount,pageSize);
        //3 调用Dao查询分页列表数据
        Integer startRow = pageBean.getStart();
        Integer size = pageBean.getPageSize();
        map.put("startRow",startRow);
        map.put("size",size);
        //3.条件查询对象列表，将查找对象列表放入分页对象

        List<MyFile> beans = myFileMapper.selectClubList(map);
        pageBean.setBeans(beans);

        return pageBean;
    }

    @Override
    public Integer selectCount() {
        return myFileMapper.selectClubCount(null);
    }
}
