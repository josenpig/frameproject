package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.StockTransfer;
import com.xingji.frameproject.vo.form.StockTransferQueryForm;

import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * (StockTransfer)表服务接口
 *
 * @author hdr666
 * @since 2021-06-22 14:17:27
 */
public interface StockTransferService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockTransfer queryById(String id);

    /**
     * 查询所有数据
     *
     * @param stockTransferQueryForm 实例对象
     * @return 实例对象
     */
    PageInfo<StockTransfer> queryAll(StockTransferQueryForm stockTransferQueryForm);

    /**
     * 根据查询条件搜索数据
     *
     * @param stockTransferQueryForm
     * @return 对象列表
     */
    PageInfo<StockTransfer> queryBySearch(StockTransferQueryForm stockTransferQueryForm);

    /**
     * 根据查询条件筛选数据
     *
     * @param stockTransferQueryForm
     * @return 对象列表
     */
    PageInfo<StockTransfer> queryByScreen(StockTransferQueryForm stockTransferQueryForm);

    /**
     * 新增数据
     *
     * @param stockTransfer 实例对象
     * @return 实例对象
     */
    StockTransfer insert(StockTransfer stockTransfer);

    /**
     * 批量新增数据
     *
     * @param StockTransferList 实例对象列表
     * @return 影响行数
     */
    boolean insertBatch(List<StockTransfer> StockTransferList);

    /**
     * 修改数据
     *
     * @param stockTransfer 实例对象
     * @return 实例对象
     */
    StockTransfer update(StockTransfer stockTransfer);

    /**
     * 批量修改数据
     *
     * @param stockTransferList 实例对象列表
     * @return 影响行数
     */
    boolean updateBatch(List<StockTransfer> stockTransferList);

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
