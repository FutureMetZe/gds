package com.gds.dao;

import com.gds.entity.Post;
import com.gds.entity.PostReview;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("PostReviewMapper")
public interface PostReviewMapper {
    int deleteByPrimaryKey(Integer reviewId);

    int insert(PostReview record);

    int insertSelective(PostReview record);

    PostReview selectByPrimaryKey(Integer reviewId);

    int updateByPrimaryKeySelective(PostReview record);

    int updateByPrimaryKey(PostReview record);

    Integer selectPostReviewCount(Map map);

    List<PostReview> selectPostReviewList(Map map);

    //按照时间排序
    List<PostReview> selectReviewByTime();
}