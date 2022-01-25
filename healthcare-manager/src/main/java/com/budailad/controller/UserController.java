package com.budailad.controller;

import com.budailad.entity.User;
import com.budailad.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import java.security.Key;

import static com.sun.deploy.cache.Cache.getKey;

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
        String pwdCode = user.getPassword();
        Key secretKey = getKey("fendo888");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] c = decoder.decodeBuffer(pwdCode);
            byte[] result = cipher.doFinal(c);
            String plainText = new String(result, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        User resultUser = userServices.login(user);
        int i = 0;
        if (resultUser != null ) {
            i = 1;
        }
        return i;
    }
}