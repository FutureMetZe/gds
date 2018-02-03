package com.gds.service.impl;

import com.gds.dao.PostMapper;
import com.gds.entity.Post;
import com.gds.service.BlogPostService;
import com.gds.utils.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service("BlogPostService")
public class BlogPostServiceImpl implements BlogPostService {
    @Resource(name="PostMapper")
    private PostMapper postMapper;

    @Override
    public PageBean<Post> selectClubPageList(Integer currentPage, Integer pageSize,
                                             String postTitle,String blogAuthor, String blogSort) {

        Map map = new HashMap();
        map.put("blogAuthor",blogAuthor);
        map.put("blogSort",blogSort);
        map.put("postTitle",postTitle);

        //1.查询总数
        Integer totalCount = postMapper.selectPostCount(map);
        //2.创建分页对象
        PageBean<Post> pageBean = new PageBean<Post>(currentPage,totalCount,pageSize);
        //3 调用Dao查询分页列表数据
        Integer startRow = pageBean.getStart();
        Integer size = pageBean.getPageSize();
        map.put("startRow",startRow);
        map.put("size",size);
        //3.条件查询对象列表，将查找对象列表放入分页对象
        List<Post> beans = postMapper.selectPostList(map);
        pageBean.setBeans(beans);

        return pageBean;
    }

    @Override
    public List<Post> selectPostByLevel() {

        return postMapper.selectPostByLevel();
    }

    @Override
    public List<Post> selectPostByTime() {
        return postMapper.selectPostByTime();
    }

    @Override
    public Post selectPostById(Integer blogId) {
        return postMapper.selectByPrimaryKey(blogId);
    }
}
