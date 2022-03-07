package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (StaffUser)实体类
 *
 * @author makejava
 * @since 2022-03-07 16:27:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffUser implements Serializable {
    private static final long serialVersionUID = 522206507017201437L;

    private Integer id;
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
     * 头像
     */
    private String userImg;
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

}

