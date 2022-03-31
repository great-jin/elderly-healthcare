package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DailyTask)实体类
 *
 * @author Budai
 * @since 2022-03-31 20:35:07
 */
public class DailyTask implements Serializable {
    private static final long serialVersionUID = -31737156909375593L;
    /**
     * 任务编号
     */
    private String taskId;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 负责的病人
     */
    private String patientId;
    /**
     * 病人姓名
     */
    private String patientName;
    /**
     * 护理员ID
     */
    private String nurseId;
    /**
     * 护理员姓名
     */
    private String nurseName;
    /**
     * 工作内容
     */
    private String taskContent;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 是否延期
     */
    private Integer isDelay;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否完成
     */
    private Integer isFinished;
    /**
     * 完成时间
     */
    private Date finishTime;
    /**
     * 备注
     */
    private String comment;


    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getIsDelay() {
        return isDelay;
    }

    public void setIsDelay(Integer isDelay) {
        this.isDelay = isDelay;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Integer isFinished) {
        this.isFinished = isFinished;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

