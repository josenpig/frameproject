package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.CapitalPayment;
import com.xingji.frameproject.mybatis.entity.CapitalPaymentAccount;
import com.xingji.frameproject.mybatis.entity.CapitalPaymentBill;
import lombok.Data;

import java.util.List;

/***
 * @author: 顾渊白
 * @date: 2021/6/19 13:59
 * @version 1.0
 */
@Data
public class PaymentVo {
    private CapitalPayment payment;
    private List<CapitalPaymentBill> bills;
    private List<CapitalPaymentAccount> accounts;
}
