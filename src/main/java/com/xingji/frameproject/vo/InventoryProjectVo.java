package com.xingji.frameproject.vo;

import lombok.Data;

/**
 * 库存盘点商品Vo
 */
@Data
public class InventoryProjectVo {
    private String productName;
    private String productId;
    private String productSpec;
    private String productType;
    private String productUnit;
    private int systemNum;
    private int pdyk;
    private int pdNum;
    private Double productPurchaseUnit;
    private String remark;

}
