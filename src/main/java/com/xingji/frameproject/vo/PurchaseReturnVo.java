package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.PurchaseReturns;
import com.xingji.frameproject.mybatis.entity.PurchaseReturnsDetails;
import lombok.Data;

import java.util.List;

@Data
public class PurchaseReturnVo {
    private PurchaseReturns returns;
    private List<PurchaseReturnsDetails> returnsDetails;
}
