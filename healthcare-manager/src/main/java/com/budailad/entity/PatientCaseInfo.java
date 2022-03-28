package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (PatientCaseInfo)实体类
 *
 * @author Budai
 * @since 2022-03-24 15:54:01
 */
public class PatientCaseInfo implements Serializable {
    private static final long serialVersionUID = 745923259131530263L;
    /**
     * 编号
     */
    private String castId;
    /**
     * 病人编号
     */
    private String patientId;
    /**
     * 姓名
     */
    private String patientName;
    /**
     * 描述
     */
    private String caseDescribe;
    /**
     * 主治医师 ID
     */
    private String chargeDoctor;
    /**
     * 护理员 ID
     */
    private String chargeNurse;
    /**
     * 入住时间
     */
    private Date inTime;
    /**
     * 是否出院
     */
    private Integer isLeave;
    /**
     * 出院时间
     */
    private Date outTime;
    /**
     * 备注
     */
    private String comment;


    public String getCastId() {
        return castId;
    }

    public void setCastId(String castId) {
        this.castId = castId;
    }

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

    public String getCaseDescribe() {
        return caseDescribe;
    }

    public void setCaseDescribe(String caseDescribe) {
        this.caseDescribe = caseDescribe;
    }

    public String getChargeDoctor() {
        return chargeDoctor;
    }

    public void setChargeDoctor(String chargeDoctor) {
        this.chargeDoctor = chargeDoctor;
    }

    public String getChargeNurse() {
        return chargeNurse;
    }

    public void setChargeNurse(String chargeNurse) {
        this.chargeNurse = chargeNurse;
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

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

