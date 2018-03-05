package com.gds.service;

import com.gds.entity.Club;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClubService")
public interface ClubService {

    List<Club> selectAll();

    Club selectClubById(Integer stuClubId);

    PageBean<Club> selectClubPageList(Integer currentPage, Integer pageSize, String club_name, String club_faculty);

    void insertClub(Club club);

    void deleteByClubId(Integer club_id);

    List<Club> selectClubByType(String club_type);

    Integer selectCount();

    Club selectClubByPassword(String username, String password);
}
