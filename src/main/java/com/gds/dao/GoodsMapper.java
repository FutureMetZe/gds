package com.gds.dao;

import com.gds.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("GoodsMapper")
public interface GoodsMapper {
    int insert(Goods record);

    int insertSelective(Goods record);

    Integer selectCount(Map map);

    List<Goods> selectListByMap(Map map);


    Goods selectById(Integer goodsId);

    void updateGoods(Goods goods);
}