package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingji.frameproject.mybatis.entity.PurchaseOrder;
import com.xingji.frameproject.mybatis.entity.PurchaseOrderDetails;
import com.xingji.frameproject.mybatis.entity.SaleOrder;
import com.xingji.frameproject.mybatis.entity.SaleOrderDetails;
import com.xingji.frameproject.service.BaseOpeningService;
import com.xingji.frameproject.service.PurchaseOrderDetailsService;
import com.xingji.frameproject.service.PurchaseOrderService;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.PurchaseOrderVo;
import com.xingji.frameproject.vo.SaleOrderVo;
import com.xingji.frameproject.vo.form.PurchaseOrderQueryForm;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (PurchaseOrder)表控制层
 *
 * @author 宇义
 * @since 2021-06-02 09:04:25
 */
@Slf4j
@RestController
@EnableSwagger2
@Api(description = "采购订单Api")
public class PurchaseOrderController {
    /**
     * 服务对象
     */
    @Resource
    private PurchaseOrderService purchaseOrderService;
    @Resource
    private PurchaseOrderDetailsService prds;
    @Resource
    private BaseOpeningService bos;



    /**
     * 查询所有数据
     *
     * @param purchaseOrderQueryForm 实例对象
     * @return 实例对象
     */
    @GetMapping("/purchaseOrder")
    public PageInfo<PurchaseOrder> queryAll(PurchaseOrderQueryForm purchaseOrderQueryForm) {
        return this.purchaseOrderService.queryAll(purchaseOrderQueryForm);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param purchaseOrderQueryForm
     * @return 对象列表
     */
    @GetMapping("/purchaseOrder/search")
    public PageInfo<PurchaseOrder> queryBySearch(PurchaseOrderQueryForm purchaseOrderQueryForm) {
        return this.purchaseOrderService.queryBySearch(purchaseOrderQueryForm);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param purchaseOrderQueryForm
     * @return 对象列表
     */
    @GetMapping("/purchaseOrder/screen")
    public PageInfo<PurchaseOrder> queryByScreen(PurchaseOrderQueryForm purchaseOrderQueryForm) {
        return this.purchaseOrderService.queryByScreen(purchaseOrderQueryForm);
    }

    /**
     * 根据条件进行采购订单的查询
     * @param find
     * @return
     */
    @RequestMapping("/purchaseOrder/findpage")
    public AjaxResponse selectAllByPage(@RequestBody String find){
        JSONObject jsonObject = JSONObject.parseObject(find);
        String one = jsonObject.getString("currentPage");
        Integer currentPage = JSON.parseObject(one, Integer.class);
        String two = jsonObject.getString("pageSize");
        Integer pageSize = JSON.parseObject(one, Integer.class);
        String three = jsonObject.getString("condition");
        System.out.println(three);
        PurchaseOrderQueryForm queryForm = JSON.parseObject(three,PurchaseOrderQueryForm.class);
        queryForm.setPageNum(currentPage);
        queryForm.setPageSize(5);
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,5);
        List<PurchaseOrder> list=purchaseOrderService.queryAllByPage(queryForm);
        map.put("total",page.getTotal());
        map.put("rows",list);
        System.out.println(page);
        System.out.println(map.toString());
        return AjaxResponse.success(map);
    }

    /**
     * 新增采购订单数据
     * @param type
     * @param add
     * @return
     */
    @RequestMapping("/purchaseOrder/add/{type}")
    public AjaxResponse insert(@PathVariable("type") int type,@RequestBody String add) {
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("order");
        PurchaseOrder order = JSON.parseObject(one, PurchaseOrder.class);
        String two = jsonObject.getString("orderdetails");
        List<PurchaseOrderDetails> orderdetails= JSONArray.parseArray(two, PurchaseOrderDetails.class);
        order.setCreateDate(new Date());
        order.setUpdateDate(new Date());
        order.setVettingState(type);
        order.setOrderState(0);
        order.setInboundState(0);
        order.setOstate(00.00);
        //添加采购订单单信息
        for(int i=0;i<orderdetails.size();i++){
            orderdetails.get(i).setPurchaseOrderId(order.getId());
        }
        purchaseOrderService.insert(order);
        prds.insertBatch(orderdetails);
        return AjaxResponse.success(order.getId());


    }

    /**
     * 批量新增数据
     *
     * @param PurchaseOrderList 实例对象列表
     * @return 影响行数
     */
    @PostMapping("/purchaseOrder/batch")
    public boolean insertBatch(@RequestBody List<PurchaseOrder> PurchaseOrderList) {
        return this.purchaseOrderService.insertBatch(PurchaseOrderList);
    }

    /**
     * 修改数据
     *
     * @param purchaseOrder 实例对象
     * @return 实例对象
     */
    @PutMapping("/purchaseOrder")
    public PurchaseOrder update(@RequestBody PurchaseOrder purchaseOrder) {
        return this.purchaseOrderService.update(purchaseOrder);
    }

    /**
     * 批量修改数据
     *
     * @param purchaseOrderList 实例对象列表
     * @return 影响行数
     */
    @PutMapping("/purchaseOrder/batch")
    public boolean updateBatch(@RequestBody List<PurchaseOrder> purchaseOrderList) {
        return this.purchaseOrderService.updateBatch(purchaseOrderList);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/purchaseOrder")
    public boolean deleteById(String id) {
        return this.purchaseOrderService.deleteById(id);
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @DeleteMapping("/purchaseOrder/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return this.purchaseOrderService.deleteBatch(ids);
    }


    /**
     * 通过主键查询数据
     *
     * @param id 主键
     * @return 数据
     */
    @GetMapping("/purchaseOrder/find/{id}")
    public AjaxResponse selectOne(@PathVariable("id") String id) {
        PurchaseOrder order=purchaseOrderService.queryById(id);
        List<PurchaseOrderDetails> orderDetails=prds.queryAllByOrderId(id);
        PurchaseOrderVo vo=new PurchaseOrderVo();
        vo.setPurchaseOrder(order);
        vo.setList(orderDetails);
        return AjaxResponse.success(vo);
    }

    /**
     * 采购单的审核，修改采购订单的状态
     *
     * @param id 主键
     * @return 数据
     */
    @GetMapping("/purchaseOrder/vetting")
    public AjaxResponse selectvetting(@PathVariable("id") String id) {
        PurchaseOrder order=purchaseOrderService.queryById(id);
        List<PurchaseOrderDetails> orderDetails=prds.queryAllByOrderId(id);
        PurchaseOrderVo vo=new PurchaseOrderVo();
        vo.setPurchaseOrder(order);
        vo.setList(orderDetails);
        return AjaxResponse.success(vo);
    }


}