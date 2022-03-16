package com.budailad.http;

import com.budailad.entity.User;
import com.budailad.service.UserService;
import com.budailad.utils.RedisService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping(value = "/api/test/users")
public class RedisController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @GetMapping("/list")
    public List<User> get(@Param("accountID") String accountID){
        List<User> userList ;
        // 先从Redis数据库读取数据
        userList = (List<User>) redisService.get("users:list");
        // 如果未查询到数据再从MySQL中读取
        if(userList == null) {
            userList = userService.list();
            if (userList == null) {
                return null;
            } else {
                // 将查出来的数据存入Redis数据库
                redisService.set("users:list", userList,5);
            }
        }
        return userList;
    }

    @PostMapping("/add")
    public int update(@RequestBody User user) throws Exception {
        User userResult = userService.get(user.getAccountID());
        if (userResult == null) {
            // 删除缓存
            redisService.delete("users:list");
            return userService.add(user);
        } else {
            return 2;
        }
    }

}