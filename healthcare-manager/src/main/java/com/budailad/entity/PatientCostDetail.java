package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (PaitentCostDetail)实体类
 *
 * @author Budai
 * @since 2022-03-11 16:21:06
 */
public class PatientCostDetail implements Serializable {
    private static final long serialVersionUID = 386175855833591798L;
    /**
     * 病人编号
     */
    private String patientId;
    /**
     * 清单
     */
    private String costList;
    /**
     * 总价
     */
    private Double costCount;
    /**
     * 入院时间
     */
    private Date inTime;
    /**
     * 出院时间
     */
    private Date outTime;
    /**
     * 主键ID
     */
    private String costId;
    /**
     * 主治医师
     */
    private String chargeDoctor;
    /**
     * 是否结算
     */
    private Integer isPay;
    /**
     * 付款时间
     */
    private Date payTime;
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

    public String getCostList() {
        return costList;
    }

    public void setCostList(String costList) {
        this.costList = costList;
    }

    public Double getCostCount() {
        return costCount;
    }

    public void setCostCount(Double costCount) {
        this.costCount = costCount;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getCostId() {
        return costId;
    }

    public void setCostId(String costId) {
        this.costId = costId;
    }

    public String getChargeDoctor() {
        return chargeDoctor;
    }

    public void setChargeDoctor(String chargeDoctor) {
        this.chargeDoctor = chargeDoctor;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

