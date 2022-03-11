package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (MedicineCatalog)实体类
 *
 * @author Budai
 * @since 2022-03-11 16:21:04
 */
public class MedicineCatalog implements Serializable {
    private static final long serialVersionUID = -20710967573402297L;
    /**
     * 药品编号
     */
    private String drugId;
    /**
     * 药品名
     */
    private String drugName;
    /**
     * 药品类别
     */
    private String drugType;
    /**
     * 单价
     */
    private Double drugPrice;
    /**
     * 库存数量
     */
    private Integer goodsCount;
    /**
     * 生产日期
     */
    private Date produceTime;
    /**
     * 过期时间
     */
    private Date overdueTime;
    /**
     * 是否过期
     */
    private Integer isOverdue;
    /**
     * 生产厂商
     */
    private String produceVendor;
    /**
     * 备注
     */
    private String comment;
    /**
     * 入库编号
     */
    private String goodsId;


    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public Double getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(Double drugPrice) {
        this.drugPrice = drugPrice;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    public Date getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(Date overdueTime) {
        this.overdueTime = overdueTime;
    }

    public Integer getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(Integer isOverdue) {
        this.isOverdue = isOverdue;
    }

    public String getProduceVendor() {
        return produceVendor;
    }

    public void setProduceVendor(String produceVendor) {
        this.produceVendor = produceVendor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

}

