package com.xingji.frameproject.vo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PurchaseOrderQueryForm implements Serializable {
    private static final long serialVersionUID = -82383033756037587L;
    /**
     * 采购订单编号
     */
    private String orderid;
    /**
     * 交货日期
     */
    private String delicerydate;
    /**
     * 供应商用户名
     */
    private String vendor;
    /**
     * 单据日期
     */
    private String documentsdate;

    /**
     * 订单状态
     */
    private String oraderstate;


    /**
     * 审批状态
     */
    private String vettingstate;


    /**
     * 采购人员姓名
     */
    private String buyer;


    private Integer pageNum;    //当前页
    private Integer PageSize;   //页大小
}