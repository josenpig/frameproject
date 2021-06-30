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
import com.xingji.frameproject.vo.SaleProductVo;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (SaleDelivery)表控制层
 *
 * @author makejava
 * @since 2021-05-24 11:46:06
 */
@RestController
@RequestMapping("/saledelivery")
public class SaleDeliveryController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private SaleDeliveryService sds;
    @Resource
    private SaleDeliveryDetailsService sdds;
    @Resource
    private SaleOrderService sos;
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
    private BaseProductService baseProductService;
    @Resource
    private BaseOpeningService baseOpeningService;

    /**
     * 通过主键查询销售出库单及出库单详情
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/find/{id}")
    public AjaxResponse selectOne(@PathVariable("id") String id) {
        SaleDelivery delivery=sds.queryByIdVo(id);
        List<SaleDeliveryDetails> deliveryDetails=sdds.queryById(id);
        SaleDeliveryVo vo=new SaleDeliveryVo();
        delivery.setFounder(sus.queryById(Integer.valueOf(delivery.getFounder())).getUserName());
        if (delivery.getApprover()!=null) {
            delivery.setApprover(sus.queryById(Integer.valueOf(delivery.getApprover())).getUserName());
        }
        delivery.setSalesmen(sus.queryById(Integer.valueOf(delivery.getSalesmen())).getUserName());
        //查询订单是否为草稿
        if(delivery.getApprovalState()!=1){
            List<SaleProductVo> SaleProductVo=baseProductService.allsaleproduct(new SaleProductVo());
            for(SaleProductVo product:SaleProductVo){
                product.setBaseOpenings(baseOpeningService.finddepot(product.getProductId()));
            }
            vo.setSaleProductVos(SaleProductVo);
        }
        //查询关联单据
        List<CapitalReceiptBill> bills=srbs.relation(id);
        delivery.setReceipts(bills);
        List<CapitalCavCiaBill> bills1=cccbs.relation(id);
        delivery.setCavcias(bills1);
        vo.setDelivery(delivery);
        vo.setDeliverydetails(deliveryDetails);
        return AjaxResponse.success(vo);
    }
    /**
     * 新增销售出库单
     * @param add 单据信息
     * @param type 是否为草稿
     * @return 订单id
     */
    @RequestMapping("/add/{type}")
    public AjaxResponse add(@PathVariable("type") int type,@RequestBody String add){
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("delivery");
        SaleDelivery delivery = JSON.parseObject(one, SaleDelivery.class);
        String two = jsonObject.getString("deliverydetails");
        List<SaleDeliveryDetails> deliverydetails= JSONArray.parseArray(two, SaleDeliveryDetails.class);
        //添加销售出库单信息
        for (int i = 0; i < deliverydetails.size(); i++) {
            deliverydetails.get(i).setDeliveryId(delivery.getDeliveryId());
        }
        //判断该订单是否为编辑单-----若为编辑单则修改数据
        if(delivery.getApprovalState()!=null && delivery.getApprovalState()!=1){
            //为编辑单时恢复产品预计可用量
            if(delivery.getOrderId()==null && delivery.getApprovalState()>=0) {//若单据为作废单,驳回单或草稿单则不进行该操作-3/-2/-1
                List<SaleDeliveryDetails> deliveryDetails = sdds.queryById(delivery.getDeliveryId());
                for (SaleDeliveryDetails sdd : deliveryDetails) {
                    bos.expectadd(sdd.getProductId(), sdd.getDepot(), sdd.getProductNum());
                }
            }
            //判断该单据是否为二次提交单据及驳回单或作废单
            if(delivery.getApprovalState()==-3||delivery.getApprovalState()==-1){
                delivery.setApprover("清空");
                delivery.setApprovalRemarks("清空");
            }
            sdds.deleteById(delivery.getDeliveryId());
            delivery.setApprovalState(type);//订单状态
            delivery.setUpdateTime(new Date());
            sds.update(delivery);
        }else {
            //反之添加订单信息
            delivery.setFounder(String.valueOf(sus.queryUserIdByUserName(delivery.getFounder())));
            delivery.setFoundTime(new Date());
            delivery.setOrderState(0);
            delivery.setDeliveryState(0);
            delivery.setApprovalState(type);//订单状态
            sds.insert(delivery);
        }
        //如果存在销售订单，修改订单状态--绑定出库单
        if (delivery.getOrderId()!=null){
            SaleOrder saleOrder=new SaleOrder();
            saleOrder.setDeliveryId(delivery.getDeliveryId());
            saleOrder.setUpdateTime(new Date());
            saleOrder.setOrderId(delivery.getOrderId());
            sos.update(saleOrder);
        }
        sdds.insertBatch(deliverydetails);
        //出库单生成减去预计库存数量--关联订单为空状态下
        if(type == 0 && delivery.getOrderId()==null) {
            List<SaleDeliveryDetails> deliveryDetails=sdds.queryById(delivery.getDeliveryId());
            for(SaleDeliveryDetails sdd:deliveryDetails){
                bos.expectreduce(sdd.getProductId(),sdd.getDepot(),sdd.getProductNum());
            }
        }
        return AjaxResponse.success(delivery.getDeliveryId());
    }
    /**
     * 通过主键删除订单
     * @param id 主键
     * @return 数据
     */
    @RequestMapping("/detele/{id}")
    public AjaxResponse detele(@PathVariable("id") String id) {
        SaleDelivery saleDelivery=sds.queryById(id);
        sdds.deleteById(id);
        //删除关联单据
        if(saleDelivery.getOrderId()!=null) {
            SaleOrder saleOrder = new SaleOrder();
            saleOrder.setDeliveryId("清空");
            saleOrder.setUpdateTime(new Date());
            saleOrder.setOrderId(saleDelivery.getOrderId());
            sos.update(saleOrder);
        }
        return AjaxResponse.success(sds.deleteById(id));
    }
    /**
     * 通过主键更改订单
     * @param id 主键
     * @return 数据
     */
    @RequestMapping("/update")
    public AjaxResponse update(String id,Integer type) {
        SaleDelivery saleDelivery=new SaleDelivery();
        saleDelivery.setDeliveryId(id);
        saleDelivery.setApprovalState(type);
        if(type==-3) {
            //恢复产品预计可用量
            List<SaleDeliveryDetails> deliveryDetails = sdds.queryById(id);
            for (SaleDeliveryDetails sdd : deliveryDetails) {
                bos.expectadd(sdd.getProductId(), sdd.getDepot(), sdd.getProductNum());
            }
            crs.deleteById(id);
        }
        return AjaxResponse.success(sds.update(saleDelivery).getDeliveryId());
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
        List<SaleDelivery> list=sds.conditionpage(order);
        for(int i=0;i<list.size();i++){
            list.get(i).setFounder(sus.queryById(Integer.valueOf(list.get(i).getFounder())).getUserName());
            if(list.get(i).getApprover()!=null) {
                list.get(i).setApprover(sus.queryById(Integer.valueOf(list.get(i).getApprover())).getUserName());
            }
            list.get(i).setSalesmen(sus.queryById(Integer.valueOf(list.get(i).getSalesmen())).getUserName());
        }
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    /**
     * 查询销可以退货的销售出库单
     * @return saleDeliveries数据
     */
    @RequestMapping("/findcanreturn")
    public AjaxResponse selectall(){
        List<SaleDelivery> saleDeliveries=sds.canreturn();
        return AjaxResponse.success(saleDeliveries);
    }
    /**
     * 修改销售出库单审批状态
     * @param orderid 主键
     * @return 数据
     */
    @GetMapping("/approval")
    public AjaxResponse approvalorder(String orderid,int type,String user,String approvalremarks){
        SaleDelivery saleorder=new SaleDelivery();
        saleorder.setDeliveryId(orderid);
        saleorder.setApprovalState(type);
        saleorder.setApprover(String.valueOf(sus.queryUserIdByUserName(user)));
        saleorder.setApprovalRemarks(approvalremarks);
        saleorder.setLastApprovalTime(new Date());
        saleorder.setUpdateTime(new Date());
        //订单驳回修改预计库存
        if(type == -1){
            saleorder.setOrderState(-1);
            saleorder.setUpdateTime(new Date());
            List<SaleDeliveryDetails> deliveryDetails=sdds.queryById(orderid);
            for(SaleDeliveryDetails sdd:deliveryDetails){
                bos.expectadd(sdd.getProductId(),sdd.getDepot(),sdd.getProductNum());
            }
        }
        if(type == 1){
            saleorder.setDeliveryState(1);
        }
        SaleDelivery saleDelivery=sds.update(saleorder);
        //审批通过产品出库减去当前库存数量
        if(type == 1) {
            List<SaleDeliveryDetails> deliveryDetails=sdds.queryById(orderid);
            for(SaleDeliveryDetails sdd:deliveryDetails){
                bos.productereduce(sdd.getProductId(),sdd.getDepot(),sdd.getProductNum());
            }
            //新增应收单据
            CapitalReceivable receivable=new CapitalReceivable();
            receivable.setDeliveryId(saleDelivery.getDeliveryId());
            receivable.setDeliveryTime(saleDelivery.getDeliveryTime());
            receivable.setCustomer(saleDelivery.getCustomer());
            receivable.setSalesmen(saleDelivery.getSalesmen());
            receivable.setReceivables(saleDelivery.getReceivables());
            receivable.setReceived(0.00);
            receivable.setUncollected(saleDelivery.getReceivables());
            receivable.setRemarks(saleDelivery.getRemarks());
            receivable.setFounder(saleDelivery.getFounder());
            receivable.setCaseState(0);
            crs.insert(receivable);
        }
        //如果绑定了订单就修改订单为已出库
        if (type == 1 && saleDelivery.getOrderId()!=null){
            SaleOrder order=new SaleOrder();
            order.setOrderId(saleDelivery.getOrderId());
            order.setUpdateTime(new Date());
            order.setDeliveryState(1);
            order.setOrderState(1);
            sos.update(order);
        }
        return AjaxResponse.success(saleDelivery);
    }
}
