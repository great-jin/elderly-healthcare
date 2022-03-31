package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (PatientCaseInfo)实体类
 *
 * @author Budai
 * @since 2022-03-31 20:35:07
 */
public class PatientCaseInfo implements Serializable {
    private static final long serialVersionUID = 709910392366207487L;
    /**
     * 编号
     */
    private String caseId;
    /**
     * 病人编号
     */
    private String patientId;
    /**
     * 病人姓名
     */
    private String patientName;
    /**
     * 护理员编号
     */
    private String nurseId;
    /**
     * 护理员姓名
     */
    private String nurseName;
    /**
     * 主治医师编号
     */
    private String doctorId;
    /**
     * 主治医师姓名
     */
    private String doctorName;
    /**
     * 描述
     */
    private String caseDescribe;
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

    private List<PatientBodyInfo> patientBodyInfoList;

    public List<PatientBodyInfo> getPatientBodyInfoList() {
        return patientBodyInfoList;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public void setPatientBodyInfoList(List<PatientBodyInfo> patientBodyInfoList) {
        this.patientBodyInfoList = patientBodyInfoList;
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

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getCaseDescribe() {
        return caseDescribe;
    }

    public void setCaseDescribe(String caseDescribe) {
        this.caseDescribe = caseDescribe;
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

