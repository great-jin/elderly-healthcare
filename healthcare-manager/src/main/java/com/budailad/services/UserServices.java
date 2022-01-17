package com.budailad.services;

import org.springframework.cache.annotation.CacheConfig;
import com.budailad.entity.User;

import java.util.List;

@CacheConfig(cacheNames = "users")
public interface UserServices {

    /**
     * Author:Budai 2022/1/6 19:15
     * @return List<User>
     */
    List<User> list();

}
