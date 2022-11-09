package xyz.ibudai.entity;

import java.io.Serializable;

/**
 * (AssetApplyGoods)实体类
 *
 * @author Budai
 * @since 2022-03-28 16:00:21
 */
public class AssetApplyGoods implements Serializable {
    private static final long serialVersionUID = -69512172847772679L;
    /**
     * 编号
     */
    private String id;
    /**
     * 申请订单编号
     */
    private String applyId;
    /**
     * 商品名
     */
    private String goodsName;
    /**
     * 商品规格
     */
    private String goodsType;
    /**
     * 单价
     */
    private Object goodsPrice;
    /**
     * 申请量
     */
    private Integer applyCount;
    /**
     * 总价
     */
    private Object costMoney;
    /**
     * 备注
     */
    private String comment;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public Object getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Object goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    public Object getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(Object costMoney) {
        this.costMoney = costMoney;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

