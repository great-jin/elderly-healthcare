package com.budailad.controller;

import com.budailad.entity.User;
import com.budailad.services.UserServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import static com.budailad.utils.AESUtil.desEncrypt;
import static com.budailad.utils.AESUtil.encrypt;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final static String KEY_FRONT = "byouthinvincible";
    private final static String IV_FRONT = "byouthinvincible";

    private final static String KEY_BACK = "dyouthinvincible";
    private final static String IV_BACK = "dyouthinvincible";

    @Autowired
    private UserServices userServices;

    @GetMapping("/list")
    public String list(){
        return userServices.list().toString();
    }

    /**
     * @Description:  获取前端加密进行解密，获取后端加密进行解密
     */
    @PostMapping("/login")
    public int login(@RequestBody User user) throws Exception {
        // 前端解密
        String frontEnPwd = user.getPassword();
        String frontDePwd = desEncrypt(frontEnPwd, KEY_FRONT, IV_FRONT).trim();

        User resultUser = userServices.get(user.getAccountID());
        if (resultUser != null) {
            // 后端解密
            String backEnPwd = new String(resultUser.getPassword().getBytes(),"UTF-8");
            String backDePwd = desEncrypt(backEnPwd, KEY_BACK, IV_BACK).trim();

            if (frontDePwd.equals(backDePwd)) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * @Description:  获取前端加密进行解密，通过后端加密在存储
     */
    @PostMapping("/register")
    public int register(@RequestBody User user) throws Exception {
        User userResult = userServices.get(user.getAccountID());
        if (userResult == null) {
            String frontEnPwd = user.getPassword();
            String frontDePwd = desEncrypt(frontEnPwd, KEY_FRONT, IV_FRONT).trim();

            String backByte = new String(frontDePwd.getBytes(),"UTF-8");
            String backEnPwd = encrypt(backByte, KEY_BACK, IV_BACK);
            user.setPassword(backEnPwd);

            return userServices.add(user);
        } else {
            return 2;
        }
    }
}