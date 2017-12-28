package com.gds.service;

import com.gds.entity.Goods;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

@Service("GoodsService")
public interface GoodsService {

    PageBean<Goods> selectClubPageList(Integer currentPage, Integer pageSize, String goodsName, String goodsDepartment);

    int insert(Goods goods);

    Goods selectById(Integer goodsId);

    void updateGoods(Goods goods);
}
