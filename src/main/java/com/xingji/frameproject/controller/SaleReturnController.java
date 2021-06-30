package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.util.MessageUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.SaleConditionPageVo;
import com.xingji.frameproject.vo.SaleDeliveryVo;
import com.xingji.frameproject.vo.SaleReturnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (SaleReturn)表控制层
 *
 * @author makejava
 * @since 2021-05-30 19:06:16
 */
@RestController
@RequestMapping("/salereturn")
public class SaleReturnController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private SaleReturnService srs;
    @Resource
    private SaleReturnDetailsService srds;
    @Resource
    private SaleOrderService sos;
    @Resource
    private SaleDeliveryService sds;
    @Resource
    private BaseOpeningService bos;
    @Resource
    private CapitalReceivableService crs;
    @Resource
    private SysUserService sus;
    @Resource
    private CapitalReceiptBillService srbs;
    @Resource
    private CapitalCavCiaBillService cccbs;
    @Resource
    private MessageUtil messageUtil;

    /**
     * 通过主键查询销售退货单及销售退货单详情
     * @param id 主键
     * @return vo数据
     */
    @Log("查询销售退货单及销售退货单详情")
    @GetMapping("/find/{id}")
    public AjaxResponse selectOne(@PathVariable("id") String id) {
        SaleReturn saleReturn=srs.queryByIdVo(id);
        List<SaleReturnDetails> returnDetails=srds.queryById(id);
        SaleReturnVo vo=new SaleReturnVo();
        saleReturn.setFounder(sus.queryById(Integer.valueOf(saleReturn.getFounder())).getUserName());
        if(saleReturn.getApprover()!=null) {
            saleReturn.setApprover(sus.queryById(Integer.valueOf(saleReturn.getApprover())).getUserName());
        }
        saleReturn.setSalesmen(sus.queryById(Integer.valueOf(saleReturn.getSalesmen())).getUserName());
        //查询关联单据
        List<CapitalReceiptBill> bills=srbs.relation(id);
        saleReturn.setReceipts(bills);
        List<CapitalCavCiaBill> bills1=cccbs.relation(id);
        saleReturn.setCavcias(bills1);
        vo.setSalereturn(saleReturn);
        vo.setReturndetails(returnDetails);
        return AjaxResponse.success(vo);
    }
    /**
     * 新增销售退货单
     * @param add 单据信息
     * @param type 是否为草稿
     * @return 订单id
     */
    @Log("新增销售退货单")
    @RequestMapping("/add/{type}")
    public AjaxResponse add(@PathVariable("type") int type,@RequestBody String add){
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("order");
        SaleReturn salereturn = JSON.parseObject(one, SaleReturn.class);
        String two = jsonObject.getString("orderdetails");
        List<SaleReturnDetails> salereturndetails= JSONArray.parseArray(two, SaleReturnDetails.class);
        //添加销售退货单信息
        for(int i=0;i<salereturndetails.size();i++){
            salereturndetails.get(i).setReturnId(salereturn.getReturnId());
        }
        //判断该订单是否为草稿单-----若为编辑单则修改数据
        if(salereturn.getApprovalState()!=null && salereturn.getApprovalState()!=1){
            //判断该单据是否为二次提交单据及驳回单或作废单
            if(salereturn.getApprovalState()==-3||salereturn.getApprovalState()==-1){
                salereturn.setApprover("清空");
                salereturn.setApprovalRemarks("清空");
            }
            srds.deleteById(salereturn.getReturnId());
            salereturn.setApprovalState(type);//订单状态
            salereturn.setUpdateTime(new Date());
            salereturn.setSalesmen(String.valueOf(sus.queryUserIdByUserName(salereturn.getSalesmen())));
            srs.update(salereturn);
        }else {
            //反之添加订单信息
            salereturn.setFounder(String.valueOf(sus.queryUserIdByUserName(salereturn.getFounder())));
            salereturn.setSalesmen(String.valueOf(sus.queryUserIdByUserName(salereturn.getSalesmen())));
            salereturn.setFoundTime(new Date());
            salereturn.setApprovalState(type);//订单状态
            salereturn.setOrderState(0);
            salereturn.setReturnState(0);
            //绑定订单
            SaleDelivery delivery = sds.queryByIdVo(salereturn.getDeliveryId());
            if (delivery.getOrderId() != null) {
                salereturn.setOrderId(delivery.getOrderId());
            }
            srs.insert(salereturn);
            if(type==0){
                messageUtil.addMessage(Integer.parseInt(salereturn.getFounder()),salereturn.getOrderId());
            }
            //如果存在销售订单，绑定退货单
            if (salereturn.getOrderId() != null) {
                SaleOrder saleOrder = new SaleOrder();
                saleOrder.setReturnId(salereturn.getReturnId());
                saleOrder.setOrderId(salereturn.getOrderId());
                saleOrder.setUpdateTime(new Date());
                sos.update(saleOrder);
            }
            SaleDelivery saleDelivery = new SaleDelivery();
            saleDelivery.setDeliveryId(salereturn.getDeliveryId());
            saleDelivery.setReturnId(salereturn.getReturnId());
            saleDelivery.setUpdateTime(new Date());
            sds.update(saleDelivery);
        }
        srds.insertBatch(salereturndetails);
        return AjaxResponse.success(salereturn.getReturnId());
    }
    /**
     * 通过主键删除订单
     * @param id 主键
     * @return 数据
     */
    @Log("删除销售退货单")
    @RequestMapping("/detele/{id}")
    public AjaxResponse detele(@PathVariable("id") String id) {
        SaleReturn saleReturn=srs.queryById(id);
        srds.deleteById(id);
        //删除关联单据
        if(saleReturn.getOrderId()!=null) {
            SaleOrder saleOrder = new SaleOrder();
            saleOrder.setReturnId("清空");
            saleOrder.setUpdateTime(new Date());
            saleOrder.setOrderId(saleReturn.getOrderId());
            sos.update(saleOrder);
        }
        SaleDelivery saleDelivery = new SaleDelivery();
        saleDelivery.setReturnId("清空");
        saleDelivery.setUpdateTime(new Date());
        saleDelivery.setOrderId(saleReturn.getDeliveryId());
        sds.update(saleDelivery);
        return AjaxResponse.success(srs.deleteById(id));
    }
    /**
     * 通过主键更改订单
     * @param id 主键
     * @return 数据
     */
    @Log("更改销售退货单")
    @RequestMapping("/update")
    public AjaxResponse update(String id,Integer type) {
        SaleReturn saleReturn=new SaleReturn();
        saleReturn.setReturnId(id);
        saleReturn.setApprovalState(type);
        if(type==-3) {
            //恢复产品预计可用量
            List<SaleReturnDetails> returnDetails = srds.queryById(id);
            for (SaleReturnDetails sdd : returnDetails) {
                bos.productereduce(sdd.getProductId(), sdd.getDepot(), sdd.getReturnNum());
                bos.expectreduce(sdd.getProductId(), sdd.getDepot(), sdd.getReturnNum());
            }
            crs.deleteById(id);
        }
        return AjaxResponse.success(srs.update(saleReturn).getReturnId());
    }
    /**
     * 修改销售退货单审批状态
     * @param orderid 主键
     * @return 数据
     */
    @Log("修改销售退货单审批状态")
    @GetMapping("/approval")
    public AjaxResponse approvalorder(String orderid,int type,String user,String approvalremarks){
        SaleReturn order=new SaleReturn();
        order.setReturnId(orderid);
        order.setApprovalState(type);
        order.setApprover(String.valueOf(sus.queryUserIdByUserName(user)));
        order.setApprovalRemarks(approvalremarks);
        order.setLastApprovalTime(new Date());
        order.setUpdateTime(new Date());
        SaleReturn saleReturn=srs.update(order);
        //审批通过产品入库增加当前库存数量
        if(type == 1) {
            List<SaleReturnDetails> returnDetails=srds.queryById(orderid);
            for(SaleReturnDetails sdd:returnDetails){
                bos.producteadd(sdd.getProductId(),sdd.getDepot(),sdd.getReturnNum());
                bos.expectadd(sdd.getProductId(),sdd.getDepot(),sdd.getReturnNum());
            }
            //新增应收单据
            CapitalReceivable receivable=new CapitalReceivable();
            receivable.setDeliveryId(saleReturn.getReturnId());
            receivable.setDeliveryTime(saleReturn.getReturnTime());
            receivable.setCustomer(saleReturn.getCustomer());
            receivable.setSalesmen(saleReturn.getSalesmen());
            receivable.setReceivables(saleReturn.getReceivables());
            receivable.setReceived(0.00);
            receivable.setUncollected(saleReturn.getReceivables());
            receivable.setRemarks(saleReturn.getRemarks());
            receivable.setFounder(saleReturn.getFounder());
            receivable.setCaseState(0);
            crs.insert(receivable);
        }
        messageUtil.addMessages(Integer.parseInt(order.getApprover()),Integer.parseInt(sos.queryById(orderid).getFounder()),orderid,type);
        return AjaxResponse.success(saleReturn);
    }
    /**
     * 分页条件查询
     * @param conditionpage 条件查询信息
     * @return map数据
     */
    @Log("分页条件查询销售退货单")
    @PostMapping("/conditionpage")
    public AjaxResponse conditionpage(@RequestBody String conditionpage) {
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件
        SaleConditionPageVo order =JSON.parseObject(condition, SaleConditionPageVo.class);
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<SaleReturn> list=srs.conditionpage(order);
        for(int i=0;i<list.size();i++){
            list.get(i).setFounder(sus.queryById(Integer.valueOf(list.get(i).getFounder())).getUserName());
            if(list.get(i).getApprover()!=null){
                list.get(i).setApprover(sus.queryById(Integer.valueOf(list.get(i).getApprover())).getUserName());
            }
            list.get(i).setSalesmen(sus.queryById(Integer.valueOf(list.get(i).getSalesmen())).getUserName());
        }
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
}