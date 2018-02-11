package com.gds.service.impl;

import com.gds.dao.GoodsMapper;
import com.gds.entity.Goods;
import com.gds.service.GoodsService;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource(name="GoodsMapper")
    private GoodsMapper goodsMapper;

    @Override
    public PageBean<Goods> selectClubPageList(Integer currentPage, Integer pageSize, String goodsName, String goodsDepartment) {
        Map map = new HashMap();
        map.put("goodsName",goodsName);
        map.put("goodsDepartment",goodsDepartment);
        Integer totalCount = goodsMapper.selectCount(map);
        PageBean<Goods> pageBean = new PageBean<Goods>(currentPage,totalCount,pageSize);
        Integer startRow = pageBean.getStart();
        Integer size = pageBean.getPageSize();
        map.put("startRow",startRow);
        map.put("size",size);
        List<Goods> beans = goodsMapper.selectListByMap(map);
        pageBean.setBeans(beans);
        return pageBean;
    }

    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public Goods selectById(Integer goodsId) {
        return goodsMapper.selectById(goodsId);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsMapper.updateGoods(goods);
    }

    @Override
    public Integer selectCount() {
        return goodsMapper.selectCount(null);
    }
}
