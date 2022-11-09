package xyz.ibudai.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (PatientCostInfo)实体类
 *
 * @author Budai
 * @since 2022-04-06 14:07:05
 */
public class PatientCostInfo implements Serializable {
    private static final long serialVersionUID = 779464761820384780L;
    /**
     * 主键ID
     */
    private String costId;
    /**
     * 病人编号
     */
    private String patientId;
    /**
     * 病人姓名
     */
    private String patientName;
    /**
     * 医师Id
     */
    private String doctorId;
    /**
     * 医师名
     */
    private String doctorName;
    /**
     * 入院时间
     */
    private Date inTime;
    /**
     * 出院时间
     */
    private Date outTime;
    /**
     * 总价
     */
    private Double costCount;
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


    public String getCostId() {
        return costId;
    }

    public void setCostId(String costId) {
        this.costId = costId;
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

    public Double getCostCount() {
        return costCount;
    }

    public void setCostCount(Double costCount) {
        this.costCount = costCount;
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

