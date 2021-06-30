package com.xingji.frameproject.service;

import com.github.pagehelper.PageInfo;
import com.xingji.frameproject.mybatis.entity.PurchaseOrder;
import com.xingji.frameproject.vo.PurchaseCapitalVo;
import com.xingji.frameproject.vo.form.PurchaseOrderQueryForm;

import java.util.List;

/**
 * (PurchaseOrder)表服务接口
 *
 * @author makejava
 * @since 2021-06-02 15:24:43
 */
public interface PurchaseOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseOrder queryById(String id);

    /**
     * 查询所有数据
     *
     * @param purchaseOrderQueryForm 实例对象
     * @return 实例对象
     */
    PageInfo<PurchaseOrder> queryAll(PurchaseOrderQueryForm purchaseOrderQueryForm);

    /**
     * 通过实体类查询相关数据
     */
    List<PurchaseOrder> queryOfPurchaseOrder(PurchaseOrder purchaseOrder);

    /**
     * 根据查询条件搜索数据
     *
     * @param purchaseOrderQueryForm
     * @return 对象列表
     */
    PageInfo<PurchaseOrder> queryBySearch(PurchaseOrderQueryForm purchaseOrderQueryForm);

    /**
     * 根据查询条件筛选数据
     *
     * @param purchaseOrderQueryForm
     * @return 对象列表
     */
    PageInfo<PurchaseOrder> queryByScreen(PurchaseOrderQueryForm purchaseOrderQueryForm);

    /**
     * 新增数据
     *
     * @param purchaseOrder 实例对象
     * @return 实例对象
     */
    PurchaseOrder insert(PurchaseOrder purchaseOrder);

    /**
     * 批量新增数据
     *
     * @param PurchaseOrderList 实例对象列表
     * @return 影响行数
     */
    boolean insertBatch(List<PurchaseOrder> PurchaseOrderList);

    /**
     * 修改数据
     *
     * @param purchaseOrder 实例对象
     * @return 实例对象
     */
    PurchaseOrder update(PurchaseOrder purchaseOrder);



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);


    /**
     * 查询所有的采购订单
     * @return
     */
    List<PurchaseOrder> queryAllByPage(PurchaseOrderQueryForm queryForm);
    /**
     * 通过订单id查询本次付款单信息
     * @param purchaseId 采购单id
     * @return 对象列表
     */
    PurchaseCapitalVo querythisPayment(String purchaseId);
    /**
     * 通过实体类查询所有可付款单
     * @param vo 实体类
     * @return 对象列表
     */
    List<PurchaseCapitalVo> queryPayment(PurchaseCapitalVo vo);

    boolean ostateadd(PurchaseOrder purchaseOrder);
}