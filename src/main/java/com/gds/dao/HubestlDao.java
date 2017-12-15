package com.gds.dao;


import com.gds.entity.Hubestl;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("HubestlDao")
public interface HubestlDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Hubestl record);

    int insertSelective(Hubestl record);

    Hubestl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hubestl record);

    int updateByPrimaryKey(Hubestl record);

    Integer selectCount(Map map);

    List<Hubestl> selectListByMap(Map map);

}