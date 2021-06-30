package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.BaseOpening;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/***
 * @author: 顾渊白
 * @date: 2021/5/28 8:29
 * @version 1.0
 */
@Data
public class SaleProductVo {
    private String productName;
    private String productId;
    private String productTypeId;
    private String productType;
    private String remark;
    private String productSpec;
    private String productUnit;
    private BigDecimal saleMoney;
    private int productNum;
    private int expectNum;
    private BigDecimal saleUnitPrice;
    private List<BaseOpening> baseOpenings;
    private String ingredient;
    private String gramHeavy;
    private String productDescribe;
}
