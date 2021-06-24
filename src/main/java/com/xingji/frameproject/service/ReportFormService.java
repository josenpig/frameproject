package com.xingji.frameproject.service;

import com.xingji.frameproject.vo.FundAccountsStatisticsVo;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.Date;
import java.util.List;

public interface ReportFormService {
    /**
     * 资金账户汇总表
     * @param fundAccountsStatisticsVo
     * @return
     */
    List<FundAccountsStatisticsVo> fundAllFundAccountsStatisticsVo(FundAccountsStatisticsVo fundAccountsStatisticsVo);

    /**
     * 资金账户期间总收入和总支出
     * @param startTime,endTime
     * @return
     */
    List<Double> fundAllRsumAndPsum(Date startTime,Date endTime);

}
