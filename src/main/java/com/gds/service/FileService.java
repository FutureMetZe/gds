package com.gds.service;

import com.gds.entity.MyFile;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

@Service("FileService")
public interface FileService {
    int deleteByPrimaryKey(Integer fileId);

    int insert(MyFile record);

    int insertSelective(MyFile record);

    MyFile selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKeySelective(MyFile record);

    int updateByPrimaryKey(MyFile record);

    PageBean<MyFile> selectFilePageList(Integer currentPage, Integer pageSize, String fileName, String uploadUsername);

    Integer selectCount();
}
