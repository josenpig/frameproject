package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.SaleOrder;
import com.xingji.frameproject.mybatis.entity.SaleOrderDetails;
import lombok.Data;

import java.util.List;

/***
 * @author: 顾渊白
 * @date: 2021/5/20 19:04
 * @version 1.0
 */
@Data
public class SaleOrderVo {
    private SaleOrder order;
    private List<SaleOrderDetails> orderdetails;
}
