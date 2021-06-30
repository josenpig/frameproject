package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.BaseCustomerDao;
import com.xingji.frameproject.mybatis.dao.ReportFormDao;
import com.xingji.frameproject.service.ReportFormService;
import com.xingji.frameproject.vo.FundAccountsStatisticsVo;
import com.xingji.frameproject.vo.ProductInventoryVo;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("ReportFormService")
public class ReportFormServiceImpl implements ReportFormService {
    @Resource
    private ReportFormDao reportFormDao;

    @Override
    public List<FundAccountsStatisticsVo> fundAllFundAccountsStatisticsVo(FundAccountsStatisticsVo fundAccountsStatisticsVo) {
        return reportFormDao.fundAllFundAccountsStatisticsVo(fundAccountsStatisticsVo);
    }

    @Override
    public List<Double> fundAllRsumAndPsum(Date startTime,Date endTime) {
        List<Double> list=new ArrayList<>();
        Double rsum=reportFormDao.fundAllRsum(startTime,endTime);
        Double psum=reportFormDao.fundAllPsum(startTime,endTime);
        list.add(rsum);
        list.add(psum);
        return  list;
    }

    @Override
    public List<ProductInventoryVo> findAllProductInventoryVo(ProductInventoryVo productInventoryVo) {
        return reportFormDao.findAllProductInventoryVo(productInventoryVo);
    }

    /**
     * 资金收款，付款总条数
     */
    @Override
    public List<Integer> findAllCount() {
        List<Integer> list=new ArrayList<>();
        list.add(this.reportFormDao.fundAllPcount());//付款条数
        list.add(this.reportFormDao.fundAllRcount());//收款条数
        return list;
    }
}
