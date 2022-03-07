package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (WarehoseStorage)实体类
 *
 * @author makejava
 * @since 2022-03-07 16:28:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehoseStorage implements Serializable {
    private static final long serialVersionUID = -92443207735312976L;
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
     * 生产日期
     */
    private Date produceTime;
    /**
     * 生产厂商
     */
    private String produceVendor;
    /**
     * 库存数量
     */
    private Integer goodsCount;
    /**
     * 库存预警线(数量不低于)
     */
    private String warnLine;
    /**
     * 备注
     */
    private String comment;

}

