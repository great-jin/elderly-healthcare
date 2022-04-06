package com.budailad.entity;

import java.io.Serializable;

/**
 * (SysFileConfig)实体类
 *
 * @author Budai
 * @since 2022-04-06 14:11:13
 */
public class SysFileConfig implements Serializable {
    private static final long serialVersionUID = 737206177083771066L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 系统类别
     */
    private String sysType;
    /**
     * 单位类别
     */
    private String unitType;
    /**
     * 病例文件桶名
     */
    private String caseBucket;
    /**
     * 工资文件桶名
     */
    private String salaryBucket;
    /**
     * 头像文件桶名
     */
    private String avatarBucket;
    /**
     * 仓库文件桶名
     */
    private String storageBucket;
    /**
     * 备注
     */
    private String comment;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysType() {
        return sysType;
    }

    public void setSysType(String sysType) {
        this.sysType = sysType;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getCaseBucket() {
        return caseBucket;
    }

    public void setCaseBucket(String caseBucket) {
        this.caseBucket = caseBucket;
    }

    public String getSalaryBucket() {
        return salaryBucket;
    }

    public void setSalaryBucket(String salaryBucket) {
        this.salaryBucket = salaryBucket;
    }

    public String getAvatarBucket() {
        return avatarBucket;
    }

    public void setAvatarBucket(String avatarBucket) {
        this.avatarBucket = avatarBucket;
    }

    public String getStorageBucket() {
        return storageBucket;
    }

    public void setStorageBucket(String storageBucket) {
        this.storageBucket = storageBucket;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

