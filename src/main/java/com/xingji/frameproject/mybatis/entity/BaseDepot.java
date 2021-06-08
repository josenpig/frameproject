package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;

/**
 * (BaseDepot)实体类
 *
 * @author makejava
 * @since 2021-06-07 19:17:44
 */
public class BaseDepot implements Serializable {
    private static final long serialVersionUID = -50064553025324976L;
    /**
     * *仓库编号
     */
    private String depotId;
    /**
     * *仓库名称
     */
    private String depotName;
    /**
     * 仓库地址
     */
    private String depotAddress;
    /**
     * *负责人
     */
    private String chargeName;
    /**
     * 联系电话
     */
    private String contactNumber;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 状态: （已启用：1；已禁用：0）
     */
    private Integer state;


    public String getDepotId() {
        return depotId;
    }

    public void setDepotId(String depotId) {
        this.depotId = depotId;
    }

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public String getDepotAddress() {
        return depotAddress;
    }

    public void setDepotAddress(String depotAddress) {
        this.depotAddress = depotAddress;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
