package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.StockInventoryDetails;
import com.xingji.frameproject.vo.form.StockInventoryDetailsQueryForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (StockInventoryDetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-10 19:09:12
 */
@Mapper
public interface StockInventoryDetailsDao {

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
    List<StockInventoryDetails> queryAll(StockInventoryDetailsQueryForm stockInventoryDetailsQueryForm);

    /**
     * 通过实体作为或者条件查询
     *
     * @param stockInventoryDetailsQueryForm 实例对象
     * @return 对象列表
     */
    List<StockInventoryDetails> queryOrByPojo(StockInventoryDetailsQueryForm stockInventoryDetailsQueryForm);

    /**
     * 通过实体作为并且条件查询
     *
     * @param stockInventoryDetailsQueryForm 实例对象
     * @return 对象列表
     */
    List<StockInventoryDetails> queryAndByPojo(StockInventoryDetailsQueryForm stockInventoryDetailsQueryForm);

    /**
     * 新增数据
     *
     * @param stockInventoryDetails 实例对象
     * @return 影响行数
     */
    int insert(StockInventoryDetails stockInventoryDetails);

    /**
     * 批量新增数据
     *
     * @param stockInventoryDetailsList 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StockInventoryDetails> stockInventoryDetailsList);

    /**
     * 修改数据
     *
     * @param stockInventoryDetails 实例对象
     * @return 影响行数
     */
    int update(StockInventoryDetails stockInventoryDetails);

    /**
     * 批量修改数据
     *
     * @param stockInventoryDetailsList 实例对象列表
     * @return 影响行数
     */
    int updateBatch(List<StockInventoryDetails> stockInventoryDetailsList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 影响行数
     */
    int deleteBatch(List<Integer> ids);

    /**
     * 根据库存盘点的订单编号查询所有的订单详情记录
     * @param orderId
     * @return
     */
    List<StockInventoryDetails> queryAllById(String orderId);

}