package com.gds.dao;

import com.gds.entity.AssetsNotice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AssetsNoticeMapper")
public interface AssetsNoticeMapper {
    int deleteByPrimaryKey(Integer noticeId);

    int insert(AssetsNotice record);

    int insertSelective(AssetsNotice record);

    AssetsNotice selectByPrimaryKey(Integer noticeId);

    int updateByPrimaryKeySelective(AssetsNotice record);

    int updateByPrimaryKey(AssetsNotice record);

    List<AssetsNotice> selectNoticesByClubName(String clubName);

    AssetsNotice selectFirstNotice();
}