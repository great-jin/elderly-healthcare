package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (WarehouseStorage)实体类
 *
 * @author Budai
 * @since 2022-04-06 14:07:04
 */
public class WarehouseStorage implements Serializable {
    private static final long serialVersionUID = 352993816534807039L;
    /**
     * 货物编号
     */
    private String goodsId;
    /**
     * 货物名
     */
    private String goodsName;
    /**
     * 货物类别
     */
    private String goodsType;
    /**
     * 单价
     */
    private Double goodsPrice;
    /**
     * 库存数量
     */
    private Integer goodsCount;
    /**
     * 库存预警线(数量不低于)
     */
    private Double warnLine;
    /**
     * 生产日期
     */
    private Date produceTime;
    /**
     * 购买日期
     */
    private Date purchaseTime;
    /**
     * 购买人
     */
    private String purchaseStaff;
    /**
     * 生产厂商
     */
    private String produceVendor;
    /**
     * 备注
     */
    private String comment;


    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Double getWarnLine() {
        return warnLine;
    }

    public void setWarnLine(Double warnLine) {
        this.warnLine = warnLine;
    }

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getPurchaseStaff() {
        return purchaseStaff;
    }

    public void setPurchaseStaff(String purchaseStaff) {
        this.purchaseStaff = purchaseStaff;
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

}

