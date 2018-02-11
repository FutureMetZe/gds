package com.gds.dao;

import com.gds.entity.MyFile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("MyFileMapper")
public interface MyFileMapper {
    int deleteByPrimaryKey(Integer fileId);

    int insert(MyFile record);

    int insertSelective(MyFile record);

    MyFile selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKeySelective(MyFile record);

    int updateByPrimaryKey(MyFile record);

    Integer selectClubCount(Map map);

    List<MyFile> selectClubList(Map map);
}