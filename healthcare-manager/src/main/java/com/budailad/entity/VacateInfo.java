package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (VacateInfo)实体类
 *
 * @author makejava
 * @since 2022-03-29 15:38:01
 */
public class VacateInfo implements Serializable {
    private static final long serialVersionUID = -44538072835110737L;
    /**
     * 编号
     */
    private String id;
    /**
     * 部门名
     */
    private String organizeName;
    /**
     * 部门类型
     */
    private String organizeType;
    /**
     * 申请人
     */
    private String staffId;
    /**
     * 申请人
     */
    private String staffName;
    /**
     * 请假类别
     */
    private String vacateType;
    /**
     * 请假原因
     */
    private String vacateReason;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 请假天数
     */
    private Double countTime;
    /**
     * 审核人
     */
    private String auditStaff;
    /**
     * 是否批准
     */
    private Integer isApprove;
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

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }

    public String getOrganizeType() {
        return organizeType;
    }

    public void setOrganizeType(String organizeType) {
        this.organizeType = organizeType;
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

    public String getVacateType() {
        return vacateType;
    }

    public void setVacateType(String vacateType) {
        this.vacateType = vacateType;
    }

    public String getVacateReason() {
        return vacateReason;
    }

    public void setVacateReason(String vacateReason) {
        this.vacateReason = vacateReason;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getCountTime() {
        return countTime;
    }

    public void setCountTime(Double countTime) {
        this.countTime = countTime;
    }

    public String getAuditStaff() {
        return auditStaff;
    }

    public void setAuditStaff(String auditStaff) {
        this.auditStaff = auditStaff;
    }

    public Integer getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(Integer isApprove) {
        this.isApprove = isApprove;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

