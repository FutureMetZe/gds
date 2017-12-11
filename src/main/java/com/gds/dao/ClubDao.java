package com.gds.dao;

import com.gds.entity.Club;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ClubDao")
public interface ClubDao {

    List<Club> selectAll();

}
