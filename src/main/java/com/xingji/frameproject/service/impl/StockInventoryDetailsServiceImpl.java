package com.xingji.frameproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingji.frameproject.mybatis.dao.StockInventoryDetailsDao;
import com.xingji.frameproject.mybatis.entity.StockInventoryDetails;
import com.xingji.frameproject.service.StockInventoryDetailsService;
import com.xingji.frameproject.vo.form.StockInventoryDetailsQueryForm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (StockInventoryDetails)表服务实现类
 *
 * @author makejava
 * @since 2021-06-10 19:09:14
 */
@Service("stockInventoryDetailsService")
public class StockInventoryDetailsServiceImpl implements StockInventoryDetailsService {
    @Resource
    private StockInventoryDetailsDao stockInventoryDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StockInventoryDetails queryById(Integer id) {
        return this.stockInventoryDetailsDao.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @param stockInventoryDetailsQueryForm 实例对象
     * @return 实例对象
     */
    @Override
    public PageInfo<StockInventoryDetails> queryAll(StockInventoryDetailsQueryForm stockInventoryDetailsQueryForm) {
        Page<StockInventoryDetails> page = PageHelper.startPage(stockInventoryDetailsQueryForm.getPageNum(), stockInventoryDetailsQueryForm.getPageSize());
        List<StockInventoryDetails> stockInventoryDetailsList = this.stockInventoryDetailsDao.queryAll(stockInventoryDetailsQueryForm);
        return new PageInfo<>(stockInventoryDetailsList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param stockInventoryDetailsQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<StockInventoryDetails> queryBySearch(StockInventoryDetailsQueryForm stockInventoryDetailsQueryForm) {
        Page<StockInventoryDetails> page = PageHelper.startPage(stockInventoryDetailsQueryForm.getPageNum(), stockInventoryDetailsQueryForm.getPageSize());
        List<StockInventoryDetails> stockInventoryDetailsList = this.stockInventoryDetailsDao.queryOrByPojo(stockInventoryDetailsQueryForm);
        return new PageInfo<>(stockInventoryDetailsList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param stockInventoryDetailsQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<StockInventoryDetails> queryByScreen(StockInventoryDetailsQueryForm stockInventoryDetailsQueryForm) {
        Page<StockInventoryDetails> page = PageHelper.startPage(stockInventoryDetailsQueryForm.getPageNum(), stockInventoryDetailsQueryForm.getPageSize());
        List<StockInventoryDetails> stockInventoryDetailsList = this.stockInventoryDetailsDao.queryAndByPojo(stockInventoryDetailsQueryForm);
        return new PageInfo<>(stockInventoryDetailsList);
    }

    /**
     * 新增数据
     *
     * @param stockInventoryDetails 实例对象
     * @return 实例对象
     */
    @Override
    public StockInventoryDetails insert(StockInventoryDetails stockInventoryDetails) {
        this.stockInventoryDetailsDao.insert(stockInventoryDetails);
        return stockInventoryDetails;
    }

    /**
     * 批量新增数据
     *
     * @param StockInventoryDetailsList 实例对象列表
     * @return 影响行数
     */
    @Override
    public boolean insertBatch(List<StockInventoryDetails> StockInventoryDetailsList) {
        return this.stockInventoryDetailsDao.insertBatch(StockInventoryDetailsList) == -1;
    }

    /**
     * 修改数据
     *
     * @param stockInventoryDetails 实例对象
     * @return 实例对象
     */
    @Override
    public StockInventoryDetails update(StockInventoryDetails stockInventoryDetails) {
        this.stockInventoryDetailsDao.update(stockInventoryDetails);
        return this.queryById(stockInventoryDetails.getId());
    }

    /**
     * 批量修改数据
     *
     * @param stockInventoryDetailsList 实例对象列表
     * @return 影响行数
     */
    @Override
    public boolean updateBatch(List<StockInventoryDetails> stockInventoryDetailsList) {
        return this.stockInventoryDetailsDao.updateBatch(stockInventoryDetailsList) == -1;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.stockInventoryDetailsDao.deleteById(id) > 0;
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 影响行数
     */
    @Override
    public boolean deleteBatch(List<Integer> ids) {
        int row = this.stockInventoryDetailsDao.deleteBatch(ids);
        return ids.size() == row;
    }
}