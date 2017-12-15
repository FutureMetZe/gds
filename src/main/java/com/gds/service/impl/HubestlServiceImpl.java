package com.gds.service.impl;

import com.gds.dao.HubestlDao;
import com.gds.entity.Hubestl;
import com.gds.service.HubestlService;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("HubestlService")
public class HubestlServiceImpl implements HubestlService{

    @Resource(name="HubestlDao")
    private HubestlDao hubestlDao;

    @Override
    public PageBean<Hubestl> selectPageList(Integer currentPage, Integer pageSize, String name, String department) {
        Map map = new HashMap();
        map.put("name",name);
        map.put("department",department);
        Integer totalCount = hubestlDao.selectCount(map);
        PageBean<Hubestl> pageBean = new PageBean<Hubestl>(currentPage,totalCount,pageSize);
        Integer startRow = pageBean.getStart();
        Integer size = pageBean.getPageSize();
        map.put("startRow",startRow);
        map.put("size",size);
        List<Hubestl> beans = hubestlDao.selectListByMap(map);
        pageBean.setBeans(beans);

        return pageBean;
    }

    @Override
    public void insertHubestl(Hubestl hubestl) {
        hubestlDao.insert(hubestl);
    }
}
