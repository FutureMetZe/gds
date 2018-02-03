package com.gds.service.impl;

import com.gds.dao.BannersMapper;
import com.gds.entity.Banners;
import com.gds.service.BannersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("BannersService")
public class BannersServiceImpl implements BannersService{

    @Resource(name = "BannersMapper")
    private BannersMapper bannersMapper;

    @Override
    public List<Banners> selectAllBanners() {
        return bannersMapper.selectAllBanners();
    }
}
