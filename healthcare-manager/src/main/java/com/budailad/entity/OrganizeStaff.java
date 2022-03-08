package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (OrganizeStaff)实体类
 *
 * @Author Budai
 * @Since 2022-03-07 16:25:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizeStaff implements Serializable {
    private static final long serialVersionUID = -45947944236174705L;

    private Integer id;
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
     * 电话
     */
    private String stuffPhone;
    /**
     * 邮箱
     */
    private String stuffEmail;
    /**
     * 住址
     */
    private String stuffAdress;
    /**
     * 部门
     */
    private String departName;
    /**
     * 职位
     */
    private String staffAuthority;
    /**
     * 入职时间
     */
    private Date inTime;
    /**
     * 是否离职
     */
    private Integer isResigned;
    /**
     * 离职时间
     */
    private Date resignTime;

}

