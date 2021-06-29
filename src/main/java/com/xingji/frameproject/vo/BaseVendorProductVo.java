package com.xingji.frameproject.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BaseVendorProductVo {
    /**
     * 供应商id
     */
    private String vendorId;
    /**
     * 产品id
     */
    private String productId;
    /**
     * 调剂比例
     */
    private Double priceRatio;
    /**
     * 标准采购价格
     */
    private Double purchaseMoney;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * *供应商名称
     */
    private String vendorName;
}
