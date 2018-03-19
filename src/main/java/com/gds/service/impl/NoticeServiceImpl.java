package com.gds.service.impl;

import com.gds.dao.AssetsNoticeMapper;
import com.gds.entity.AssetsNotice;
import com.gds.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {

    @Resource(name = "AssetsNoticeMapper")
    private AssetsNoticeMapper assetsNoticeMapper;

    @Override
    public List<AssetsNotice> selectNoticesByClubName(String clubName) {
        return assetsNoticeMapper.selectNoticesByClubName(clubName);
    }

    @Override
    public AssetsNotice selectFirstNotice() {
        return assetsNoticeMapper.selectFirstNotice();
    }
}
