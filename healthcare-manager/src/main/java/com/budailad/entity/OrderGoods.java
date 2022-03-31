package com.budailad.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (OrderGoods)实体类
 *
 * @author Budai
 * @since 2022-03-31 20:35:07
 */
public class OrderGoods implements Serializable {
    private static final long serialVersionUID = 896550623167115466L;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 订单名
     */
    private String orderName;
    /**
     * 商品名
     */
    private String goodsName;
    /**
     * 商品类别
     */
    private String goodsType;
    /**
     * 单价
     */
    private Double goodsPrice;
    /**
     * 购买量
     */
    private Integer orderCount;
    /**
     * 总价
     */
    private Double costCount;
    /**
     * 购买时间
     */
    private Date orderTime;
    /**
     * 负责人Id
     */
    private String staffId;
    /**
     * 负责人姓名
     */
    private String staffName;
    /**
     * 交付时间
     */
    private Date deliveryTime;
    /**
     * 备注
     */
    private String comment;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
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

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Double getCostCount() {
        return costCount;
    }

    public void setCostCount(Double costCount) {
        this.costCount = costCount;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

