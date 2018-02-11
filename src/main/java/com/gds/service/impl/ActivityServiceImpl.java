package com.gds.service.impl;

import com.gds.dao.ActivityMapper;
import com.gds.entity.Activity;
import com.gds.service.ActivityService;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ActivityService")
public class ActivityServiceImpl implements ActivityService {

    @Resource(name="ActivityMapper")
    private ActivityMapper activityMapper;

    @Override
    public PageBean<Activity> selectActivityPageList(Integer currentPage, Integer pageSize, String activityTitle, String sponsor,String plan003) {

        Map map = new HashMap();
        map.put("activityTitle",activityTitle);
        map.put("sponsor",sponsor);
        map.put("plan003",plan003);
        Integer totalCount = activityMapper.selectCount(map);
        PageBean<Activity> pageBean = new PageBean<Activity>(currentPage,totalCount,pageSize);
        Integer startRow = pageBean.getStart();
        Integer size = pageBean.getPageSize();
        map.put("startRow",startRow);
        map.put("size",size);
        List<Activity> beans = activityMapper.selectListByMap(map);
        pageBean.setBeans(beans);
        return pageBean;

    }

    @Override
    public void insertSelective(Activity activity) {
        activityMapper.insertSelective(activity);
    }

    @Override
    public Integer selectCount() {
        return activityMapper.selectCount(null);
    }
}
