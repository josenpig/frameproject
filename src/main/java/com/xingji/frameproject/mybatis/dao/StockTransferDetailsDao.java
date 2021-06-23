package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.StockTransferDetails;
import com.xingji.frameproject.vo.form.StockTransferDetailsQueryForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (StockTransferDetails)表数据库访问层
 *
 * @author hdr666
 * @since 2021-06-22 14:26:51
 */
@Mapper
public interface StockTransferDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockTransferDetails queryById(Long id);

    /**
     * 查询所有数据
     *
     * @param stockTransferDetailsQueryForm 实例对象
     * @return 实例对象
     */
    List<StockTransferDetails> queryAll(StockTransferDetailsQueryForm stockTransferDetailsQueryForm);

    /**
     * 通过实体作为或者条件查询
     *
     * @param stockTransferDetailsQueryForm 实例对象
     * @return 对象列表
     */
    List<StockTransferDetails> queryOrByPojo(StockTransferDetailsQueryForm stockTransferDetailsQueryForm);

    /**
     * 通过实体作为并且条件查询
     *
     * @param stockTransferDetailsQueryForm 实例对象
     * @return 对象列表
     */
    List<StockTransferDetails> queryAndByPojo(StockTransferDetailsQueryForm stockTransferDetailsQueryForm);

    /**
     * 新增数据
     *
     * @param stockTransferDetails 实例对象
     * @return 影响行数
     */
    int insert(StockTransferDetails stockTransferDetails);

    /**
     * 批量新增数据
     *
     * @param stockTransferDetailsList 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StockTransferDetails> stockTransferDetailsList);

    /**
     * 修改数据
     *
     * @param stockTransferDetails 实例对象
     * @return 影响行数
     */
    int update(StockTransferDetails stockTransferDetails);

    /**
     * 批量修改数据
     *
     * @param stockTransferDetailsList 实例对象列表
     * @return 影响行数
     */
    int updateBatch(List<StockTransferDetails> stockTransferDetailsList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

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
     * @param stockTransferDetailsList 实例对象列表
     * @return 影响行数
     */
    int deleteBatchByEntities(List<StockTransferDetails> stockTransferDetailsList);

    /**
     * 根据调拨单id查询调拨单详情信息
     * @param orderId
     * @return
     */
    List<StockTransferDetails> queryAllById(String orderId);
}

