package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (PatientInfo)实体类
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
public class PatientInfo implements Serializable {
    private static final long serialVersionUID = 833098817950810236L;
    /**
     * 编号
     */
    private String patientId;
    /**
     * 姓名
     */
    private String patientName;
    /**
     * 性别
     */
    private String patientGender;
    /**
     * 年龄
     */
    private Integer patientAge;
    /**
     * 电话
     */
    private String patientPhone;
    /**
     * 紧急联系人
     */
    private String contactName;
    /**
     * 紧急电话
     */
    private String contactPhone;
    /**
     * 入住时间
     */
    private Date inTime;
    /**
     * 是否出院
     */
    private Integer isLeave;


    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
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

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Integer getIsLeave() {
        return isLeave;
    }

    public void setIsLeave(Integer isLeave) {
        this.isLeave = isLeave;
    }

}

