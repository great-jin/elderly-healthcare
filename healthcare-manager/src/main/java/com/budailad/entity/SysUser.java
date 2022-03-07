package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2022-03-07 16:28:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {
    private static final long serialVersionUID = 460491433436102646L;

    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPwd;
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

