package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.SaleDeliveryVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (PurchaseReceipt)表控制层
 *
 * @author makejava
 * @since 2021-06-15 18:48:36
 */
@Slf4j
@RestController
@EnableSwagger2
@Api(description = "采购订单Api")
public class PurchaseReturnController {
    /**
     * 服务对象
     */
    @Resource
    private PurchaseReturnsService returnsService;
    @Resource
    private PurchaseReturnsDetailsService returnsDetailsService;
    @Resource
    private PurchaseReceiptDetailsService detailsService;
    @Resource
    private PurchaseOrderService orderService;
    @Resource
    private BaseOpeningService bos;
    @Resource
    private PurchaseOrderService purchaseOrderService;
    @Resource
    private CapitalPayableService payableService;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private BaseVendorService vendorService;
    @Resource
    private PurchaseReceiptService receiptService;


    /**
     * 查询所有的可可以采购退货的订单
     * @return
     */
    @PostMapping("/purchaseReturn/findcanReturn")
    public AjaxResponse findRetrun(){
        List<PurchaseReceipt> list = receiptService.queryAllByVettingState();
        return AjaxResponse.success(list);
    }

    /**
     * 新增采购入库-单
     * @param add 单据信息
     * @param type 是否为草稿
     * @return 订单id
     */
    @RequestMapping("purchaseReturn/add/{type}")
    public AjaxResponse add(@PathVariable("type") int type, @RequestBody String add){
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("order");
        PurchaseReturns delivery = JSON.parseObject(one, PurchaseReturns.class);
        String two = jsonObject.getString("orderdetails");
        List<PurchaseReturnsDetails> deliverydetails= JSONArray.parseArray(two, PurchaseReturnsDetails.class);
        delivery.setCreateDate(new Date());
        delivery.setState(type);
        delivery.setVettingState(0);
        //添加销售出库单信息
        for(int i=0;i<deliverydetails.size();i++){
            deliverydetails.get(i).setReturnId(delivery.getId());
        }
        delivery.setBuyerName(String.valueOf(sysUserService.queryUserIdByUserName(delivery.getBuyerName())));
        delivery.setVendorName(vendorService.findVendorId(delivery.getVendorName()));
        returnsService.insert(delivery);
        returnsDetailsService.insertBatch(deliverydetails);
        return AjaxResponse.success(delivery.getId());
    }


}
