package com.gds.service;

import com.gds.entity.Banners;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BannersService")
public interface BannersService {

    List<Banners> selectAllBanners();

    PageBean<Banners> selectBannersPageList(Integer currentPage, Integer pageSize);

    void insertBanner(Banners banners);

    Banners selectBannerById(Integer bannersId);

    void updateBanner(Banners banners);
}
