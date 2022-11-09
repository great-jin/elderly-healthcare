package xyz.ibudai.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (StaffNurse)实体类
 *
 * @author Budai
 * @since 2022-03-11 16:21:06
 */
public class StaffNurse implements Serializable {
    private static final long serialVersionUID = -94720880689197285L;

    private Integer id;
    /**
     * 员工编号
     */
    private String staffId;
    /**
     * 姓名
     */
    private String staffName;
    /**
     * 性别
     */
    private String staffGender;
    /**
     * 是否离职
     */
    private Integer isResigned;
    /**
     * 离职时间
     */
    private Date resignTime;
    /**
     * 年龄
     */
    private Integer staffAge;
    /**
     * 电话
     */
    private String staffPhone;
    /**
     * 邮箱
     */
    private String staffEmail;
    /**
     * 住址
     */
    private String staffAddress;
    /**
     * 部门编号
     */
    private String organizeId;
    /**
     * 职位
     */
    private String staffPosition;
    /**
     * 入职时间
     */
    private Date entryTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStaffGender() {
        return staffGender;
    }

    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender;
    }

    public Integer getIsResigned() {
        return isResigned;
    }

    public void setIsResigned(Integer isResigned) {
        this.isResigned = isResigned;
    }

    public Date getResignTime() {
        return resignTime;
    }

    public void setResignTime(Date resignTime) {
        this.resignTime = resignTime;
    }

    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(String organizeId) {
        this.organizeId = organizeId;
    }

    public String getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(String staffPosition) {
        this.staffPosition = staffPosition;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

}

