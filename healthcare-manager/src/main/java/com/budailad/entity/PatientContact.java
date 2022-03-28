package com.budailad.entity;

import java.io.Serializable;

/**
 * (PatientContact)实体类
 *
 * @author Budai
 * @since 2022-03-28 16:00:20
 */
public class PatientContact implements Serializable {
    private static final long serialVersionUID = 783733383551805337L;
    /**
     * 编号
     */
    private String id;
    /**
     * 编号
     */
    private String patientId;
    /**
     * 姓名
     */
    private String contactName;
    /**
     * 电话
     */
    private String contactPhone;
    /**
     * 状态
     */
    private Integer isDeleted;
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

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
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

