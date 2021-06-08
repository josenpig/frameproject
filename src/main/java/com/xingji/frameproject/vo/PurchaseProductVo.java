package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.BaseDepot;
import com.xingji.frameproject.mybatis.entity.BaseOpening;
import lombok.Data;

import java.util.List;

/**
 * 采购产品vo
 */
@Data
public class PurchaseProductVo {
    private String productName;
    private String productId;
    private String product_type_name;
    private int productNum;
    private String productUnit;
    private double purchaseUnitPrice;
    private double purchaseMoney;
    private List<BaseDepot> baseDepots;
    private String remark;
    private int expectNum;
    private String productDescribe;
}
