package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.PurchaseOrderDetails;
import com.xingji.frameproject.vo.form.PurchaseOrderDetailsQueryForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PurchaseOrderDetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-02 09:52:31
 */
@Mapper
public interface PurchaseOrderDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseOrderDetails queryById(Integer id);

    /**
     * 通过采购订单进行查询订单详情
     *
     * @param orderid 订单id
     * @return 实例对象
     */
    List<PurchaseOrderDetails> queryAllByOrderId(String orderid);

    /**
     * 查询所有数据
     *
     * @param purchaseOrderDetailsQueryForm 实例对象
     * @return 实例对象
     */
    List<PurchaseOrderDetails> queryAll(PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm);

    /**
     * 通过实体作为或者条件查询
     *
     * @param purchaseOrderDetailsQueryForm 实例对象
     * @return 对象列表
     */
    List<PurchaseOrderDetails> queryOrByPojo(PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm);

    /**
     * 通过实体作为并且条件查询
     *
     * @param purchaseOrderDetailsQueryForm 实例对象
     * @return 对象列表
     */
    List<PurchaseOrderDetails> queryAndByPojo(PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm);

    /**
     * 新增数据
     *
     * @param purchaseOrderDetails 实例对象
     * @return 影响行数
     */
    int insert(PurchaseOrderDetails purchaseOrderDetails);

    /**
     * 批量新增数据
     *
     * @param purchaseOrderDetailsList 实例对象列表
     * @return 影响行数
     */
    int batchInsert(@Param("entities") List<PurchaseOrderDetails> purchaseOrderDetailsList);

    /**
     * 修改数据
     *
     * @param purchaseOrderDetails 实例对象
     * @return 影响行数
     */
    int update(PurchaseOrderDetails purchaseOrderDetails);



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询有多少条数据
     * @return
     */
    int count();
}