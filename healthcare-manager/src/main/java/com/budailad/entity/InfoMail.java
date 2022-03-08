package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (InfoMail)实体类
 *
 * @Author Budai
 * @Since 2022-03-07 16:25:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoMail implements Serializable {
    private static final long serialVersionUID = -98824320982801744L;
    /**
     * 邮件编号
     */
    private String mailId;
    /**
     * 发送人
     */
    private String senderName;
    /**
     * 发送邮箱
     */
    private String senderMail;
    /**
     * 收件人
     */
    private String receiverName;
    /**
     * 收件邮箱
     */
    private String receiverMail;
    /**
     * 发送成功？
     */
    private Integer isSended;
    /**
     * 发件时间
     */
    private Date sendTime;
    /**
     * 备注
     */
    private String comment;

}

