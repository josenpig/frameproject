package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.PurchaseReceipt;
import com.xingji.frameproject.mybatis.entity.PurchaseReturns;
import com.xingji.frameproject.vo.form.PurchaseReceiptQueryForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PurchaseReceipt)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-16 10:15:41
 */
@Mapper
public interface PurchaseReceiptDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseReceipt queryById(String id);

    /**
     * 查询所有数据
     *
     * @param purchaseReceiptQueryForm 实例对象
     * @return 实例对象
     */
    List<PurchaseReceipt> queryAll(PurchaseReceiptQueryForm purchaseReceiptQueryForm);

    /**
     * 通过实体作为或者条件查询
     *
     * @param purchaseReceiptQueryForm 实例对象
     * @return 对象列表
     */
    List<PurchaseReceipt> queryOrByPojo(PurchaseReceiptQueryForm purchaseReceiptQueryForm);

    /**
     * 通过实体作为并且条件查询
     *
     * @param purchaseReceiptQueryForm 实例对象
     * @return 对象列表
     */
    List<PurchaseReceipt> queryAndByPojo(PurchaseReceiptQueryForm purchaseReceiptQueryForm);

    /**
     * 新增数据
     *
     * @param purchaseReceipt 实例对象
     * @return 影响行数
     */
    int insert(PurchaseReceipt purchaseReceipt);

    /**
     * 批量新增数据
     *
     * @param purchaseReceiptList 实例对象列表
     * @return 影响行数
     */
    int insertBatch(List<PurchaseReceipt> purchaseReceiptList);

    /**
     * 修改数据
     *
     * @param purchaseReceipt 实例对象
     * @return 影响行数
     */
    int update(PurchaseReceipt purchaseReceipt);



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 查询有多少条采购订单入库记录
     * @return
     */
    int count();


    List<PurchaseReceipt> queryAllByVettingState();
}

