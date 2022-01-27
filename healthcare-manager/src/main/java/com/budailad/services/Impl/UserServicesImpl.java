package com.budailad.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.budailad.entity.User;
import com.budailad.mapper.UserMapper;
import com.budailad.services.UserServices;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public User get(String id) {
        return userMapper.get(id);
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
