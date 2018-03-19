package com.gds.service.impl;

import com.gds.dao.ActivityRoomMapper;
import com.gds.entity.ActivityRoom;
import com.gds.service.ActivityRoomService;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ActivityRoomService")
public class ActivityRoomServiceImpl implements ActivityRoomService {

    @Resource(name="ActivityRoomMapper")
    private ActivityRoomMapper activityRoomMapper;

    @Override
    public PageBean<ActivityRoom> selectRoomPageList(Integer currentPage, Integer pageSize, String roomName, String roomIsUse) {


        Map map = new HashMap();
        map.put("roomName",roomName);
        map.put("roomIsUse",roomIsUse);

        Integer totalCount = activityRoomMapper.selectCount(map);
        PageBean<ActivityRoom> pageBean = new PageBean<ActivityRoom>(currentPage,totalCount,pageSize);
        Integer startRow = pageBean.getStart();
        Integer size = pageBean.getPageSize();
        map.put("startRow",startRow);
        map.put("size",size);
        List<ActivityRoom> beans = activityRoomMapper.selectListByMap(map);
        pageBean.setBeans(beans);
        return pageBean;

    }

    @Override
    public void insert(ActivityRoom activityRoom) {
        activityRoomMapper.insertSelective(activityRoom);
    }

    @Override
    public ActivityRoom selectRoomById(Integer roomId) {
        return activityRoomMapper.selectByPrimaryKey(roomId);
    }

    @Override
    public void deleteRoomById(Integer roomId) {
        activityRoomMapper.deleteByPrimaryKey(roomId);
    }

    @Override
    public Integer selectCount() {
        return activityRoomMapper.selectCount(null);
    }

    @Override
    public List<ActivityRoom> selectRoomsByClubName(String clubName) {

        return activityRoomMapper.selectRoomsByClubName(clubName);
    }
}
