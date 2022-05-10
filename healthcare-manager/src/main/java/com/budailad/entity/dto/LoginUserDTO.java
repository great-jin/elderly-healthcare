package com.budailad.entity.dto;

import java.io.Serializable;

/**
 * (LoginUser)实体类
 *
 * @author Budai
 * @since 2022-03-28 16:32:31
 */
public class LoginUserDTO implements Serializable {
    private static final long serialVersionUID = -91082088988117519L;

    private String staffId;
    private String userName;
    private String userPwd;
    private String staffEmail;

    public LoginUserDTO() {
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
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

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }
}

