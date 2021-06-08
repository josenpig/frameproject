package com.xingji.frameproject.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (CapitalReceiptBill)实体类
 *
 * @author makejava
 * @since 2021-06-02 20:17:45
 */
@Data
public class CapitalReceiptBill implements Serializable {
    private static final long serialVersionUID = -78164143091758512L;
    /**
     * 列表id
     */
    private Integer id;
    /**
     * 收款单编号
     */
    private String receiptId;
    /**
     * 关联单据id
     */
    private String saleId;
    /**
     * 单据类型
     */
    private String saleType;
    /**
     * 单据日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date saleTime;
    /**
     * 应收款金额
     */
    private Double receiptMoney;
    /**
     * 已收金额
     */
    private Double receivedMoney;
    /**
     * 未收金额
     */
    private Double uncollectedMoney;
    /**
     * 本次收款
     */
    private Double thisMoney;

}
