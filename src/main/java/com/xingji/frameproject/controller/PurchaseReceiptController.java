package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.mybatis.entity.PurchaseReceipt;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.util.MessageUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.PurchaseReceiptConditionVo;
import com.xingji.frameproject.vo.PurchaseReceiptVo;
import com.xingji.frameproject.vo.SaleConditionPageVo;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (PurchaseReceipt)表控制层
 *
 * @author makejava
 * @since 2021-06-15 18:48:36
 */
@RestController
@RequestMapping("purchaseReceipt")
@Slf4j
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
    @Resource
    private SysUserService sysUserService;
    @Resource
    private BaseVendorService vendorService;
    @Resource
    private MessageUtil messageUtil;
    @Resource
    private CapitalPaymentBillService paymentBillService;
    @Resource
    private CapitalCavCiaBillService ciaBillService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Log("查询单个采购入库单")
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
    @Log("新增采购入库-单")
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
        delivery.setVettingName(null);
        delivery.setCreatePeople(String.valueOf(sysUserService.queryUserIdByUserName(delivery.getCreatePeople())));
        //添加销售出库单信息
        delivery.setBuyerName(String.valueOf(sysUserService.queryUserIdByUserName(delivery.getBuyerName())));
        for(int i=0;i<deliverydetails.size();i++){
            deliverydetails.get(i).setReceiptid(delivery.getId());
        }
        //如果存在采购订单，修改订单状态--绑定入库单
        if (delivery.getAssociatedOrder()!=null){
            PurchaseOrder saleOrder=orderService.queryById(delivery.getAssociatedOrder());
            saleOrder.setReceiptOrderId(delivery.getId());
            saleOrder.setUpdateDate(new Date());
            orderService.update(saleOrder);
            delivery.setVendorName(vendorService.findVendorId(delivery.getVendorName()));
        }
        purchaseReceiptService.insert(delivery);
        detailsService.insertBatch(deliverydetails);
        messageUtil.addMessage(Integer.parseInt(delivery.getCreatePeople()),delivery.getId());
        return AjaxResponse.success(delivery.getId());
    }


    /**
     * 通过主键查询采购入库单及入库单详情
     * @param id 主键
     * @return 单条数据
     */
    @Log("通过订单查询采购入库单及入库单详情")
    @GetMapping("/find/{id}")
    public AjaxResponse find(@PathVariable("id") String id) {
        PurchaseReceipt receipt=purchaseReceiptService.queryById(id);
        List<PurchaseReceiptDetails> deliveryDetails=detailsService.queryAllByOrderId(id);
        receipt.setVendorName(vendorService.findVendorName(receipt.getVendorName()));
        receipt.setBuyerName(sysUserService.queryUserNameByUserId(Integer.valueOf(receipt.getBuyerName())));

        if(!(receipt.getCreatePeople().equals("null"))&&receipt.getCreatePeople().length()!=0){
            receipt.setCreatePeople(sysUserService.queryUserNameByUserId(Integer.valueOf(receipt.getCreatePeople())));
        }

        List<CapitalPaymentBill> paymentBills = paymentBillService.relation(receipt.getId());
        List<CapitalCavCiaBill> ciaBills = ciaBillService.relation(receipt.getId());
        PurchaseReceiptVo vo=new PurchaseReceiptVo();
        vo.setReceipt(receipt);
        vo.setReceiptDetails(deliveryDetails);
        vo.setPaymentBills(paymentBills);
        vo.setCiaBills(ciaBills);
        return AjaxResponse.success(vo);
    }

    /**
     * 修改采购出入库单审批状态
     * @param orderid 主键
     * @return 数据
     */
    @Log("修改采购出入库单审批状态")
    @GetMapping("/approval")
    public AjaxResponse approvalorder(String orderid,int type,String user){
        PurchaseReceipt receipt = purchaseReceiptService.queryById(orderid);
        receipt.setUpdateDate(new Date());
        receipt.setVettingState(type);
        receipt.setVettingName(String.valueOf(sysUserService.queryUserIdByUserName(user)));
        receipt.setUpdatePeople(String.valueOf(sysUserService.queryUserIdByUserName(user)));

        purchaseReceiptService.update(receipt);
        //审批通过产品入库加上当前库存数量与预计库存数量
        if(type == 1) {
            List<PurchaseReceiptDetails> details=detailsService.queryAllByOrderId(receipt.getId());
            for(PurchaseReceiptDetails prd:details){
                List<BaseOpening> baseOpenings = bos.queryAll(new BaseOpening());
                boolean flag = true;
                for (BaseOpening opening:baseOpenings){
                    System.out.println(opening.getDepotName().equals(prd.getDepotName())&&opening.getProductId().equals(prd.getProductId()));
                    if (opening.getDepotName().equals(prd.getDepotName())&&opening.getProductId().equals(prd.getProductId())){
                        bos.producteadd(prd.getProductId(),prd.getDepotName(),prd.getProductNum());
                        bos.expectadd(prd.getProductId(),prd.getDepotName(),prd.getProductNum());
                        flag=false;
                    }
                }
                if (flag){
                    BaseOpening baseOpening = new BaseOpening();
                    baseOpening.setProductId(prd.getProductId());
                    baseOpening.setDepotName(prd.getDepotName());
                    baseOpening.setOpeningNumber(prd.getProductNum());
                    baseOpening.setProductNumber(prd.getProductNum());
                    baseOpening.setExpectNumber(prd.getProductNum());
                    System.out.println(baseOpening.toString());
                    bos.insert(baseOpening);
                }

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
            payable.setFounder(receipt.getCreatePeople());
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
        messageUtil.addMessages(Integer.parseInt(receipt.getVettingName()),Integer.parseInt(purchaseReceiptService.queryById(orderid).getCreatePeople()),orderid,type);
        return AjaxResponse.success(receipt);
    }


    /**
     * 分页条件查询
     * @param conditionpage 条件查询信息
     * @return map数据
     */
    @Log("分页条件查询采购出入库单")
    @PostMapping("/conditionpage")
    public AjaxResponse conditionpage(@RequestBody String conditionpage) {
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件
        PurchaseReceiptConditionVo order =JSON.parseObject(condition, PurchaseReceiptConditionVo.class);//查询条件Vo
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<PurchaseReceipt> list=purchaseReceiptService.conditionpage(order);
        for(int i=0;i<list.size();i++){
            list.get(i).setVendorName(vendorService.findVendorName(list.get(i).getVendorName()));
            if(list.get(i).getVettingName()!=null) {
                list.get(i).setVettingName(sysUserService.queryUserNameByUserId(Integer.valueOf(list.get(i).getVettingName())));
            }
            list.get(i).setBuyerName(sysUserService.queryUserNameByUserId(Integer.valueOf(list.get(i).getBuyerName())));
            list.get(i).setCreatePeople(sysUserService.queryUserNameByUserId(Integer.valueOf(list.get(i).getCreatePeople())));
        }
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }

}
