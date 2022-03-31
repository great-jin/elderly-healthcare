package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (SalaryDetailFiles)实体类
 *
 * @author Budai
 * @since 2022-03-31 20:35:08
 */
public class SalaryDetailFiles implements Serializable {
    private static final long serialVersionUID = -39810967000275261L;
    /**
     * 主键ID
     */
    private String fileId;
    /**
     * 工资编号
     */
    private String salaryId;
    /**
     * 员工编号
     */
    private String staffId;
    /**
     * 员工姓名
     */
    private String staffName;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 桶名
     */
    private String minioBucket;
    /**
     * 存储名称
     */
    private String minioPath;
    /**
     * 上传时间
     */
    private Date uploadTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    private Integer isDeleted;
    /**
     * 备注
     */
    private String comment;


    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        this.salaryId = salaryId;
    }

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

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

