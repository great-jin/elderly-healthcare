package xyz.ibudai.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (VacateInfo)实体类
 *
 * @author Budai
 * @since 2022-03-31 20:35:05
 */
public class VacateInfo implements Serializable {
    private static final long serialVersionUID = -55890920506248719L;
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
     * 申请人编号
     */
    private String staffId;
    /**
     * 申请人姓名
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
     * 审核人编号
     */
    private String auditorId;
    /**
     * 审核人姓名
     */
    private String auditorName;
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

    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
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

