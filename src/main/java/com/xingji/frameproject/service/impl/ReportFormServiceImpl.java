package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.BaseCustomerDao;
import com.xingji.frameproject.mybatis.dao.ReportFormDao;
import com.xingji.frameproject.service.ReportFormService;
import com.xingji.frameproject.vo.FundAccountsStatisticsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ReportFormService")
public class ReportFormServiceImpl implements ReportFormService {
    @Resource
    private ReportFormDao reportFormDao;

    @Override
    public List<FundAccountsStatisticsVo> fundAllFundAccountsStatisticsVo(FundAccountsStatisticsVo fundAccountsStatisticsVo) {
        return reportFormDao.fundAllFundAccountsStatisticsVo(fundAccountsStatisticsVo);
    }
}
