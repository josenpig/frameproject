package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.InventoryDetailsVo;
import com.xingji.frameproject.vo.StockTransferDetailsVo;
import com.xingji.frameproject.vo.form.StockTransferQueryForm;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.List;

/**
 * (StockTransfer)表控制层
 *
 * @author hdr666
 * @since 2021-06-22 14:17:27
 */
@Slf4j
@RestController
@EnableSwagger2
@Api(description = "调拨单Api")
public class StockTransferController {
    /**
     * 服务对象
     */
    @Resource
    private StockTransferService stockTransferService;
    @Resource
    private BaseDepotService depotService;
    @Resource
    private StockTransferDetailsService detailsService;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private BaseOpeningService openingService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/stockTransfer/one")
    public StockTransfer selectOne(String id) {
        return this.stockTransferService.queryById(id);
    }



    /**
     * 批量新增数据
     *
     * @param StockTransferList 实例对象列表
     * @return 影响行数
     */
    @PostMapping("/stockTransfer/batch")
    public boolean insertBatch(@RequestBody List<StockTransfer> StockTransferList) {
        return this.stockTransferService.insertBatch(StockTransferList);
    }

    /**
     * 修改数据
     *
     * @param stockTransfer 实例对象
     * @return 实例对象
     */
    @PutMapping("/stockTransfer")
    public StockTransfer update(@RequestBody StockTransfer stockTransfer) {
        return this.stockTransferService.update(stockTransfer);
    }

    /**
     * 批量修改数据
     *
     * @param stockTransferList 实例对象列表
     * @return 影响行数
     */
    @PutMapping("/stockTransfer/batch")
    public boolean updateBatch(@RequestBody List<StockTransfer> stockTransferList) {
        return this.stockTransferService.updateBatch(stockTransferList);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/stockTransfer")
    public boolean deleteById(String id) {
        return this.stockTransferService.deleteById(id);
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @DeleteMapping("/stockTransfer/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return this.stockTransferService.deleteBatch(ids);
    }

    /**
     * 查询所有的仓库
     * @return
     */
    @GetMapping("/stockTransfer/selectAllDepot")
    public AjaxResponse selectAllDepot(){
        List<BaseDepot> list =depotService.findAll();
        return AjaxResponse.success(list);
    }

    /**
     * 新增调拨单
     * @param add 单据信息
     * @param type 是否为草稿
     * @return 订单id
     */
    @RequestMapping("/stockTransfer/add/{type}")
    public AjaxResponse add(@PathVariable("type") int type,@RequestBody String add){
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("order");
        StockTransfer order = JSON.parseObject(one, StockTransfer.class);
        String two = jsonObject.getString("orderdetails");
        List<StockTransferDetails> orderdetails= JSONArray.parseArray(two, StockTransferDetails.class);
        order.setState(type);
        order.setCreatePeople(String.valueOf(sysUserService.queryUserIdByUserName(order.getCreatePeople())));
        order.setUpdatePeople(order.getCreatePeople());
        order.setUpdateDate(order.getDocumentDate());
        //添加销售订单单信息
        for(int i=0;i<orderdetails.size();i++){
            orderdetails.get(i).setTransferId(order.getId());
        }
        stockTransferService.insert(order);
        detailsService.insertBatch(orderdetails);
        return AjaxResponse.success(order.getId());
    }

    /**
     * 根据调拨单编号查找该的调拨单详细信息
     * @param orderId
     * @return
     */
    @GetMapping("/stockTransfer/find/{id}")
    public AjaxResponse selectOrder(@PathVariable("id")String orderId){
        StockTransferDetailsVo DetailsVo = new StockTransferDetailsVo();
        StockTransfer Stocktransfer = stockTransferService.queryById(orderId);
        List<StockTransferDetails> list = detailsService.queryAllById(orderId);
        Stocktransfer.setCreatePeople(sysUserService.queryUserNameByUserId(Integer.valueOf(Stocktransfer.getCreatePeople())));
        Stocktransfer.setUpdatePeople(sysUserService.queryUserNameByUserId(Integer.valueOf(Stocktransfer.getUpdatePeople())));
        DetailsVo.setStockTransfer(Stocktransfer);
        DetailsVo.setList(list);
        return AjaxResponse.success(DetailsVo);
    }

    /**
     * 修改调拨单审批状态
     * @param id 主键
     * @return 数据
     */
    @GetMapping("/stockTransfer/approval")
    public AjaxResponse approvalorder(String id,int type,String user){
        StockTransfer order = new StockTransfer();
        order.setId(id);
        order.setState(type);
        order.setVettingName(String.valueOf(sysUserService.queryUserIdByUserName(user)));
        order.setUpdateDate(new Date());
        order.setVettingDate(new Date());
        StockTransfer Order=stockTransferService.update(order);
        System.out.println(Order);
        if(type==1){//审核通过添加库存和预计库存
            List<StockTransferDetails> list = detailsService.queryAllById(id);
            List<BaseOpening> openings = openingService.queryAll(new BaseOpening());
            for (StockTransferDetails std:list){
                boolean flag=true;
                for (BaseOpening opening:openings){
                    if(Order.getInwarehouse()==opening.getDepotName() && std.getProductId()==opening.getProductId()){
                        openingService.expectadd(std.getProductId(),order.getInwarehouse(),std.getProductNum());
                        openingService.producteadd(std.getProductId(),order.getInwarehouse(),std.getProductNum());
                        flag=false;
                    }
                }
                if (flag){
                    System.out.println(Order);
                    BaseOpening baseOpening = new BaseOpening();
                    baseOpening.setDepotName(Order.getInwarehouse());
                    baseOpening.setOpeningNumber(std.getProductNum());
                    baseOpening.setProductId(std.getProductId());
                    baseOpening.setExpectNumber(std.getProductNum());
                    baseOpening.setProductNumber(std.getProductNum());
                    System.out.println(baseOpening);
                    openingService.insert(baseOpening);
                }
            }
        }
        return AjaxResponse.success(Order);
    }
}