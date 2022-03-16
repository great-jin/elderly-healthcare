package com.budailad.service;

import com.budailad.entity.User;

import java.util.List;

public interface UserService {

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
    User get(String accountID);

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
