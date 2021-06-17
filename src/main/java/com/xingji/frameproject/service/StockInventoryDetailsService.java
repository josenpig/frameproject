package com.xingji.frameproject.service;

import com.github.pagehelper.PageInfo;
import com.xingji.frameproject.mybatis.entity.StockInventoryDetails;
import com.xingji.frameproject.vo.form.StockInventoryDetailsQueryForm;

import java.util.List;

/**
 * (StockInventoryDetails)表服务接口
 *
 * @author makejava
 * @since 2021-06-10 19:09:13
 */
public interface StockInventoryDetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockInventoryDetails queryById(Integer id);

    /**
     * 查询所有数据
     *
     * @param stockInventoryDetailsQueryForm 实例对象
     * @return 实例对象
     */
    PageInfo<StockInventoryDetails> queryAll(StockInventoryDetailsQueryForm stockInventoryDetailsQueryForm);

    /**
     * 根据查询条件搜索数据
     *
     * @param stockInventoryDetailsQueryForm
     * @return 对象列表
     */
    PageInfo<StockInventoryDetails> queryBySearch(StockInventoryDetailsQueryForm stockInventoryDetailsQueryForm);

    /**
     * 根据查询条件筛选数据
     *
     * @param stockInventoryDetailsQueryForm
     * @return 对象列表
     */
    PageInfo<StockInventoryDetails> queryByScreen(StockInventoryDetailsQueryForm stockInventoryDetailsQueryForm);

    /**
     * 新增数据
     *
     * @param stockInventoryDetails 实例对象
     * @return 实例对象
     */
    StockInventoryDetails insert(StockInventoryDetails stockInventoryDetails);

    /**
     * 批量新增数据
     *
     * @param StockInventoryDetailsList 实例对象列表
     * @return 影响行数
     */
    boolean insertBatch(List<StockInventoryDetails> StockInventoryDetailsList);

    /**
     * 修改数据
     *
     * @param stockInventoryDetails 实例对象
     * @return 实例对象
     */
    StockInventoryDetails update(StockInventoryDetails stockInventoryDetails);

    /**
     * 批量修改数据
     *
     * @param stockInventoryDetailsList 实例对象列表
     * @return 影响行数
     */
    boolean updateBatch(List<StockInventoryDetails> stockInventoryDetailsList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    boolean deleteBatch(List<Integer> ids);

    /**
     * 根据库存盘点的订单编号查询所有的订单详情记录
     * @param orderId
     * @return
     */
    List<StockInventoryDetails> queryAllById(String orderId);

    /**
     * 通过实体作为并且条件查询
     *
     * @param stockInventoryDetailsQueryForm 实例对象
     * @return 对象列表
     */
    List<StockInventoryDetails> queryAndByPojo(StockInventoryDetailsQueryForm stockInventoryDetailsQueryForm);

}