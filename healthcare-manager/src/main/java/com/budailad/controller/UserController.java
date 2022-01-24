package com.budailad.controller;

import com.budailad.entity.User;
import com.budailad.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/list")
    public String list(){
        return userServices.list().toString();
    }

    @PostMapping("/login")
    public int login(@RequestBody User user) {
        User resultUser = userServices.login(user);
        int i = 0;
        if (resultUser != null ) {
            i = 1;
        }
        return i;
    }
}