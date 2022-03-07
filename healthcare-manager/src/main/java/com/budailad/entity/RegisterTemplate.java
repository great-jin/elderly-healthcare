package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (RegisterTemplate)实体类
 *
 * @author makejava
 * @since 2022-03-07 16:26:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterTemplate implements Serializable {
    private static final long serialVersionUID = 310112965328722472L;
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
     * 消费套餐选择
     */
    private Integer costLevel;
    /**
     * 备注
     */
    private String comment;

}

