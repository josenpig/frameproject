package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.BaseDepotService;
import com.xingji.frameproject.service.BaseProductService;
import com.xingji.frameproject.service.StockInventoryService;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.InventoryProjectVo;
import com.xingji.frameproject.vo.PurchaseProductVo;
import com.xingji.frameproject.vo.form.StockInventoryQueryForm;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (StockInventory)表控制层
 *
 * @author makejava
 * @since 2021-06-08 21:08:23
 */
@RestController
public class StockInventoryController {
    /**
     * 服务对象
     */
    @Resource
    private StockInventoryService stockInventoryService;
    @Resource
    private BaseDepotService depotService;
    @Resource
    private BaseProductService productService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/stockInventory/one")
    public StockInventory selectOne(String id) {
        return this.stockInventoryService.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @param stockInventoryQueryForm 实例对象
     * @return 实例对象
     */
    @GetMapping("/stockInventory")
    public PageInfo<StockInventory> queryAll(StockInventoryQueryForm stockInventoryQueryForm) {
        return this.stockInventoryService.queryAll(stockInventoryQueryForm);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param stockInventoryQueryForm
     * @return 对象列表
     */
    @GetMapping("/stockInventory/search")
    public PageInfo<StockInventory> queryBySearch(StockInventoryQueryForm stockInventoryQueryForm) {
        return this.stockInventoryService.queryBySearch(stockInventoryQueryForm);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param stockInventoryQueryForm
     * @return 对象列表
     */
    @GetMapping("/stockInventory/screen")
    public PageInfo<StockInventory> queryByScreen(StockInventoryQueryForm stockInventoryQueryForm) {
        return this.stockInventoryService.queryByScreen(stockInventoryQueryForm);
    }

    /**
     * 新增数据
     *
     * @param stockInventory 实例对象
     * @return 实例对象
     */
    @PostMapping("/stockInventory")
    public StockInventory insert(@RequestBody StockInventory stockInventory) {
        return this.stockInventoryService.insert(stockInventory);
    }

    /**
     * 批量新增数据
     *
     * @param StockInventoryList 实例对象列表
     * @return 影响行数
     */
    @PostMapping("/stockInventory/batch")
    public boolean insertBatch(@RequestBody List<StockInventory> StockInventoryList) {
        return this.stockInventoryService.insertBatch(StockInventoryList);
    }

    /**
     * 修改数据
     *
     * @param stockInventory 实例对象
     * @return 实例对象
     */
    @PutMapping("/stockInventory")
    public StockInventory update(@RequestBody StockInventory stockInventory) {
        return this.stockInventoryService.update(stockInventory);
    }

    /**
     * 批量修改数据
     *
     * @param stockInventoryList 实例对象列表
     * @return 影响行数
     */
    @PutMapping("/stockInventory/batch")
    public boolean updateBatch(@RequestBody List<StockInventory> stockInventoryList) {
        return this.stockInventoryService.updateBatch(stockInventoryList);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/stockInventory")
    public boolean deleteById(String id) {
        return this.stockInventoryService.deleteById(id);
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @DeleteMapping("/stockInventory/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return this.stockInventoryService.deleteBatch(ids);
    }

    /**
     * 查询所有的仓库表
     * @return
     */
    @GetMapping("/stockInventory/allDepot")
    public AjaxResponse selectAllDepot(){
        Map<String,Object> map=new HashMap<>();
        List<BaseDepot> depots = depotService.findAll();
        map.put("depots",depots);
        return AjaxResponse.success(map);
    }


    /**
     * 查询所有库存盘点的产品
     * @return 产品集合
     */
    @GetMapping("/stockInventory/allProduct/{depotName}")
    public AjaxResponse findAllPurchaseProduct(Integer currentPage, Integer pageSize,@PathVariable("depotName") String depotName){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<InventoryProjectVo> inventoryProjectVos=productService.allStockInventoryProduct(depotName);
        for(InventoryProjectVo vo:inventoryProjectVos){
            vo.setPdNum(0);
            vo.setPdyk(vo.getPdNum()-vo.getSystemNum());
        }
        map.put("total",page.getTotal());
        map.put("rows",inventoryProjectVos);
        return AjaxResponse.success(map);
    };



//    /**
//     * 新增销售订单
//     * @param add 单据信息
//     * @param type 是否为草稿
//     * @return 订单id
//     */
//    @RequestMapping("/stockInventory/add/{type}")
//    public AjaxResponse add(@PathVariable("type") int type,@RequestBody String add){
//        JSONObject jsonObject = JSONObject.parseObject(add);
//        String one = jsonObject.getString("order");
//        StockInventory order = JSON.parseObject(one, StockInventory.class);
//        String two = jsonObject.getString("orderdetails");
//        List<StockInventoryDetails> orderdetails= JSONArray.parseArray(two, StockInventoryDetails.class);
//        order.setInventorystate(type);
//        order.setOrderState(0);
//        order.setDeliveryState(0);
//        order.setAdvance(0.00);
//        //添加销售订单单信息
//        for(int i=0;i<orderdetails.size();i++){
//            orderdetails.get(i).setOrderId(order.getOrderId());
//        }
//        sos.insert(order);
//        sods.insertBatch(orderdetails);
//        //订单生成减去预计库存数量
//        if(type == 0) {
//            List<SaleOrderDetails> orderDetails=sods.queryById(order.getOrderId());
//            for(SaleOrderDetails sod:orderDetails){
//                bos.expectreduce(sod.getProductId(),sod.getDepot(),sod.getProductNum());
//            }
//        }
//        return AjaxResponse.success(order.getOrderId());
//    }

}