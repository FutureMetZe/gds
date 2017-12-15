package com.gds.service.impl;

import com.gds.dao.DictDao;
import com.gds.entity.Dict;
import com.gds.service.DictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("DictService")
public class DictServiceImpl implements DictService{

    @Resource(name="DictDao")
    private DictDao dictDao;

    @Override
    public List<Dict> selectDiceByKey(String str) {
        return dictDao.selectDiceByKey(str);
    }
}
