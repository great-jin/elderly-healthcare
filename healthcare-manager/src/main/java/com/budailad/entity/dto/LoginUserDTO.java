package com.budailad.entity.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * (LoginUser)实体类
 *
 * @author Budai
 * @since 2022-03-28 16:32:31
 */
public class LoginUserDTO implements Serializable {
    private static final long serialVersionUID = -91082088988117519L;

    /**
     * 员工编号
     */
    private String staffId;
    /**
     * 姓名
     */
    private String staffName;
    /**
     * 性别
     */
    private String staffGender;
    /**
     * 年龄
     */
    private Integer staffAge;
    /**
     * 电话
     */
    private String staffPhone;
    /**
     * 邮箱
     */
    private String staffEmail;
    /**
     * 住址
     */
    private String staffAddress;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPwd;
    /**
     * 头像
     */
    private String userAvatar;
    /**
     * 存储桶
     */
    private String bucketAvatar;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffGender() {
        return staffGender;
    }

    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender;
    }

    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getBucketAvatar() {
        return bucketAvatar;
    }

    public void setBucketAvatar(String bucketAvatar) {
        this.bucketAvatar = bucketAvatar;
    }
}

