package com.budailad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.budailad.entity.Mail;

@RestController
@RequestMapping(value = "/mail")
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/send")
    public void SendMail(@RequestBody Mail mail){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getOwner());
        message.setTo(mail.getTarget());
        message.setSubject(mail.getSubject());
        message.setText(mail.getMessage());

        mailSender.send(message);
    }
}