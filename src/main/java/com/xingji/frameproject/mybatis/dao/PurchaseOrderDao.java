package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.PurchaseOrder;
import com.xingji.frameproject.vo.PurchaseCapitalVo;
import com.xingji.frameproject.vo.form.PurchaseOrderQueryForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (PurchaseOrder)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-02 15:24:43
 */
@Mapper
public interface PurchaseOrderDao {

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
    List<PurchaseOrder> queryAll(PurchaseOrderQueryForm purchaseOrderQueryForm);

    /**
     * 通过实体作为或者条件查询
     *
     * @param purchaseOrderQueryForm 实例对象
     * @return 对象列表
     */
    List<PurchaseOrder> queryOrByPojo(PurchaseOrderQueryForm purchaseOrderQueryForm);

    /**
     * 通过实体作为并且条件查询
     *
     * @param purchaseOrderQueryForm 实例对象
     * @return 对象列表
     */
    List<PurchaseOrder> queryAndByPojo(PurchaseOrderQueryForm purchaseOrderQueryForm);

    /**
     * 新增数据
     *
     * @param purchaseOrder 实例对象
     * @return 影响行数
     */
    int insert(PurchaseOrder purchaseOrder);

    /**
     * 批量新增数据
     *
     * @param purchaseOrderList 实例对象列表
     * @return 影响行数
     */
    int insertBatch(List<PurchaseOrder> purchaseOrderList);

    /**
     * 修改数据
     *
     * @param purchaseOrder 实例对象
     * @return 影响行数
     */
    int update(PurchaseOrder purchaseOrder);



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 查询有多少条数据
     * @return
     */
    int count();

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
    List <PurchaseCapitalVo> queryPayment(PurchaseCapitalVo vo);
    /**
     * 修改订单已付款数据
     *
     * @param purchaseOrder 实例对象
     * @return 实例对象
     */
    boolean ostateadd(PurchaseOrder purchaseOrder);


}