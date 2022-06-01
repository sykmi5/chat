package com.sykking.service.Impl;

import com.sykking.dao.UserDao;
import com.sykking.entity.User;
import com.sykking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public Integer addUser(User user) {
        Integer res = userDao.insertUser(user);
        return res;
    }

    @Override
    public User queryUser(String name) {
        User user = userDao.selectOne(name);
        return user;
    }
}
