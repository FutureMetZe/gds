package com.gds.service.impl;

import com.gds.dao.BannersMapper;
import com.gds.entity.ActivityRoom;
import com.gds.entity.Banners;
import com.gds.service.BannersService;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("BannersService")
public class BannersServiceImpl implements BannersService{

    @Resource(name = "BannersMapper")
    private BannersMapper bannersMapper;

    @Override
    public List<Banners> selectAllBanners() {
        return bannersMapper.selectAllBanners();
    }

    @Override
    public PageBean<Banners> selectBannersPageList(Integer currentPage, Integer pageSize) {
        Map map = new HashMap();
        Integer totalCount = bannersMapper.selectCount(map);
        PageBean<Banners> pageBean = new PageBean<Banners>(currentPage,totalCount,pageSize);
        Integer startRow = pageBean.getStart();
        Integer size = pageBean.getPageSize();
        map.put("startRow",startRow);
        map.put("size",size);
        List<Banners> beans = bannersMapper.selectListByMap(map);
        pageBean.setBeans(beans);

        return pageBean;
    }

    @Override
    public void insertBanner(Banners banners) {
        bannersMapper.insertSelective(banners);
    }

    @Override
    public Banners selectBannerById(Integer bannersId) {
        return bannersMapper.selectByPrimaryKey(bannersId);
    }

    @Override
    public void updateBanner(Banners banners) {
        bannersMapper.updateByPrimaryKeySelective(banners);
    }
}
