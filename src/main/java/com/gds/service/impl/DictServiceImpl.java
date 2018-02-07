package com.gds.service.impl;

import com.gds.dao.DictDao;
import com.gds.entity.Dict;
import com.gds.service.DictService;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("DictService")
public class DictServiceImpl implements DictService{

    @Resource(name="DictDao")
    private DictDao dictDao;

    @Override
    public List<Dict> selectDiceByKey(String str) {
        return dictDao.selectDiceByKey(str);
    }

    @Override
    public PageBean<Dict> selectDictPageList(Integer currentPage, Integer pageSize, String keyNum, String keyName) {

        Map map = new HashMap();
        map.put("keyNum",keyNum);
        map.put("keyName",keyName);

        //1.查询总数
        Integer totalCount = dictDao.selectClubCount(map);
        //2.创建分页对象
        PageBean<Dict> pageBean = new PageBean<Dict>(currentPage,totalCount,pageSize);
        //3 调用Dao查询分页列表数据
        Integer startRow = pageBean.getStart();
        Integer size = pageBean.getPageSize();
        map.put("startRow",startRow);
        map.put("size",size);
        //3.条件查询对象列表，将查找对象列表放入分页对象

        List<Dict> beans = dictDao.selectClubList(map);
        pageBean.setBeans(beans);

        return pageBean;
    }

    @Override
    public void insertDict(Dict dict) {
        dictDao.insertSelective(dict);
    }

    @Override
    public Dict selectDiceById(Integer dictId) {
        return dictDao.selectByPrimaryKey(dictId);
    }

    @Override
    public void deleteDiceById(Integer dictId) {
        dictDao.deleteByPrimaryKey(dictId);
    }
}
