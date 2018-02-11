package com.gds.service;

import com.gds.entity.Post;
import com.gds.entity.PostReview;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PostReviewService")
public interface PostReviewService {

    PageBean<PostReview> selectPostReviewPageList(Integer currentPage, Integer pageSize, String blogTitle, String reviewUserName,Integer blogId);

    List<PostReview> selectReviewByTime(Integer row_num,String postType);

    void insertReview(PostReview postReview);

    List<PostReview> selectReviewByUsername(String username);

    void deleteReviewById(Integer reviewId);

    Integer selectCount();
}
