package com.gds.service;

import org.springframework.stereotype.Service;

@Service("StuAndClubService")
public interface StuAndClubService {
    void insertRelation(String stuNum, Integer club_id);
}
