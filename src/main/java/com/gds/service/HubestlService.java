package com.gds.service;

import com.gds.entity.Hubestl;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

@Service("HubestlService")
public interface HubestlService {

    PageBean<Hubestl> selectPageList(Integer currentPage, Integer pageSize, String name, String department);

    void insertHubestl(Hubestl hubestl);
}
