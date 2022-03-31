package com.budailad.http;

import com.budailad.model.Mail;
import com.budailad.utils.RedisService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping(value = "/api/test/Mails")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/list")
    public List<Mail> get(@Param("accountID") String accountID) {
        List<Mail> MailList;
        // 先从Redis数据库读取数据
        MailList = (List<Mail>) redisService.get("Mails:list");
        // 如果未查询到数据再从MySQL中读取
        if (MailList == null) {
            // MailList = MailService.list();
            if (MailList == null) {
                return null;
            } else {
                // 将查出来的数据存入Redis数据库
                redisService.set("Mails:list", MailList, 5);
            }
        }
        return MailList;
    }

    @PostMapping("/add")
    public void update(@RequestBody Mail Mail) throws Exception {
        /*
         Mail MailResult = MailService.get(Mail.getAccountID());
         if (MailResult == null) {
         // 删除缓存
         redisService.delete("Mails:list");
         return MailService.add(Mail);
         } else {
         return 2;
         }
         */
    }

}