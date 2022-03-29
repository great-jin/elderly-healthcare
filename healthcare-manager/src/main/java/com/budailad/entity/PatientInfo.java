package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (PatientInfo)实体类
 *
 * @author makejava
 * @since 2022-03-29 15:57:12
 */
public class PatientInfo implements Serializable {
    private static final long serialVersionUID = 696076104427399917L;
    /**
     * 编号
     */
    private String patientId;
    /**
     * 姓名
     */
    private String patientName;
    /**
     * 登记时间
     */
    private Date inTime;
    /**
     * 性别
     */
    private String patientGender;
    /**
     * 年龄
     */
    private Integer patientAge;
    /**
     * 身高(cm)
     */
    private Double patientHeight;
    /**
     * 体重(kg)
     */
    private Double patientWeight;
    /**
     * 视力 左
     */
    private Double eyeLeft;
    /**
     * 视力 右
     */
    private Double eyeRight;
    /**
     * 体温( 摄氏度)
     */
    private Double bodyTemper;
    /**
     * 心率( n/min)
     */
    private Double heartBeat;
    /**
     * 血压( mmHg)
     */
    private String bloodPressure;
    /**
     * 血糖
     */
    private String bloodGlucose;
    /**
     * 血脂( mmo/L)
     */
    private String bloodFat;
    /**
     * 身体状况
     */
    private String bodyDetail;
    /**
     * 联系电话
     */
    private String patientPhone;
    /**
     * 籍贯住址，联动控件
     */
    private String patientAddress;
    /**
     * 备注
     */
    private String comment;


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

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
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

    public Double getPatientHeight() {
        return patientHeight;
    }

    public void setPatientHeight(Double patientHeight) {
        this.patientHeight = patientHeight;
    }

    public Double getPatientWeight() {
        return patientWeight;
    }

    public void setPatientWeight(Double patientWeight) {
        this.patientWeight = patientWeight;
    }

    public Double getEyeLeft() {
        return eyeLeft;
    }

    public void setEyeLeft(Double eyeLeft) {
        this.eyeLeft = eyeLeft;
    }

    public Double getEyeRight() {
        return eyeRight;
    }

    public void setEyeRight(Double eyeRight) {
        this.eyeRight = eyeRight;
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

    public String getBodyDetail() {
        return bodyDetail;
    }

    public void setBodyDetail(String bodyDetail) {
        this.bodyDetail = bodyDetail;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

