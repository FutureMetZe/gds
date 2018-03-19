package com.gds.service;

import com.gds.entity.AssetsNotice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NoticeService")
public interface NoticeService {

    List<AssetsNotice> selectNoticesByClubName(String clubName);

    AssetsNotice selectFirstNotice();
}
