package com.xingji.frameproject.service;

import com.xingji.frameproject.vo.FundAccountsStatisticsVo;

import java.util.List;

public interface ReportFormService {
    /**
     * 资金账户汇总表
     * @param fundAccountsStatisticsVo
     * @return
     */
    List<FundAccountsStatisticsVo> fundAllFundAccountsStatisticsVo(FundAccountsStatisticsVo fundAccountsStatisticsVo);

}
