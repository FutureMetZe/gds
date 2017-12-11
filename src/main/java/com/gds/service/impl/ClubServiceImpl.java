package com.gds.service.impl;

import com.gds.dao.ClubDao;
import com.gds.entity.Club;
import com.gds.service.ClubService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("ClubService")
public class ClubServiceImpl implements ClubService{

    @Resource(name="ClubDao")
    private ClubDao clubDao;


    @Override
    public List<Club> selectAll() {
        return clubDao.selectAll();
    }
}
