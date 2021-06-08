package com.xingji.frameproject.vo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PurchaseOrderDetailsQueryForm implements Serializable {
    private static final long serialVersionUID = 951225287636734227L;
    /**
     * 采购订单详情id
     */
    private Integer id;
    /**
     * 采购订单id
     */
    private String purchaseOrderId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 产品数量
     */
    private Integer productNum;
    /**
     * 产品单位
     */
    private String productUnit;
    /**
     * 采购单价
     */
    private Double purchaseUnitPrice;
    /**
     * 采购金额
     */
    private Double purchaseMoney;
    /**
     * 仓库名
     */
    private String depotName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 成份
     */
    private String ingredient;
    /**
     * 克重
     */
    private String gramHeavy;
    /**
     * 产品描述
     */
    private String productDescribe;

    private Integer pageNum;    //当前页
    private Integer PageSize;   //页大小
}