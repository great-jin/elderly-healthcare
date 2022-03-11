package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (LoginUser)实体类
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
public class LoginUser implements Serializable {
    private static final long serialVersionUID = -69688040325764657L;

    private String id;
    /**
     * 员工编号
     */
    private String staffId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPwd;
    /**
     * 部门编号
     */
    private String organizeId;
    /**
     * 头像
     */
    private String userAvatar;
    /**
     * 权限
     */
    private Integer userPower;
    /**
     * 是否启用
     */
    private Integer isDisabled;
    /**
     * 注册时间
     */
    private Date registerTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 注销时间
     */
    private Date destroyTime;
    /**
     * 备注
     */
    private String comment;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(String organizeId) {
        this.organizeId = organizeId;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Integer getUserPower() {
        return userPower;
    }

    public void setUserPower(Integer userPower) {
        this.userPower = userPower;
    }

    public Integer getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(Integer isDisabled) {
        this.isDisabled = isDisabled;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDestroyTime() {
        return destroyTime;
    }

    public void setDestroyTime(Date destroyTime) {
        this.destroyTime = destroyTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

