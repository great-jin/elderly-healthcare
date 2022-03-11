package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysLogs)实体类
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
public class SysLogs implements Serializable {
    private static final long serialVersionUID = -21543575265610175L;
    /**
     * 编号
     */
    private String logId;
    /**
     * 日志名称
     */
    private String logName;
    /**
     * 来源模块
     */
    private String logModule;
    /**
     * 日志信息
     */
    private String logInfo;
    /**
     * 日志等级
     */
    private Integer logLevel;
    /**
     * 登记时间
     */
    private Date inTime;
    /**
     * 描述
     */
    private String logDescribe;


    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogModule() {
        return logModule;
    }

    public void setLogModule(String logModule) {
        this.logModule = logModule;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }

    public Integer getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(Integer logLevel) {
        this.logLevel = logLevel;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getLogDescribe() {
        return logDescribe;
    }

    public void setLogDescribe(String logDescribe) {
        this.logDescribe = logDescribe;
    }

}

