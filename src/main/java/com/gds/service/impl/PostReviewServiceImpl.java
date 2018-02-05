package com.gds.service.impl;

import com.gds.dao.PostMapper;
import com.gds.dao.PostReviewMapper;
import com.gds.entity.Post;
import com.gds.entity.PostReview;
import com.gds.service.PostReviewService;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("PostReviewService")
public class PostReviewServiceImpl implements PostReviewService {

    @Resource(name = "PostReviewMapper")
    private PostReviewMapper postReviewMapper;

    @Override
    public PageBean<PostReview> selectPostReviewPageList(Integer currentPage, Integer pageSize, String blogTitle, String reviewUserName ,Integer blogId) {

        Map map = new HashMap();
        map.put("blogTitle",blogTitle);
        map.put("reviewUserName",reviewUserName);
        map.put("blogId",blogId);

        //1.查询总数
        Integer totalCount = postReviewMapper.selectPostReviewCount(map);
        //2.创建分页对象
        PageBean<PostReview> pageBean = new PageBean<PostReview>(currentPage,totalCount,pageSize);
        //3 调用Dao查询分页列表数据
        Integer startRow = pageBean.getStart();
        Integer size = pageBean.getPageSize();
        map.put("startRow",startRow);
        map.put("size",size);
        //3.条件查询对象列表，将查找对象列表放入分页对象
        List<PostReview> beans = postReviewMapper.selectPostReviewList(map);
        pageBean.setBeans(beans);

        return pageBean;
    }

    //按照时间排序
    @Override
    public List<PostReview> selectReviewByTime(Integer row_num,String postType) {
        Map map = new HashMap();
        map.put("row_num",row_num);
        map.put("postType",postType);
        return postReviewMapper.selectReviewByTime(map);
    }

    @Override
    public void insertReview(PostReview postReview) {
        postReviewMapper.insert(postReview);
    }

    @Override
    public List<PostReview> selectReviewByUsername(String username) {
        Map map = new HashMap();
        map.put("username",username);
        return postReviewMapper.selectReviewByUsername(map);
    }
}
