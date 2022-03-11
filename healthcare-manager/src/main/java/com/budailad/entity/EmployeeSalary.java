package com.budailad.entity;

import java.io.Serializable;

/**
 * (EmployeeSalary)实体类
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
public class EmployeeSalary implements Serializable {
    private static final long serialVersionUID = -99068214956487572L;
    /**
     * 主键ID
     */
    private String salaryId;
    /**
     * 员工编号
     */
    private String staffId;
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
    /**
     * 部门编号
     */
    private String organizeId;
    /**
     * 月份
     */
    private String workDate;


    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        this.salaryId = salaryId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Double getWorkDays() {
        return workDays;
    }

    public void setWorkDays(Double workDays) {
        this.workDays = workDays;
    }

    public Double getOffDays() {
        return offDays;
    }

    public void setOffDays(Double offDays) {
        this.offDays = offDays;
    }

    public Double getDeductCount() {
        return deductCount;
    }

    public void setDeductCount(Double deductCount) {
        this.deductCount = deductCount;
    }

    public Double getInsuranceCount() {
        return insuranceCount;
    }

    public void setInsuranceCount(Double insuranceCount) {
        this.insuranceCount = insuranceCount;
    }

    public Double getAllowanceCount() {
        return allowanceCount;
    }

    public void setAllowanceCount(Double allowanceCount) {
        this.allowanceCount = allowanceCount;
    }

    public Double getSalaryCount() {
        return salaryCount;
    }

    public void setSalaryCount(Double salaryCount) {
        this.salaryCount = salaryCount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(String organizeId) {
        this.organizeId = organizeId;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

}

