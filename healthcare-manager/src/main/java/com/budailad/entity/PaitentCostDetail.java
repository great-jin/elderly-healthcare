package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (PaitentCostDetail)实体类
 *
 * @author makejava
 * @since 2022-03-07 16:25:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaitentCostDetail implements Serializable {
    private static final long serialVersionUID = 392899038316699659L;

    private Integer id;
    /**
     * 病人编号
     */
    private String patientId;
    /**
     * 病例编号
     */
    private String caseId;
    /**
     * 清单
     */
    private String costList;
    /**
     * 总价
     */
    private Double costCount;
    /**
     * 入院时间
     */
    private Date inTime;
    /**
     * 出院时间
     */
    private Date outTime;

}

