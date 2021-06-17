package com.xingji.frameproject.mybatis.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

/**
 * (CapitalPayable)实体类
 *
 * @author makejava
 * @since 2021-06-17 11:19:04
 */
@Data
public class CapitalPayable implements Serializable {
    private static final long serialVersionUID = -35489164059059817L;
    /**
     * 单据编号
     */
    private String deliveryId;
    /**
     * 单据日期
     */
    private Date deliveryTime;
    /**
     * 供应商
     */
    private String vendor;
    /**
     * 采购人员
     */
    private String buyer;
    /**
     * 应付金额
     */
    private Double payables;
    /**
     * 已付金额
     */
    private Double paid;
    /**
     * 未付金额
     */
    private Double unpaid;
    /**
     * 单据备注
     */
    private String remarks;
    /**
     * 创建人
     */
    private String founder;
    /**
     * 结案状态
     */
    private Integer caseState;
    /**
     * 最后付款备注
     */
    private String paymentRemark;
    /**
     * 最后付款时间
     */
    private Date lastCollectionTime;
}
