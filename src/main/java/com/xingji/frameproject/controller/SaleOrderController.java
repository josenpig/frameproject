package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.*;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.*;

/**
 * (SaleOrder)表控制层
 *
 * @author makejava
 * @since 2021-05-20 19:10:22
 */
@Slf4j
@RestController
@EnableSwagger2
@Api(description = "销售订单Api")
@RequestMapping("/saleorder")
public class SaleOrderController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private SaleOrderService sos;
    @Resource
    private SysUserService sus;
    @Resource
    private SaleDeliveryService sds;
    @Resource
    private SaleReturnService srs;
    @Resource
    private SaleOrderDetailsService sods;
    @Resource
    private BaseOpeningService bos;
    @Resource
    private SaleDeliveryDetailsService sdds;
    @Resource
    private SaleReturnDetailsService srds;
    @Resource
    private CapitalReceiptBillService srbs;
    @Resource
    private BaseProductService baseProductService;
    @Resource
    private BaseOpeningService baseOpeningService;
    /**
     * 通过主键查询销售订单及销售订单详情
     * @param id 主键
     * @return 数据
     */
    @GetMapping("/find/{id}")
    public AjaxResponse selectOne(@PathVariable("id") String id) {
        SaleOrder order=sos.queryById(id);
        List<SaleOrderDetails> orderDetails=sods.queryById(id);
        SaleOrderVo vo=new SaleOrderVo();
        order.setFounder(sus.queryById(Integer.valueOf(order.getFounder())).getUserName());
        if(order.getApprover()!=null) {
            order.setApprover(sus.queryById(Integer.valueOf(order.getApprover())).getUserName());
        }
        order.setSalesmen(sus.queryById(Integer.valueOf(order.getSalesmen())).getUserName());
        //查询订单是否为草稿
        if(order.getApprover()==null){
        List<SaleProductVo> SaleProductVo=baseProductService.allsaleproduct();
        for(SaleProductVo product:SaleProductVo){
            product.setBaseOpenings(baseOpeningService.finddepot(product.getProductId()));
        }
            vo.setSaleProductVos(SaleProductVo);
        }
        //查询关联单据
        List<CapitalReceiptBill> bills=srbs.relation(id);
        order.setReceipts(bills);
        vo.setOrder(order);
        vo.setOrderdetails(orderDetails);
        return AjaxResponse.success(vo);
    }
    /**
     * 新增销售订单
     * @param add 单据信息
     * @param type 是否为草稿
     * @return 订单id
     */
    @RequestMapping("/add/{type}")
    public AjaxResponse add(@PathVariable("type") int type,@RequestBody String add){
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("order");
        SaleOrder order =JSON.parseObject(one, SaleOrder.class);
        String two = jsonObject.getString("orderdetails");
        List<SaleOrderDetails> orderdetails=JSONArray.parseArray(two, SaleOrderDetails.class);
        order.setFoundTime(new Date());
        //判断该订单是否为编辑单
        if(order.getApprovalState()!=null){
            //为编辑单时修改产品预计可用量
            List<SaleOrderDetails> orderDetails=sods.queryById(order.getOrderId());
            for(SaleOrderDetails sod:orderDetails){
                bos.expectadd(sod.getProductId(),sod.getDepot(),sod.getProductNum());
            }
            sods.deleteById(order.getOrderId());
            sos.deleteById(order.getOrderId());
            order.setUpdateTime(new Date());
        }
        //添加订单信息
        order.setFounder(String.valueOf(sus.queryUserIdByUserName(order.getFounder())));
        order.setApprovalState(type);
        order.setOrderState(0);
        order.setDeliveryState(0);
        order.setAdvance(0.00);
        //添加销售订单单信息
        for(int i=0;i<orderdetails.size();i++){
            orderdetails.get(i).setOrderId(order.getOrderId());
        }
        sos.insert(order);
        sods.insertBatch(orderdetails);
        //订单生成减去预计库存数量
        if(type == 0) {
            List<SaleOrderDetails> orderDetails=sods.queryById(order.getOrderId());
            for(SaleOrderDetails sod:orderDetails){
                bos.expectreduce(sod.getProductId(),sod.getDepot(),sod.getProductNum());
            }
        }
        return AjaxResponse.success(order.getOrderId());
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
        List<SaleOrder> list=sos.conditionpage(order);
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
    /**
     * 修改销售订单审批状态
     * @param orderid 主键
     * @return 数据
     */
    @GetMapping("/approval")
    public AjaxResponse approvalorder(String orderid,int type,String user,String approvalremarks){
        SaleOrder order=new SaleOrder();
        order.setOrderId(orderid);
        order.setApprovalState(type);
        order.setApprover(String.valueOf(sus.queryUserIdByUserName(user)));
        order.setApprovalRemarks(approvalremarks);
        order.setLastApprovalTime(new Date());
        order.setUpdateTime(new Date());
        //订单驳回修改库存
        if(type == -1){
            order.setOrderState(-1);
            List<SaleOrderDetails> orderDetails=sods.queryById(order.getOrderId());
            for(SaleOrderDetails sod:orderDetails){
                bos.expectadd(sod.getProductId(),sod.getDepot(),sod.getProductNum());
            }
        }
        SaleOrder saleOrder=sos.update(order);
        return AjaxResponse.success(saleOrder);
    }
    /**
     * 查询销售订单出库状态
     * @param orderid 主键
     * @return vos数据
     */
    @GetMapping("/status/{orderid}")
    public AjaxResponse status(@PathVariable("orderid") String orderid){
        SaleOrder sale=sos.queryById(orderid);
        List<SaleOrderDetails> orders=sods.queryById(orderid);
        SaleDelivery delivery=sds.queryById(sale.getDeliveryId());
        SaleReturn saleReturn=srs.queryByIdVo(sale.getReturnId());
        List<DeliveryStatusVo> vos=new ArrayList<DeliveryStatusVo>();
        for (int i=0;i<orders.size();i++){
            DeliveryStatusVo vo=new DeliveryStatusVo();
            vo.setPid(orders.get(i).getProductId());
            vo.setPname(orders.get(i).getProductName());
            vo.setPnum(orders.get(i).getProductNum());
            if(delivery!=null){
                List<SaleDeliveryDetails> deliverys = sdds.queryById(sale.getDeliveryId());
                if(delivery.getApprovalState()==1) {
                    vo.setOkdnum(deliverys.get(i).getProductNum());
                    vo.setNodnum(0);
                }else if(delivery.getApprovalState()==0){
                    vo.setOkdnum(0);
                    vo.setNodnum(deliverys.get(i).getProductNum());
                }
            }
            if (saleReturn!=null) {
                if(saleReturn.getApprovalState()==1) {
                    List<SaleReturnDetails> returns = srds.queryById(sale.getReturnId());
                        try {
                            vo.setOkrnum(returns.get(i).getReturnNum());
                        }catch (Exception e){
                            vo.setNodnum(0);
                        }
                }
            }
            vos.add(vo);
        }
        return AjaxResponse.success(vos);
    }
}
