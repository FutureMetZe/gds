package com.gds.dao;

import com.gds.entity.Dict;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DictDao")
public interface DictDao {
    List<Dict> selectDiceByKey(String keyId);

}
