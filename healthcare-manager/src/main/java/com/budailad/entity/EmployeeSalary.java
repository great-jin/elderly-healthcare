package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (EmployeeSalary)实体类
 *
 * @author makejava
 * @since 2022-03-07 16:24:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSalary implements Serializable {
    private static final long serialVersionUID = -31565862619491391L;
    /**
     * 主键ID
     */
    private String salaryId;
    /**
     * 员工编号
     */
    private String staffId;
    /**
     * 部门名
     */
    private String departName;
    /**
     * 工作天数
     */
    private Double workDays;
    /**
     * 请假天数
     */
    private Double offDays;
    /**
     * 罚款
     */
    private Double deductCount;
    /**
     * 保险
     */
    private Double insuranceCount;
    /**
     * 补贴
     */
    private Double allowanceCount;
    /**
     * 总数
     */
    private Double salaryCount;
    /**
     * 备注
     */
    private String comment;

}

