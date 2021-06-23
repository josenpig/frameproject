package com.xingji.frameproject.mybatis.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (StockTransferDetails)实体类
 *
 * @author hdr666
 * @since 2021-06-22 14:26:51
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StockTransferDetails implements Serializable {
    private static final long serialVersionUID = 308453418464489525L;
    /**
     * 调拨单详情id
     */
    private Long id;
    /**
     * 调拨单id
     */
    private String transferId;
    /**
     * 产品id
     */
    private String productId;//产品编号
    private String productName;//产品名称
    private String productUnit;//单位
    private String ingredient;//成分
    private String productSpec;//规格
    private String gramHeavy;//克重
    private String productDescribe;//产品描述

    /**
     * 调拨数量
     */
    private Integer productNum;
    /**
     * 备注
     */
    private String remark;
}
