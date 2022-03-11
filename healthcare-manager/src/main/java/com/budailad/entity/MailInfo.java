package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (MailInfo)实体类
 *
 * @author Budai
 * @since 2022-03-11 16:21:06
 */
public class MailInfo implements Serializable {
    private static final long serialVersionUID = 866965327121121945L;
    /**
     * 邮件编号
     */
    private String mailId;
    /**
     * 员工编号
     */
    private String staffId;
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
     * 发件时间
     */
    private Date sendTime;
    /**
     * 是否发送成功？
     */
    private Integer isSended;
    /**
     * 备注
     */
    private String comment;


    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMail() {
        return receiverMail;
    }

    public void setReceiverMail(String receiverMail) {
        this.receiverMail = receiverMail;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getIsSended() {
        return isSended;
    }

    public void setIsSended(Integer isSended) {
        this.isSended = isSended;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

