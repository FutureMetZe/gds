package com.gds.dao;

import com.gds.entity.Goods;

public interface GoodsMapper {
    int insert(Goods record);

    int insertSelective(Goods record);
}