package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.CapitalReceipt;
import com.xingji.frameproject.mybatis.entity.CapitalReceiptAccount;
import com.xingji.frameproject.mybatis.entity.CapitalReceiptBill;
import lombok.Data;

import java.util.List;

/***
 * @author: 顾渊白
 * @date: 2021/6/2 23:50
 * @version 1.0
 */
@Data
public class ReceiptVo {
    private CapitalReceipt receipt;
    private List<CapitalReceiptBill> bills;
    private List<CapitalReceiptAccount> accounts;
}
