package com.xingji.frameproject.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (BaseVendor)实体类
 *
 * @author makejava
 * @since 2021-06-04 15:28:58
 */
@Data
public class BaseVendor implements Serializable {
    private static final long serialVersionUID = -76697735950454456L;
    /**
     * *供应商编号
     */
    private String vendorId;
    /**
     * *供应商名称
     */
    private String vendorName;
    /**
     * *供应商类型:类型： 批发、一级供应商、二级供应商、个体
     */
    private String vendorType;
    /**
     * 地址
     */
    private String address;
    /**
     * *负责人
     */
    private String charge;
    /**
     * 联系人姓名
     */
    private String contactName;
    /**
     * 联系人地址
     */
    private String contactAddress;
    /**
     * 联系人电话
     */
    private String contactNumber;
    /**
     * 创建人
     */
    private String user;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * *应付款金额
     */
    private Double accountsPayable;


    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorType() {
        return vendorType;
    }

    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Double getAccountsPayable() {
        return accountsPayable;
    }

    public void setAccountsPayable(Double accountsPayable) {
        this.accountsPayable = accountsPayable;
    }

}
