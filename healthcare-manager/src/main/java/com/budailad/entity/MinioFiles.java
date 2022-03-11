package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (MinioFiles)实体类
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
public class MinioFiles implements Serializable {
    private static final long serialVersionUID = 222249933651695185L;

    private Integer id;

    private String accountCode;

    private String fileName;

    private Date inTime;

    private String minioBucket;

    private String minioPath;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getMinioBucket() {
        return minioBucket;
    }

    public void setMinioBucket(String minioBucket) {
        this.minioBucket = minioBucket;
    }

    public String getMinioPath() {
        return minioPath;
    }

    public void setMinioPath(String minioPath) {
        this.minioPath = minioPath;
    }

}

