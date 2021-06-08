package com.xingji.frameproject.service;

import com.github.pagehelper.PageInfo;
import com.xingji.frameproject.mybatis.entity.StockInventory;
import com.xingji.frameproject.vo.form.StockInventoryQueryForm;

import java.util.List;

/**
 * (StockInventory)表服务接口
 *
 * @author makejava
 * @since 2021-06-08 21:08:20
 */
public interface StockInventoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockInventory queryById(String id);

    /**
     * 查询所有数据
     *
     * @param stockInventoryQueryForm 实例对象
     * @return 实例对象
     */
    PageInfo<StockInventory> queryAll(StockInventoryQueryForm stockInventoryQueryForm);

    /**
     * 根据查询条件搜索数据
     *
     * @param stockInventoryQueryForm
     * @return 对象列表
     */
    PageInfo<StockInventory> queryBySearch(StockInventoryQueryForm stockInventoryQueryForm);

    /**
     * 根据查询条件筛选数据
     *
     * @param stockInventoryQueryForm
     * @return 对象列表
     */
    PageInfo<StockInventory> queryByScreen(StockInventoryQueryForm stockInventoryQueryForm);

    /**
     * 新增数据
     *
     * @param stockInventory 实例对象
     * @return 实例对象
     */
    StockInventory insert(StockInventory stockInventory);

    /**
     * 批量新增数据
     *
     * @param StockInventoryList 实例对象列表
     * @return 影响行数
     */
    boolean insertBatch(List<StockInventory> StockInventoryList);

    /**
     * 修改数据
     *
     * @param stockInventory 实例对象
     * @return 实例对象
     */
    StockInventory update(StockInventory stockInventory);

    /**
     * 批量修改数据
     *
     * @param stockInventoryList 实例对象列表
     * @return 影响行数
     */
    boolean updateBatch(List<StockInventory> stockInventoryList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    boolean deleteBatch(List<Integer> ids);
}