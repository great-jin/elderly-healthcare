package xyz.ibudai.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (OrganizeInfo)实体类
 *
 * @author Budai
 * @since 2022-03-11 16:21:04
 */
public class OrganizeInfo implements Serializable {
    private static final long serialVersionUID = 182639227245935053L;
    /**
     * 编号
     */
    private String organizeId;
    /**
     * 部门名
     */
    private String organizeName;
    /**
     * 部门类型
     */
    private String organizeType;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 部门人数
     */
    private Integer manCount;
    /**
     * 领导编号
     */
    private String staffId;
    /**
     * 领导
     */
    private String organizeLeader;
    /**
     * 备注
     */
    private String comment;


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

    public String getOrganizeType() {
        return organizeType;
    }

    public void setOrganizeType(String organizeType) {
        this.organizeType = organizeType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getManCount() {
        return manCount;
    }

    public void setManCount(Integer manCount) {
        this.manCount = manCount;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getOrganizeLeader() {
        return organizeLeader;
    }

    public void setOrganizeLeader(String organizeLeader) {
        this.organizeLeader = organizeLeader;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

