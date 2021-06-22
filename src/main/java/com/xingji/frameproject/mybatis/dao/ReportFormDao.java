package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.vo.FundAccountsStatisticsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportFormDao {
    /**
     * 资金账户汇总表
     * @param fundAccountsStatisticsVo
     * @return
     */
    List<FundAccountsStatisticsVo> fundAllFundAccountsStatisticsVo(FundAccountsStatisticsVo fundAccountsStatisticsVo);
}
