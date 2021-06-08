package com.xingji.frameproject.vo;

import lombok.Data;

/***
 * @author: 顾渊白
 * @date: 2021/6/5 19:02
 * @version 1.0
 */
@Data
public class DeliveryStatusVo {
    private String pid;
    private String pname;
    private int pnum;//数量
    private int okdnum;//已出库
    private int okrnum;//已退货
    private int nodnum;//待出库
}
