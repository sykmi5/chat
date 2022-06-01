package com.sykking.dao;

import com.sykking.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    Integer insertUser(User user);

    User selectOne(String username);
}
