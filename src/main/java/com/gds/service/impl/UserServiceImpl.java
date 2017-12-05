package com.gds.service.impl;

import com.gds.dao.UserDao;
import com.gds.entity.User;
import com.gds.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource(name = "UserDao")
    private UserDao userDao;

    public User findByUsernameAndPwd(String name, String pwd) {

        return userDao.findByUsernameAndPwd(name, pwd);
    }

    public List<User> find(User user){

        return userDao.find(user);
    }


    public void add(User user) {

        userDao.add(user);
    }

    public void update(User user) {

        userDao.update(user);
    }

    public void delete(String id) {

        userDao.delete(id);
    }
}
