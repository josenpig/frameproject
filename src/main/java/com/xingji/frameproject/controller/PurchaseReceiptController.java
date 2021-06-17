package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.mybatis.entity.PurchaseReceipt;
import com.xingji.frameproject.service.PurchaseOrderService;
import com.xingji.frameproject.service.PurchaseReceiptDetailsService;
import com.xingji.frameproject.service.PurchaseReceiptService;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.PurchaseReceiptVo;
import com.xingji.frameproject.vo.SaleDeliveryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (PurchaseReceipt)表控制层
 *
 * @author makejava
 * @since 2021-06-15 18:48:36
 */
@RestController
@RequestMapping("purchaseReceipt")
public class PurchaseReceiptController {
    /**
     * 服务对象
     */
    @Resource
    private PurchaseReceiptService purchaseReceiptService;
    @Resource
    private PurchaseReceiptDetailsService detailsService;
    @Resource
    private PurchaseOrderService orderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PurchaseReceipt selectOne(String id) {
        return this.purchaseReceiptService.queryById(id);
    }

    /**
     * 新增采购入库-单
     * @param add 单据信息
     * @param type 是否为草稿
     * @return 订单id
     */
    @RequestMapping("/add/{type}")
    public AjaxResponse add(@PathVariable("type") int type, @RequestBody String add){
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("receipt");
        PurchaseReceipt delivery = JSON.parseObject(one, PurchaseReceipt.class);
        String two = jsonObject.getString("receiptdetails");
        List<PurchaseReceiptDetails> deliverydetails= JSONArray.parseArray(two, PurchaseReceiptDetails.class);
        delivery.setLastVettingTime(new Date());
        delivery.setCreateDate(new Date());
        delivery.setState(type);
        delivery.setVettingState(0);
        //添加销售出库单信息
        for(int i=0;i<deliverydetails.size();i++){
            deliverydetails.get(i).setReceiptid(delivery.getId());
        }
        purchaseReceiptService.insert(delivery);
        detailsService.insertBatch(deliverydetails);
        //如果存在采购订单，修改订单状态--绑定入库单
        if (delivery.getAssociatedOrder()!=null){
            PurchaseOrder saleOrder=orderService.queryById(delivery.getAssociatedOrder());
            saleOrder.setReceiptOrderId(delivery.getId());
            saleOrder.setUpdateDate(new Date());
            orderService.update(saleOrder);
        }
        return AjaxResponse.success(delivery.getId());
    }


    /**
     * 通过主键查询采购入库单及入库单详情
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/find/{id}")
    public AjaxResponse find(@PathVariable("id") String id) {
        PurchaseReceipt receipt=purchaseReceiptService.queryById(id);
        List<PurchaseReceiptDetails> deliveryDetails=detailsService.queryAllByOrderId(id);
        PurchaseReceiptVo vo=new PurchaseReceiptVo();
        vo.setReceipt(receipt);
        vo.setReceiptDetails(deliveryDetails);
        return AjaxResponse.success(vo);
    }

}
