package com.budailad.entity;

import com.alibaba.excel.annotation.ExcelProperty;

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
    @ExcelProperty(value = "薪资编号", index = 0)
    private String salaryId;
    /**
     * 员工编号
     */
    @ExcelProperty(value = "员工编号", index = 1)
    private String staffId;
    /**
     * 员工姓名
     */
    @ExcelProperty(value = "员工姓名", index = 2)
    private String staffName;
    /**
     * 部门编号
     */
    @ExcelProperty(value = "部门编号", index = 3)
    private String organizeId;
    /**
     * 部门名
     */
    @ExcelProperty(value = "部门名", index = 4)
    private String organizeName;
    /**
     * 工作月份
     */
    @ExcelProperty(value = "工作月份", index = 5)
    private String workDate;
    /**
     * 工作天数
     */
    @ExcelProperty(value = "工作天数", index = 6)
    private Double workDays;
    /**
     * 请假天数
     */
    @ExcelProperty(value = "请假天数", index = 7)
    private Double offDays;
    /**
     * 罚款金额
     */
    @ExcelProperty(value = "罚款金额", index = 8)
    private Double deductCount;
    /**
     * 保险金额
     */
    @ExcelProperty(value = "保险金额", index = 9)
    private Double insuranceCount;
    /**
     * 补贴金额
     */
    @ExcelProperty(value = "补贴金额", index = 10)
    private Double allowanceCount;
    /**
     * 薪资总额
     */
    @ExcelProperty(value = "薪资总额", index = 11)
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

