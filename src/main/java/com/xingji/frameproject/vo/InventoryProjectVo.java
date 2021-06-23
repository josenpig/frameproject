package com.xingji.frameproject.vo;

import lombok.Data;

/**
 * 库存盘点商品Vo
 */
@Data
public class InventoryProjectVo {
    private String productName;
    private String productId;
    private String productSpec;//规格
    private String productType;
    private String productUnit;
    private String ingredient;//成分
    private String gramHeavy;//克重
    private String productDescribe;//产品描述
    private int systemNum;
    private int inventoryNum;
    private double inventoryPl;
    private Double productPurchaseUnit;
    private String remark;

}
