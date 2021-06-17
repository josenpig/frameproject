package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.mybatis.entity.PurchaseReceipt;
import com.xingji.frameproject.service.*;
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
    @Resource
    private BaseOpeningService bos;
    @Resource
    private PurchaseOrderService purchaseOrderService;
    @Resource
    private CapitalPayableService payableService;

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

    /**
     * 修改采购出入库单审批状态
     * @param orderid 主键
     * @return 数据
     */
    @GetMapping("/approval")
    public AjaxResponse approvalorder(String orderid,int type,String user){
        PurchaseReceipt receipt = purchaseReceiptService.queryById(orderid);
        receipt.setUpdateDate(new Date());
        receipt.setVettingState(type);
        receipt.setVettingName(user);
        receipt.setUpdatePeople(user);

        purchaseReceiptService.update(receipt);
        //审批通过产品入库加上当前库存数量与预计库存数量
        if(type == 1) {
            List<PurchaseReceiptDetails> details=detailsService.queryAllByOrderId(receipt.getId());
            for(PurchaseReceiptDetails prd:details){
                bos.producteadd(prd.getProductId(),prd.getDepotName(),prd.getProductNum());
                bos.expectadd(prd.getProductId(),prd.getDepotName(),prd.getProductNum());
            }
            //新增应付单据
            CapitalPayable payable=new CapitalPayable();
            payable.setDeliveryId(receipt.getId());
            payable.setDeliveryTime(receipt.getInboundDate());
            payable.setVendor(receipt.getVendorName());
            payable.setBuyer(receipt.getBuyerName());
            payable.setPayables(receipt.getOffersPrice());
            payable.setPaid(0.00);
            payable.setUnpaid(receipt.getOffersPrice());
            payable.setFounder(user);
            payable.setCaseState(0);
            payableService.insert(payable);
        }
        //如果绑定了订单就修改订单为已出库
        if (type == 1 && receipt.getAssociatedOrder()!=null){
            PurchaseOrder order= purchaseOrderService.queryById(receipt.getAssociatedOrder());
            order.setUpdateDate(new Date());
            order.setInboundState(1);
            order.setOrderState(1);
            purchaseOrderService.update(order);
        }
        return AjaxResponse.success(receipt);
    }

}
