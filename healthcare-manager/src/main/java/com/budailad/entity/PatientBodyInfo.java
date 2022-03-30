package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (PatientBodyInfo)实体类
 *
 * @author Budai
 * @since 2022-03-30 09:20:21
 */
public class PatientBodyInfo implements Serializable {
    private static final long serialVersionUID = 529289703996240458L;
    /**
     * 编号
     */
    private String id;
    /**
     * 病人编号
     */
    private String patientId;
    /**
     * 体温(摄氏度)
     */
    private Double bodyTemper;
    /**
     * 心率(n/min)
     */
    private Double heartBeat;
    /**
     * 血压(mmHg)
     */
    private String bloodPressure;
    /**
     * 血糖
     */
    private String bloodGlucose;
    /**
     * 血脂(mmo/L)
     */
    private String bloodFat;
    /**
     * 用药详情
     */
    private String drugInfo;
    /**
     * 身体状况
     */
    private String bodyDetail;
    /**
     * 登记时间
     */
    private Date inTime;
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

    public Double getBodyTemper() {
        return bodyTemper;
    }

    public void setBodyTemper(Double bodyTemper) {
        this.bodyTemper = bodyTemper;
    }

    public Double getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(Double heartBeat) {
        this.heartBeat = heartBeat;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getBloodGlucose() {
        return bloodGlucose;
    }

    public void setBloodGlucose(String bloodGlucose) {
        this.bloodGlucose = bloodGlucose;
    }

    public String getBloodFat() {
        return bloodFat;
    }

    public void setBloodFat(String bloodFat) {
        this.bloodFat = bloodFat;
    }

    public String getDrugInfo() {
        return drugInfo;
    }

    public void setDrugInfo(String drugInfo) {
        this.drugInfo = drugInfo;
    }

    public String getBodyDetail() {
        return bodyDetail;
    }

    public void setBodyDetail(String bodyDetail) {
        this.bodyDetail = bodyDetail;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

