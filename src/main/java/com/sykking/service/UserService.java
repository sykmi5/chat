package com.sykking.service;

import com.sykking.entity.User;

public interface UserService {
    Integer addUser(User user);

    User queryUser(String name);
}
