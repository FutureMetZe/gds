package com.gds.service;

import org.springframework.stereotype.Service;

@Service("StuAndClubService")
public interface StuAndClubService {
    void insertRelation(Integer user_id, Integer club_id);
}
