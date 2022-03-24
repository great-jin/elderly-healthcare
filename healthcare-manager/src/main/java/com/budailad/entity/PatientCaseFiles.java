package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (PatientCaseFiles)实体类
 *
 * @author makejava
 * @since 2022-03-24 15:54:00
 */
public class PatientCaseFiles implements Serializable {
    private static final long serialVersionUID = -29185032678137532L;
    /**
     * 文件ID
     */
    private String fileId;
    /**
     * 病人编号
     */
    private String patientId;
    /**
     * 病历编号
     */
    private String castId;
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


    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getCastId() {
        return castId;
    }

    public void setCastId(String castId) {
        this.castId = castId;
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

}

