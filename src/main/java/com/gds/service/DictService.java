package com.gds.service;

import com.gds.entity.Dict;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DictService")
public interface DictService {

    List<Dict> selectDiceByKey(String s);

    PageBean<Dict> selectDictPageList(Integer currentPage, Integer pageSize, String keyNum, String keyName);

    void insertDict(Dict dict);

    //根据主键查询
    Dict selectDiceById(Integer dictId);

    //根据主键删除
    void deleteDiceById(Integer dictId);
}
