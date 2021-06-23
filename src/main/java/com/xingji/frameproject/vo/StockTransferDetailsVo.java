package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.StockTransfer;
import com.xingji.frameproject.mybatis.entity.StockTransferDetails;
import lombok.Data;

import java.util.List;

@Data
public class StockTransferDetailsVo {
    private StockTransfer stockTransfer;
    private List<StockTransferDetails> list;
}
