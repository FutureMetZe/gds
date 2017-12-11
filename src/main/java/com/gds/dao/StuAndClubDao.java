package com.gds.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("StuAndClubDao")
public interface StuAndClubDao {

    void insertRelation(Map<String, Integer> map);
}
