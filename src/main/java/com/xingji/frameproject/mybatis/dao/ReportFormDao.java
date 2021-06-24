package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.vo.FundAccountsStatisticsVo;
import com.xingji.frameproject.vo.ProductInventoryVo;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface ReportFormDao {
    /**
     * 资金账户汇总表 根据实体类中的条件查询
     * @param fundAccountsStatisticsVo
     * @return
     */
    List<FundAccountsStatisticsVo> fundAllFundAccountsStatisticsVo(FundAccountsStatisticsVo fundAccountsStatisticsVo);

    /**
     * 资金账户期间总收入
     * @return
     */
    Double fundAllRsum(Date startTime,Date endTime);

    /**
     * 资金账户期间总支出
     * @return
     */
    Double fundAllPsum(Date startTime,Date endTime);

    /**************************/

    /**
     * 所有产品库存 根据实体类中的条件查询
     * @param productInventoryVo
     * @return
     */
    List<ProductInventoryVo> findAllProductInventoryVo(ProductInventoryVo productInventoryVo);
}
