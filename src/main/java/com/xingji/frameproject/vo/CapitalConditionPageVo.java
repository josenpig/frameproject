package com.xingji.frameproject.vo;

import lombok.Data;

/***
 * @author: 顾渊白
 * @date: 2021/6/15 19:13
 * @version 1.0
 */
@Data
public class CapitalConditionPageVo {
    //应收付
    private String deliveryId;//收付款编号
    private String deliveryTime;//单据日期
    private String otimeState;
    private String otimeEnd;
    private String lastCollectionTime;//最后收付款日期
    private String dtimeState;
    private String dtimeEnd;
    private String customer;//客户
    private String vendor;//供应商
    private String salesmen;//销售人
    private String buyer;//采购人
    private String founder;
    private String caseState;
    private String payee;
    private String incomeType;
}
