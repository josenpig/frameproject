package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.util.MessageUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.PurchaseReceiptConditionVo;
import com.xingji.frameproject.vo.PurchaseReturnVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
    private BaseOpeningService bos;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private BaseVendorService vendorService;
    @Resource
    private PurchaseReceiptService receiptService;
    @Resource
    private PurchaseReturnsDetailsService purchaseReturnsDetailsService;
    @Resource
    private CapitalPayableService payableService;
    @Resource
    private MessageUtil messageUtil;


    /**
     * 查询所有的可可以采购退货的订单
     * @return
     */
    @Log("查询所有的可可以采购退货的订单")
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
    @Log("新增采购入库")
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
        messageUtil.addMessage(Integer.parseInt(delivery.getBuyerName()),delivery.getId());
        return AjaxResponse.success(delivery.getId());
    }


    /**
     * 分页条件查询
     * @param conditionpage 条件查询信息
     * @return map数据
     */
    @Log("分页条件查询采购退货单")
    @PostMapping("/purchaseReturn/conditionpage")
    public AjaxResponse conditionpage(@RequestBody String conditionpage) {
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件
        PurchaseReceiptConditionVo order =JSON.parseObject(condition, PurchaseReceiptConditionVo.class);//查询条件Vo
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        System.out.println(order);
        System.out.println(currentPage);
        System.out.println(pageSize);
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<PurchaseReturns> list=returnsService.conditionpage(order);
        for(int i=0;i<list.size();i++){
            list.get(i).setVendorName(vendorService.findVendorName(list.get(i).getVendorName()));
            if(list.get(i).getVettingName()!=null) {
                list.get(i).setVettingName(sysUserService.queryUserNameByUserId(Integer.valueOf(list.get(i).getVettingName())));
            }
            list.get(i).setBuyerName(sysUserService.queryUserNameByUserId(Integer.valueOf(list.get(i).getBuyerName())));
        }
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }

    /**
     * 通过主键查询采购入库单及入库单详情
     * @param id 主键
     * @return 单条数据
     */
    @Log("查询采购退货单及退货单详情")
    @GetMapping("/purchaseReturn/find/{id}")
    public AjaxResponse find(@PathVariable("id") String id) {
        PurchaseReturns receipt=returnsService.queryById(id);
        List<PurchaseReturnsDetails> Details=purchaseReturnsDetailsService.queryAllByOrderId(id);
        receipt.setVendorName(vendorService.findVendorName(receipt.getVendorName()));
        receipt.setBuyerName(sysUserService.queryUserNameByUserId(Integer.valueOf(receipt.getBuyerName())));
        if (receipt.getVettingName()!=""&&receipt.getVettingName()!=null){
            receipt.setVettingName(sysUserService.queryUserNameByUserId(Integer.valueOf(receipt.getVettingName())));
        }
        PurchaseReturnVo vo=new PurchaseReturnVo();
        vo.setReturns(receipt);
        vo.setReturnsDetails(Details);
        return AjaxResponse.success(vo);
    }

    /**
     * 审核退货单
     * @param id 主键
     * @return 单条数据
     */
    @Log("审核退货单")
    @GetMapping("/purchaseReturn/approval")
    public AjaxResponse approval(String id,int type,String user){
        PurchaseReturns order = new PurchaseReturns();
        order.setId(id);
        order.setVettingState(type);
        order.setVettingName(String.valueOf(sysUserService.queryUserIdByUserName(user)));
        order.setLastVettingTime(new Date());
        order.setUpdateDate(new Date());
        PurchaseReturns returns=returnsService.update(order);
        if (type==1){
            CapitalPayable payable = new CapitalPayable();
            List<PurchaseReturnsDetails> details=returnsDetailsService.queryAllByOrderId(order.getId());
            for(PurchaseReturnsDetails prd:details){
                bos.productereduce(prd.getProductId(),prd.getDepotName(),prd.getReturnNum());
                bos.expectreduce(prd.getProductId(),prd.getDepotName(),prd.getReturnNum());
            }

            //新增应付单据
            payable.setDeliveryId(returns.getId());
            payable.setDeliveryTime(returns.getExitDate());
            payable.setVendor(returns.getVendorName());
            payable.setBuyer(returns.getBuyerName());
            payable.setPayables(returns.getOffersPrice());
            payable.setPaid(0.00);
            payable.setUnpaid(returns.getOffersPrice());
            payable.setFounder(user);
            payable.setCaseState(0);
            payable.setFounder(returns.getVettingName());
            payableService.insert(payable);
        }
        messageUtil.addMessages(Integer.parseInt(order.getVettingName()),Integer.parseInt(returnsService.queryById(order.getId()).getBuyerName()),order.getId(),type);
        return AjaxResponse.success(returns);
    }

}
