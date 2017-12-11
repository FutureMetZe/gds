package com.gds.service.impl;

import com.gds.dao.StuAndClubDao;
import com.gds.service.StuAndClubService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("StuAndClubService")
public class StuAndClubServiceImpl implements StuAndClubService{

    @Resource(name="StuAndClubDao")
    private StuAndClubDao stuAndClubDao;

    @Override
    public void insertRelation(Integer user_id, Integer club_id) {

        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("user_id",user_id);
        map.put("club_id",club_id);

        stuAndClubDao.insertRelation(map);

    }
}
