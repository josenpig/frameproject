package com.xingji.frameproject.vo;

import lombok.Data;

@Data
public class PurchaseReceiptConditionVo {
    private String orderId;//订单id
    private String inBoundDate;//入库日期
    private String vettingState;//审批状态
    private String vendorName;//供应商
    private String createPeople;//创建人
    private String buyerName;//采购人
    private String dtimeState;//自定义开始时间
    private String dtimeEnd;//自定义结束时间
}