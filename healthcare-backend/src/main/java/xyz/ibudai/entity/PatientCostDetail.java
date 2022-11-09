package xyz.ibudai.entity;

import java.io.Serializable;

/**
 * (PatientCostDetail)实体类
 *
 * @author Budai
 * @since 2022-04-06 14:07:04
 */
public class PatientCostDetail implements Serializable {
    private static final long serialVersionUID = -99623317379843838L;

    private String patientId;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 消费关联字段
     */
    private String costId;
    /**
     * 类别
     */
    private String goodsType;
    /**
     * 名称
     */
    private String goodsName;
    /**
     * 单价
     */
    private Double goodsPrice;
    /**
     * 数量
     */
    private Integer goodsNumber;
    /**
     * 总价
     */
    private Double costCount;
    /**
     * 备注
     */
    private String comment;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCostId() {
        return costId;
    }

    public void setCostId(String costId) {
        this.costId = costId;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Double getCostCount() {
        return costCount;
    }

    public void setCostCount(Double costCount) {
        this.costCount = costCount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

