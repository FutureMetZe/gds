package com.gds.service;

import com.gds.entity.Banners;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BannersService")
public interface BannersService {

    List<Banners> selectAllBanners();
}
