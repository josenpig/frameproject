package com.xingji.frameproject.vo;

import lombok.Data;

/***
 * @author: 顾渊白
 * @date: 2021/6/15 19:13
 * @version 1.0
 */
@Data
public class CapitalConditionPageVo {
    private String deliveryId;//收付款编号
    private String deliveryTime;//日期1
    private String otimeState;
    private String otimeEnd;
    private String lastCollectionTime;//最后收付款日期
    private String dtimeState;
    private String dtimeEnd;
    private String customer;//客户
    private String vendor;//供应商
    private String salesmen;//销售人
    private String buyer;//采购人
    private String founder;//创建人
    private String approvalState;//审批状态
    private String caseState;//结案状态
    private String payee;//收款人
    private String incomeType;//收款类别
    private String drawee;//付款人
    private String paymentType;//付款类别
}
