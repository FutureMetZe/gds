package com.gds.service;

import com.gds.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public interface UserService {
    /**
     *  根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPwd(String username, String password);

    /**
     *  获取用户
     * @return
     */
    public List<User> find(User User);

    /**
     *  新增
     * @param User
     */
    public void add(User User);

    /**
     *  修改
     * @param User
     */
    public void update(User User);

    /**
     *  删除
     * @param id
     */
    public void delete(String id);

}
