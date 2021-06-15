package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (PurchaseReturns)实体类
 *
 * @author makejava
 * @since 2021-06-15 18:49:01
 */
public class PurchaseReturns implements Serializable {
    private static final long serialVersionUID = 733255605405457802L;
    /**
     * 主键
     */
    private String id;
    /**
     * 退货日期
     */
    private Date exitDate;
    /**
     * 供应商用户名
     */
    private String vendorName;
    /**
     * 采购人用户名
     */
    private String buyerName;
    /**
     * 仓库名
     */
    private String depotName;
    /**
     * 优惠后付款
     */
    private Double offersPrice;
    /**
     * 当前审批人用户名
     */
    private String vettingName;
    /**
     * 最后审批时间
     */
    private Date lastVettingTime;
    /**
     * 审批状态
     */
    private Integer vettingState;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 打印次数
     */
    private Integer counter;
    /**
     * 关联的采购订单
     */
    private String purchaseOrder;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public Double getOffersPrice() {
        return offersPrice;
    }

    public void setOffersPrice(Double offersPrice) {
        this.offersPrice = offersPrice;
    }

    public String getVettingName() {
        return vettingName;
    }

    public void setVettingName(String vettingName) {
        this.vettingName = vettingName;
    }

    public Date getLastVettingTime() {
        return lastVettingTime;
    }

    public void setLastVettingTime(Date lastVettingTime) {
        this.lastVettingTime = lastVettingTime;
    }

    public Integer getVettingState() {
        return vettingState;
    }

    public void setVettingState(Integer vettingState) {
        this.vettingState = vettingState;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

}
