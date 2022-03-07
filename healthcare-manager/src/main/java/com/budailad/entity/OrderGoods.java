package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (OrderGoods)实体类
 *
 * @author makejava
 * @since 2022-03-07 16:25:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoods implements Serializable {
    private static final long serialVersionUID = 123084397137297176L;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 商品名
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
    private Integer costCount;
    /**
     * 购买时间
     */
    private Date orderTime;
    /**
     * 负责人
     */
    private String staffId;
    /**
     * 预定交付时间
     */
    private Date deliveryTime;
    /**
     * 备注
     */
    private String comment;

}

