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
     * 该产品在该供应商的采购价格
     */
    private Double money;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * *供应商名称
     */
    private String vendorName;
}
