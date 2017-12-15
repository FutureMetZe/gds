package com.gds.service;

import com.gds.entity.Dict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DictService")
public interface DictService {

    List<Dict> selectDiceByKey(String s);

}
