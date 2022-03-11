package com.budailad.entity;

import java.io.Serializable;

/**
 * (RegisterTemplate)实体类
 *
 * @author Budai
 * @since 2022-03-11 16:21:05
 */
public class RegisterTemplate implements Serializable {
    private static final long serialVersionUID = 303523639843603478L;
    /**
     * 模板编号
     */
    private String tempId;
    /**
     * 疾病
     */
    private String tempIll;
    /**
     * 入住天数
     */
    private Double tempTime;
    /**
     * 备注
     */
    private String comment;
    /**
     * 套餐选择
     */
    private Integer tempLevel;


    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getTempIll() {
        return tempIll;
    }

    public void setTempIll(String tempIll) {
        this.tempIll = tempIll;
    }

    public Double getTempTime() {
        return tempTime;
    }

    public void setTempTime(Double tempTime) {
        this.tempTime = tempTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getTempLevel() {
        return tempLevel;
    }

    public void setTempLevel(Integer tempLevel) {
        this.tempLevel = tempLevel;
    }

}

