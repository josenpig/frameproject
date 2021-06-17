package com.xingji.frameproject.vo.form;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PurchaseReceiptDetailsQueryForm implements Serializable {
    private static final long serialVersionUID = 924993551472132656L;
    /**
     * 采购入库单详情id
     */
    private Integer id;
    /**
     * 采购入库单id
     */
    private String receiptid;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 仓库名
     */
    private String depotName;
    /**
     * 产品数量
     */
    private Integer productNum;
    /**
     * 产品单位
     */
    private String productUnit;
    /**
     * 计划价
     */
    private Double plannedPrice;
    /**
     * 采购单价
     */
    private Double purchaseUnitPrice;
    /**
     * 采购金额
     */
    private Double purchaseMoney;
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
    private Integer pageSize;   //页大小

    public Integer getPageNum() {
        if (pageNum == null)
            return 1;
        return pageNum;
    }

    public Integer getPageSize() {
        if (pageSize == null)
            return 0;
        return pageSize;
    }
}
