package com.gds.dao;

import com.gds.entity.ActivityRoom;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("ActivityRoomMapper")
public interface ActivityRoomMapper {
    int deleteByPrimaryKey(Integer roomId);

    int insert(ActivityRoom record);

    int insertSelective(ActivityRoom record);

    ActivityRoom selectByPrimaryKey(Integer roomId);

    int updateByPrimaryKeySelective(ActivityRoom record);

    int updateByPrimaryKey(ActivityRoom record);

    Integer selectCount(Map map);

    List<ActivityRoom> selectListByMap(Map map);
}