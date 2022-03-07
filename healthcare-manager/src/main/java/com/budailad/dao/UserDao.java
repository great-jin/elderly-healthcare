package com.budailad.dao;

import com.budailad.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> list();

    User get(String id);

    int add(User user);

    User login(User user);
}
