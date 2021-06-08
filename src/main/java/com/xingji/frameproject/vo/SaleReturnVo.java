package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.SaleReturn;
import com.xingji.frameproject.mybatis.entity.SaleReturnDetails;
import lombok.Data;

import java.util.List;

/***
 * @author: 顾渊白
 * @date: 2021/5/30 22:42
 * @version 1.0
 */
@Data
public class SaleReturnVo {
    private SaleReturn salereturn;
    private List<SaleReturnDetails> returndetails;
}
