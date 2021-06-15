package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.util.JwtTokenUtil;
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

    /**
     * 通过主键查询销售退货单及销售t退货单详情
     * @param id 主键
     * @return vo数据
     */
    @GetMapping("/find/{id}")
    public AjaxResponse selectOne(@PathVariable("id") String id) {
        SaleReturn saleReturn=srs.queryById(id);
        List<SaleReturnDetails> returnDetails=srds.queryById(id);
        SaleReturnVo vo=new SaleReturnVo();
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
    @RequestMapping("/add/{type}")
    public AjaxResponse add(@PathVariable("type") int type,@RequestBody String add){
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("order");
        SaleReturn salereturn = JSON.parseObject(one, SaleReturn.class);
        String two = jsonObject.getString("orderdetails");
        List<SaleReturnDetails> salereturndetails= JSONArray.parseArray(two, SaleReturnDetails.class);
        salereturn.setFoundTime(new Date());
        salereturn.setUpdateTime(new Date());
        salereturn.setApprovalState(type);
        salereturn.setOrderState(0);
        salereturn.setReturnState(0);
        //添加销售退货单信息
        for(int i=0;i<salereturndetails.size();i++){
            salereturndetails.get(i).setReturnId(salereturn.getReturnId());
        }
        srs.insert(salereturn);
        srds.insertBatch(salereturndetails);
        //如果存在销售订单，绑定退货单
        if (salereturn.getOrderId()!=null){
            SaleOrder saleOrder=new SaleOrder();
            saleOrder.setReturnId(salereturn.getReturnId());
            saleOrder.setOrderId(salereturn.getOrderId());
            saleOrder.setUpdateTime(new Date());
            sos.update(saleOrder);
        }
        SaleDelivery saleDelivery=new SaleDelivery();
        saleDelivery.setDeliveryId(salereturn.getDeliveryId());
        saleDelivery.setReturnId(salereturn.getReturnId());
        saleDelivery.setUpdateTime(new Date());
        sds.update(saleDelivery);
        return AjaxResponse.success(salereturn.getReturnId());
    }
    /**
     * 修改销售退货单审批状态
     * @param orderid 主键
     * @return 数据
     */
    @GetMapping("/approval")
    public AjaxResponse approvalorder(String orderid,int type,String user,String approvalremarks){
        SaleReturn order=new SaleReturn();
        order.setReturnId(orderid);
        order.setApprovalState(type);
        order.setApprover(user);
        order.setApprovalRemarks(approvalremarks);
        order.setLastApprovalTime(new Date());
        order.setUpdateTime(new Date());
        SaleReturn saleReturn=srs.update(order);
        //审批通过产品入库增加当前库存数量
        if(type == 1) {
            order.setOrderState(1);
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
        return AjaxResponse.success(saleReturn);
    }
    /**
     * 分页条件查询
     * @param conditionpage 条件查询信息
     * @return map数据
     */
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
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
}