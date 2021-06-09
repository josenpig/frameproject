package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.StockInventory;
import com.xingji.frameproject.vo.form.StockInventoryQueryForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (StockInventory)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-08 21:08:19
 */
@Mapper
public interface StockInventoryDao {

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
    List<StockInventory> queryAll(StockInventoryQueryForm stockInventoryQueryForm);

    /**
     * 通过实体作为或者条件查询
     *
     * @param stockInventoryQueryForm 实例对象
     * @return 对象列表
     */
    List<StockInventory> queryOrByPojo(StockInventoryQueryForm stockInventoryQueryForm);

    /**
     * 通过实体作为并且条件查询
     *
     * @param stockInventoryQueryForm 实例对象
     * @return 对象列表
     */
    List<StockInventory> queryAndByPojo(StockInventoryQueryForm stockInventoryQueryForm);

    /**
     * 新增数据
     *
     * @param stockInventory 实例对象
     * @return 影响行数
     */
    int insert(StockInventory stockInventory);

    /**
     * 批量新增数据
     *
     * @param stockInventoryList 实例对象列表
     * @return 影响行数
     */
    int insertBatch(List<StockInventory> stockInventoryList);

    /**
     * 修改数据
     *
     * @param stockInventory 实例对象
     * @return 影响行数
     */
    int update(StockInventory stockInventory);

    /**
     * 批量修改数据
     *
     * @param stockInventoryList 实例对象列表
     * @return 影响行数
     */
    int updateBatch(List<StockInventory> stockInventoryList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 影响行数
     */
    int deleteBatch(List<Integer> ids);
}