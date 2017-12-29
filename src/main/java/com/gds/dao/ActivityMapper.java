package com.gds.dao;

import com.gds.entity.Activity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("ActivityMapper")
public interface ActivityMapper {
    int deleteByPrimaryKey(Integer activityId);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer activityId);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    Integer selectCount(Map map);

    List<Activity> selectListByMap(Map map);
}