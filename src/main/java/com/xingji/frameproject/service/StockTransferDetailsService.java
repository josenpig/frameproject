package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.StockTransferDetails;
import com.xingji.frameproject.vo.form.StockTransferDetailsQueryForm;

import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * (StockTransferDetails)表服务接口
 *
 * @author hdr666
 * @since 2021-06-22 14:26:51
 */
public interface StockTransferDetailsService {

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
    PageInfo<StockTransferDetails> queryAll(StockTransferDetailsQueryForm stockTransferDetailsQueryForm);

    /**
     * 根据查询条件搜索数据
     *
     * @param stockTransferDetailsQueryForm
     * @return 对象列表
     */
    PageInfo<StockTransferDetails> queryBySearch(StockTransferDetailsQueryForm stockTransferDetailsQueryForm);

    /**
     * 根据查询条件筛选数据
     *
     * @param stockTransferDetailsQueryForm
     * @return 对象列表
     */
    PageInfo<StockTransferDetails> queryByScreen(StockTransferDetailsQueryForm stockTransferDetailsQueryForm);

    /**
     * 新增数据
     *
     * @param stockTransferDetails 实例对象
     * @return 实例对象
     */
    StockTransferDetails insert(StockTransferDetails stockTransferDetails);

    /**
     * 批量新增数据
     *
     * @param StockTransferDetailsList 实例对象列表
     * @return 影响行数
     */
    boolean insertBatch(List<StockTransferDetails> StockTransferDetailsList);

    /**
     * 修改数据
     *
     * @param stockTransferDetails 实例对象
     * @return 实例对象
     */
    StockTransferDetails update(StockTransferDetails stockTransferDetails);

    /**
     * 批量修改数据
     *
     * @param stockTransferDetailsList 实例对象列表
     * @return 影响行数
     */
    boolean updateBatch(List<StockTransferDetails> stockTransferDetailsList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    boolean deleteBatch(List<Integer> ids);

    /**
     * 根据调拨单id查询调拨单详情信息
     * @param orderId
     * @return
     */
    List<StockTransferDetails> queryAllById(String orderId);
}
