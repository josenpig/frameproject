package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.SaleDelivery;
import com.xingji.frameproject.mybatis.entity.SaleDeliveryDetails;
import lombok.Data;

import java.util.List;

/***
 * @author: 顾渊白
 * @date: 2021/5/25 16:31
 * @version 1.0
 */
@Data
public class SaleDeliveryVo {
    private SaleDelivery delivery;
    private List<SaleDeliveryDetails> deliverydetails;
    private List<SaleProductVo> saleProductVos;
}
