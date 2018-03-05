package com.gds.dao;

import com.gds.entity.Club;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("ClubDao")
public interface ClubDao {

    List<Club> selectAll();

    Club selectClubById(Integer club_id);

    Integer selectClubCount(Map map);

    List<Club> selectClubList(Map map);

    void insertClub(Club club);

    void deleteByClubId(Integer club_id);

    List<Club> selectClubByType(Map map);

    Club selectClubByPassword(Map map);
}
