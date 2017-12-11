package com.gds.service;

import com.gds.entity.Club;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClubService")
public interface ClubService {

    List<Club> selectAll();
}
