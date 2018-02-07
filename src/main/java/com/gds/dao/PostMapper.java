package com.gds.dao;

import com.gds.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("PostMapper")
public interface PostMapper {
    int deleteByPrimaryKey(Integer blogId);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer blogId);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKeyWithBLOBs(Post record);

    int updateByPrimaryKey(Post record);

    //查询总数
    Integer selectPostCount(Map map);

    List<Post> selectPostList(Map map);

    //按照推荐级别查询
    List<Post> selectPostByLevel();

    //按照发布时间排序
    List<Post> selectPostByTime();

    List<Post> selectPostByTypeOrKeyword(Map map);

    List<Post> selectPostByUsername(Map map);

}