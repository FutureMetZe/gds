package com.gds.dao;

import com.gds.entity.ActivityRoom;

public interface ActivityRoomMapper {
    int deleteByPrimaryKey(Integer roomId);

    int insert(ActivityRoom record);

    int insertSelective(ActivityRoom record);

    ActivityRoom selectByPrimaryKey(Integer roomId);

    int updateByPrimaryKeySelective(ActivityRoom record);

    int updateByPrimaryKey(ActivityRoom record);
}