package com.budailad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.budailad.entity.User;
import com.budailad.dao.UserDao;
import com.budailad.service.UserService;

import java.util.List;

@Service
@CacheConfig(cacheNames = "patient")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Cacheable(key = "'list'")
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public User get(String id) {
        return userDao.get(id);
    }

    @Override
    @CacheEvict(key = "'list'")
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
