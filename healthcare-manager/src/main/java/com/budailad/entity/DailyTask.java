package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DailyTask)实体类
 *
 * @author makejava
 * @since 2022-03-24 15:53:59
 */
public class DailyTask implements Serializable {
    private static final long serialVersionUID = 179556781907252796L;
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
     * 工作内容
     */
    private String taskContent;
    /**
     * 负责人
     */
    private String staffId;
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

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
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

