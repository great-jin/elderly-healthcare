package com.budailad.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.budailad.entity.User;
import com.budailad.mapper.UserMapper;
import com.budailad.services.UserServices;

import java.util.List;

@Service
@CacheConfig(cacheNames = "users")
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(key = "'list'")
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    @Cacheable(key = "#id")
    public User get(String id) {
        return userMapper.get(id);
    }

    @Override
    @Cacheable(key = "#user.accountID")
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
