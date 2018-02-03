package com.gds.dao;

import com.gds.entity.Banners;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("BannersMapper")
public interface BannersMapper {
    int deleteByPrimaryKey(Integer bannersId);

    int insert(Banners record);

    int insertSelective(Banners record);

    Banners selectByPrimaryKey(Integer bannersId);

    int updateByPrimaryKeySelective(Banners record);

    int updateByPrimaryKey(Banners record);

    List<Banners> selectAllBanners();
}