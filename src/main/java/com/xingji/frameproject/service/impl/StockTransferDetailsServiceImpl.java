package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.StockTransferDetails;
import com.xingji.frameproject.vo.form.StockTransferDetailsQueryForm;
import com.xingji.frameproject.mybatis.dao.StockTransferDetailsDao;
import com.xingji.frameproject.service.StockTransferDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * (StockTransferDetails)表服务实现类
 *
 * @author hdr666
 * @since 2021-06-22 14:26:52
 */
@Service("stockTransferDetailsService")
public class StockTransferDetailsServiceImpl implements StockTransferDetailsService {
    @Resource
    private StockTransferDetailsDao stockTransferDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StockTransferDetails queryById(Long id) {
        return this.stockTransferDetailsDao.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @param stockTransferDetailsQueryForm 实例对象
     * @return 实例对象
     */
    @Override
    public PageInfo<StockTransferDetails> queryAll(StockTransferDetailsQueryForm stockTransferDetailsQueryForm) {
        Page<StockTransferDetails> page = PageHelper.startPage(stockTransferDetailsQueryForm.getPageNum(), stockTransferDetailsQueryForm.getPageSize());
        List<StockTransferDetails> stockTransferDetailsList = this.stockTransferDetailsDao.queryAll(stockTransferDetailsQueryForm);
        return new PageInfo<>(stockTransferDetailsList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param stockTransferDetailsQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<StockTransferDetails> queryBySearch(StockTransferDetailsQueryForm stockTransferDetailsQueryForm) {
        Page<StockTransferDetails> page = PageHelper.startPage(stockTransferDetailsQueryForm.getPageNum(), stockTransferDetailsQueryForm.getPageSize());
        List<StockTransferDetails> stockTransferDetailsList = this.stockTransferDetailsDao.queryOrByPojo(stockTransferDetailsQueryForm);
        return new PageInfo<>(stockTransferDetailsList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param stockTransferDetailsQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<StockTransferDetails> queryByScreen(StockTransferDetailsQueryForm stockTransferDetailsQueryForm) {
        Page<StockTransferDetails> page = PageHelper.startPage(stockTransferDetailsQueryForm.getPageNum(), stockTransferDetailsQueryForm.getPageSize());
        List<StockTransferDetails> stockTransferDetailsList = this.stockTransferDetailsDao.queryAndByPojo(stockTransferDetailsQueryForm);
        return new PageInfo<>(stockTransferDetailsList);
    }

    /**
     * 新增数据
     *
     * @param stockTransferDetails 实例对象
     * @return 实例对象
     */
    @Override
    public StockTransferDetails insert(StockTransferDetails stockTransferDetails) {
        this.stockTransferDetailsDao.insert(stockTransferDetails);
        return this.queryById(stockTransferDetails.getId());
    }

    /**
     * 批量新增数据
     *
     * @param StockTransferDetailsList 实例对象列表
     * @return 影响行数
     */
    @Override
    public boolean insertBatch(List<StockTransferDetails> StockTransferDetailsList) {
        return this.stockTransferDetailsDao.insertBatch(StockTransferDetailsList) == -1;
    }

    /**
     * 修改数据
     *
     * @param stockTransferDetails 实例对象
     * @return 实例对象
     */
    @Override
    public StockTransferDetails update(StockTransferDetails stockTransferDetails) {
        this.stockTransferDetailsDao.update(stockTransferDetails);
        return this.queryById(stockTransferDetails.getId());
    }

    /**
     * 批量修改数据
     *
     * @param stockTransferDetailsList 实例对象列表
     * @return 影响行数
     */
    @Override
    public boolean updateBatch(List<StockTransferDetails> stockTransferDetailsList) {
        return this.stockTransferDetailsDao.updateBatch(stockTransferDetailsList) == -1;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.stockTransferDetailsDao.deleteById(id) > 0;
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 影响行数
     */
    @Override
    public boolean deleteBatch(List<Integer> ids) {
        int row = this.stockTransferDetailsDao.deleteBatch(ids);
        return ids.size() == row;
    }

    /**
     * 根据调拨单id查询调拨单详情信息
     * @param orderId
     * @return
     */
    @Override
    public List<StockTransferDetails> queryAllById(String orderId) {
        return this.stockTransferDetailsDao.queryAllById(orderId);
    }
}
