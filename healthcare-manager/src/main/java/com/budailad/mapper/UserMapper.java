package com.budailad.mapper;

import com.budailad.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> list();

    User get(String id);

    User login(User user);
}
