package xyz.ibudai.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (AssetApplyInfo)实体类
 *
 * @author Budai
 * @since 2022-03-28 16:00:21
 */
public class AssetApplyInfo implements Serializable {
    private static final long serialVersionUID = -76452103486425384L;
    /**
     * 申请订单编号
     */
    private String applyId;
    /**
     * 申请单位，冗余字段
     */
    private String organizeUnit;
    /**
     * 申请部门
     */
    private String organizeName;
    /**
     * 申请人
     */
    private String staffId;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 申请原因
     */
    private String applyReason;
    /**
     * 收件人
     */
    private String receiveName;
    /**
     * 收件电话
     */
    private String receivePhone;
    /**
     * 收货地址
     */
    private String receiveAddress;
    /**
     * 总金额
     */
    private Object costMoney;
    /**
     * 当前状态
     */
    private Integer currentState;
    /**
     * 是否完成
     */
    private Integer isFinished;
    /**
     * 备注
     */
    private String comment;
    /**
     * 申请产品列表
     */
    private List<AssetApplyGoods> applyGoodsList;


    public List<AssetApplyGoods> getApplyGoodsList() {
        return applyGoodsList;
    }

    public void setApplyGoodsList(List<AssetApplyGoods> applyGoodsList) {
        this.applyGoodsList = applyGoodsList;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getOrganizeUnit() {
        return organizeUnit;
    }

    public void setOrganizeUnit(String organizeUnit) {
        this.organizeUnit = organizeUnit;
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

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public Object getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(Object costMoney) {
        this.costMoney = costMoney;
    }

    public Integer getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Integer currentState) {
        this.currentState = currentState;
    }

    public Integer getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Integer isFinished) {
        this.isFinished = isFinished;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

