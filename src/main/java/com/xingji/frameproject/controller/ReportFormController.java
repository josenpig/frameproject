package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.BaseCustomer;
import com.xingji.frameproject.mybatis.entity.BaseProduct;
import com.xingji.frameproject.mybatis.entity.BaseUnit;
import com.xingji.frameproject.service.BaseDepotService;
import com.xingji.frameproject.service.BaseOpeningService;
import com.xingji.frameproject.service.ReportFormService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.FundAccountsStatisticsVo;
import com.xingji.frameproject.vo.ProductInventoryVo;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
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
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        FundAccountsStatisticsVo fundAccountsStatisticsVo = new FundAccountsStatisticsVo();
        if(startTime!=null && endTime!=null) {
            System.out.println("startTime:"+startTime);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = simpleDateFormat.parse(startTime);
            fundAccountsStatisticsVo.setStartTime(date1);

            System.out.println("endTime:"+endTime);
            Date date2 = simpleDateFormat.parse(endTime);
            fundAccountsStatisticsVo.setEndTime(date2);
        }
        System.out.println(fundAccountsStatisticsVo);
        List<FundAccountsStatisticsVo> list=reportFormService.fundAllFundAccountsStatisticsVo(fundAccountsStatisticsVo);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };

    /**
     * 资金账户期间总收入和总支出
     * @return 客户集合
     */
    @GetMapping("/fundAllRsumAndPsum")
    public AjaxResponse fundAllRsumAndPsum(@Param("startTime") String startTime, @Param("endTime") String endTime) throws ParseException {
        System.out.println("fundAllRsumAndPsum");
        System.out.println(startTime);
        System.out.println(endTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1=null;
        Date date2=null;
        if(startTime!=null && endTime!=null) {
            System.out.println("startTime:"+startTime);
            date1 = simpleDateFormat.parse(startTime);

            System.out.println("endTime:"+endTime);
            date2 = simpleDateFormat.parse(endTime);
        }
        System.out.println(date1+",,,,"+date2);
        List<Double> list=reportFormService.fundAllRsumAndPsum(date1,date2);
        System.out.println(list);
        return AjaxResponse.success(list);
    };

    /**
     * 所有产品库存 根据实体类中的条件查询
     * @return 客户集合
     */
    @GetMapping("/findAllProductInventoryVo")
    public AjaxResponse findAllProductInventoryVo(@Param("depotName")String depotName, @Param("productName") String productName,@Param("productTypeName")String productTypeName, @Param("state") String state,@Param("currentPage")Integer currentPage, @Param("pageSize") Integer pageSize) throws ParseException {
        System.out.println(depotName+"+++"+productName+"+++"+productTypeName+"+++"+state);
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        ProductInventoryVo productInventoryVo = new ProductInventoryVo();
        if(!depotName.equals("全部")) {
            productInventoryVo.setDepotName(depotName);
        }
        if(!productName.equals("全部")) {
            productInventoryVo.setProductName(productName);
        }
        if(!productTypeName.equals("全部")) {
            productInventoryVo.setProductTypeName(productTypeName);
        }
        if(state.equals("是")) {
            productInventoryVo.setState(0);
        }
        if(state.equals("否")) {
            productInventoryVo.setState(1);
        }
        System.out.println(productInventoryVo);
        List<ProductInventoryVo> list=reportFormService.findAllProductInventoryVo(productInventoryVo);
        System.out.println("ProductInventoryVo:"+list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };

    /**
     * 资金账户期间总收入和总支出
     * @return 客户集合
     */
    @GetMapping("/fundAllCount")
    public AjaxResponse fundAllRsumAndPsum() throws ParseException {
        List<Integer> list=this.reportFormService.findAllCount();
        return AjaxResponse.success(list);
    };
}
