package com.xingji.frameproject.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.BaseCustomer;
import com.xingji.frameproject.mybatis.entity.BaseUnit;
import com.xingji.frameproject.service.BaseDepotService;
import com.xingji.frameproject.service.BaseOpeningService;
import com.xingji.frameproject.service.ReportFormService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.FundAccountsStatisticsVo;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ReportFormController")
public class ReportFormController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private ReportFormService reportFormService;

    /**
     * 资金账户汇总表
     * @return 客户集合
     */
    @GetMapping("/fundAllFundAccountsStatisticsVo")
    public AjaxResponse fundAllFundAccountsStatisticsVo(@Param("currentPage")Integer currentPage, @Param("pageSize") Integer pageSize, @Param("startTime") String startTime, @Param("endTime") String endTime) throws ParseException {
        System.out.println(startTime+"++++"+endTime);
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        FundAccountsStatisticsVo fundAccountsStatisticsVo = new FundAccountsStatisticsVo();
        if(startTime!="") {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = simpleDateFormat.parse(startTime);
            fundAccountsStatisticsVo.setStartTime(date1);
        }
        if(endTime!=""){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date2 = simpleDateFormat.parse(endTime);
            fundAccountsStatisticsVo.setEndTime(date2);
        }
        List<FundAccountsStatisticsVo> list=reportFormService.fundAllFundAccountsStatisticsVo(fundAccountsStatisticsVo);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };
}
