package com.budailad.services;

import com.budailad.entity.User;

import java.util.List;

public interface UserServices {

    /**
     * Author:Budai 2022/1/6 19:15
     * @return List<User>
     */
    List<User> list();

    /**
     * Author:Budai 2022/1/27 14:25
     * @param id
     * @return User
     */
    User get(String id);

    /**
     * Author:Budai 2022/1/27 14:25
     * @param user
     * @return User
     */
    int add(User user);

    /**
     * Author:Budai 2022/1/27 14:25
     * @param user
     * @return User
     */
    User login(User user);

}
