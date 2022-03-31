package com.budailad.entity;

import java.io.Serializable;

/**
 * (EmployeeSalary)实体类
 *
 * @author Budai
 * @since 2022-03-31 20:35:08
 */
public class EmployeeSalary implements Serializable {
    private static final long serialVersionUID = 100704947998375996L;
    /**
     * 主键ID
     */
    private String salaryId;
    /**
     * 部门编号
     */
    private String organizeId;
    /**
     * 部门名
     */
    private String organizeName;
    /**
     * 员工编号
     */
    private String staffId;
    /**
     * 员工姓名
     */
    private String staffName;
    /**
     * 月份
     */
    private String workDate;
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


    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        this.salaryId = salaryId;
    }

    public String getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(String organizeId) {
        this.organizeId = organizeId;
    }

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
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

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
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

}

