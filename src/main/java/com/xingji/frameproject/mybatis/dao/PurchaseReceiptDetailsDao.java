package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.PurchaseReceiptDetails;
import com.xingji.frameproject.mybatis.entity.SaleDeliveryDetails;
import com.xingji.frameproject.vo.form.PurchaseReceiptDetailsQueryForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PurchaseReceiptDetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-16 23:42:52
 */
@Mapper
public interface PurchaseReceiptDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseReceiptDetails queryById(Integer id);

    /**
     * 查询所有数据
     *
     * @param purchaseReceiptDetailsQueryForm 实例对象
     * @return 实例对象
     */
    List<PurchaseReceiptDetails> queryAll(PurchaseReceiptDetailsQueryForm purchaseReceiptDetailsQueryForm);

    /**
     * 通过实体作为或者条件查询
     *
     * @param purchaseReceiptDetailsQueryForm 实例对象
     * @return 对象列表
     */
    List<PurchaseReceiptDetails> queryOrByPojo(PurchaseReceiptDetailsQueryForm purchaseReceiptDetailsQueryForm);

    /**
     * 通过实体作为并且条件查询
     *
     * @param purchaseReceiptDetailsQueryForm 实例对象
     * @return 对象列表
     */
    List<PurchaseReceiptDetails> queryAndByPojo(PurchaseReceiptDetailsQueryForm purchaseReceiptDetailsQueryForm);

    /**
     * 新增数据
     *
     * @param purchaseReceiptDetails 实例对象
     * @return 影响行数
     */
    int insert(PurchaseReceiptDetails purchaseReceiptDetails);

    /**
     * 批量新增数据
     *
     * @param purchaseReceiptDetailsList 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PurchaseReceiptDetails> purchaseReceiptDetailsList);

    /**
     * 修改数据
     *
     * @param purchaseReceiptDetails 实例对象
     * @return 影响行数
     */
    int update(PurchaseReceiptDetails purchaseReceiptDetails);

    /**
     * 批量修改数据
     *
     * @param purchaseReceiptDetailsList 实例对象列表
     * @return 影响行数
     */
    int updateBatch(List<PurchaseReceiptDetails> purchaseReceiptDetailsList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 影响行数
     */
    int deleteBatch(List<Integer> ids);

    /**
     * 批量对象列表删除数据
     *
     * @param purchaseReceiptDetailsList 实例对象列表
     * @return 影响行数
     */
    int deleteBatchByEntities(List<PurchaseReceiptDetails> purchaseReceiptDetailsList);

    /**
     * 根据采购入库单查询采购入库单商品详情
     * @param id
     * @return
     */
    List<PurchaseReceiptDetails> queryAllByOrderId(String id);
}

