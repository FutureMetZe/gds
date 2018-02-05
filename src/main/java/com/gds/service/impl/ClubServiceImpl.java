package com.gds.service.impl;

import com.gds.dao.ClubDao;
import com.gds.entity.Club;
import com.gds.service.ClubService;
import com.gds.utils.PageBean;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service("ClubService")
public class ClubServiceImpl implements ClubService{

    @Resource(name="ClubDao")
    private ClubDao clubDao;


    @Override
    public List<Club> selectAll() {
        return clubDao.selectAll();
    }

    @Override
    public Club selectClubById(Integer stuClubId) {
        return clubDao.selectClubById(stuClubId);
    }

    @Override
    public PageBean<Club> selectClubPageList(Integer currentPage, Integer pageSize, String club_name, String club_faculty) {

        Map map = new HashMap();
        map.put("club_name",club_name);
        map.put("club_faculty",club_faculty);

        //1.查询总数
        Integer totalCount = clubDao.selectClubCount(map);
        //2.创建分页对象
        PageBean<Club> pageBean = new PageBean<Club>(currentPage,totalCount,pageSize);
        //3 调用Dao查询分页列表数据
        Integer startRow = pageBean.getStart();
        Integer size = pageBean.getPageSize();
        map.put("startRow",startRow);
        map.put("size",size);
        //3.条件查询对象列表，将查找对象列表放入分页对象
        List<Club> beans = clubDao.selectClubList(map);
        pageBean.setBeans(beans);

        return pageBean;
    }

    @Override
    public void insertClub(Club club) {
        clubDao.insertClub(club);
    }

    @Override
    public void deleteByClubId(Integer club_id) {
        clubDao.deleteByClubId(club_id);
    }

    @Override
    public List<Club> selectClubByType(String club_type) {
        Map map = new HashMap();
        map.put("club_type",club_type);
        return clubDao.selectClubByType(map);
    }

}
