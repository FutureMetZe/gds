package com.gds.service;

import com.gds.entity.ActivityRoom;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ActivityRoomService")
public interface ActivityRoomService {
    PageBean<ActivityRoom> selectRoomPageList(Integer currentPage, Integer pageSize, String roomName, String roomIsUse);

    void insert(ActivityRoom activityRoom);

    ActivityRoom selectRoomById(Integer roomId);

    void deleteRoomById(Integer roomId);

    Integer selectCount();

    List<ActivityRoom> selectRoomsByClubName(String clubName);
}
