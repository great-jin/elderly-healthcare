package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (MedicineCatalog)实体类
 *
 * @author makejava
 * @since 2022-03-07 16:25:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineCatalog implements Serializable {
    private static final long serialVersionUID = -83621507879035786L;
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

}

