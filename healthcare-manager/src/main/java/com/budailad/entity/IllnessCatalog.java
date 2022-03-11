package com.budailad.entity;

import java.io.Serializable;

/**
 * (IllnessCatalog)实体类
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
public class IllnessCatalog implements Serializable {
    private static final long serialVersionUID = 579737155419267278L;
    /**
     * 疾病编号
     */
    private String illId;
    /**
     * 疾病类别
     */
    private String illType;
    /**
     * 疾病名
     */
    private String illName;
    /**
     * 备注
     */
    private String comment;
    /**
     * 描述
     */
    private String illDescribe;
    /**
     * 疾病指标
     */
    private String illIndex;


    public String getIllId() {
        return illId;
    }

    public void setIllId(String illId) {
        this.illId = illId;
    }

    public String getIllType() {
        return illType;
    }

    public void setIllType(String illType) {
        this.illType = illType;
    }

    public String getIllName() {
        return illName;
    }

    public void setIllName(String illName) {
        this.illName = illName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIllDescribe() {
        return illDescribe;
    }

    public void setIllDescribe(String illDescribe) {
        this.illDescribe = illDescribe;
    }

    public String getIllIndex() {
        return illIndex;
    }

    public void setIllIndex(String illIndex) {
        this.illIndex = illIndex;
    }

}

