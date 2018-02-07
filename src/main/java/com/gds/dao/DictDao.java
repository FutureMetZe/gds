package com.gds.dao;

import com.gds.entity.Dict;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("DictDao")
public interface DictDao {
    int deleteByPrimaryKey(Integer dictId);

    int insert(Dict record);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(Integer dictId);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);

    List<Dict> selectDiceByKey(String keyId);

    Integer selectClubCount(Map map);

    List<Dict> selectClubList(Map map);

}
