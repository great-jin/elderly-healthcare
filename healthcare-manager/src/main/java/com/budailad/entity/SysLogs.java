package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysLogs)实体类
 *
 * @Author Budai
 * @Since 2022-03-07 16:28:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLogs implements Serializable {
    private static final long serialVersionUID = 968147788587544117L;
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

}

