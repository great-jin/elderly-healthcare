package xyz.ibudai.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysLogs)实体类
 *
 * @author Budai
 * @since 2022-04-05 21:09:32
 */
public class SysLogs implements Serializable {
    private static final long serialVersionUID = 264193914240423938L;
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
     * 描述
     */
    private String logDescribe;
    /**
     * 登记时间
     */
    private Date inTime;
    /**
     * 是否处理
     */
    private Integer isHandle;


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

    public String getLogDescribe() {
        return logDescribe;
    }

    public void setLogDescribe(String logDescribe) {
        this.logDescribe = logDescribe;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Integer getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(Integer isHandle) {
        this.isHandle = isHandle;
    }

}

