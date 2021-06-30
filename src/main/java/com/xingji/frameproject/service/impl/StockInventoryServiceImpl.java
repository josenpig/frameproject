package com.xingji.frameproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingji.frameproject.mybatis.dao.StockInventoryDao;
import com.xingji.frameproject.mybatis.entity.StockInventory;
import com.xingji.frameproject.service.StockInventoryService;
import com.xingji.frameproject.vo.PurchaseReceiptConditionVo;
import com.xingji.frameproject.vo.form.StockInventoryQueryForm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (StockInventory)表服务实现类
 *
 * @author makejava
 * @since 2021-06-08 21:08:21
 */
@Service("stockInventoryService")
public class StockInventoryServiceImpl implements StockInventoryService {
    @Resource
    private StockInventoryDao stockInventoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StockInventory queryById(String id) {
        return this.stockInventoryDao.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @param stockInventoryQueryForm 实例对象
     * @return 实例对象
     */
    @Override
    public PageInfo<StockInventory> queryAll(StockInventoryQueryForm stockInventoryQueryForm) {
        Page<StockInventory> page = PageHelper.startPage(stockInventoryQueryForm.getPageNum(), stockInventoryQueryForm.getPageSize());
        List<StockInventory> stockInventoryList = this.stockInventoryDao.queryAll(stockInventoryQueryForm);
        return new PageInfo<>(stockInventoryList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param stockInventoryQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<StockInventory> queryBySearch(StockInventoryQueryForm stockInventoryQueryForm) {
        Page<StockInventory> page = PageHelper.startPage(stockInventoryQueryForm.getPageNum(), stockInventoryQueryForm.getPageSize());
        List<StockInventory> stockInventoryList = this.stockInventoryDao.queryOrByPojo(stockInventoryQueryForm);
        return new PageInfo<>(stockInventoryList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param stockInventoryQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<StockInventory> queryByScreen(StockInventoryQueryForm stockInventoryQueryForm) {
        Page<StockInventory> page = PageHelper.startPage(stockInventoryQueryForm.getPageNum(), stockInventoryQueryForm.getPageSize());
        List<StockInventory> stockInventoryList = this.stockInventoryDao.queryAndByPojo(stockInventoryQueryForm);
        return new PageInfo<>(stockInventoryList);
    }

    /**
     * 新增数据
     *
     * @param stockInventory 实例对象
     * @return 实例对象
     */
    @Override
    public StockInventory insert(StockInventory stockInventory) {
        this.stockInventoryDao.insert(stockInventory);
        return stockInventory;
    }

    /**
     * 批量新增数据
     *
     * @param StockInventoryList 实例对象列表
     * @return 影响行数
     */
    @Override
    public boolean insertBatch(List<StockInventory> StockInventoryList) {
        return this.stockInventoryDao.insertBatch(StockInventoryList) == -1;
    }

    /**
     * 修改数据
     *
     * @param stockInventory 实例对象
     * @return 实例对象
     */
    @Override
    public StockInventory update(StockInventory stockInventory) {
        this.stockInventoryDao.update(stockInventory);
        return this.queryById(stockInventory.getId());
    }

    /**
     * 批量修改数据
     *
     * @param stockInventoryList 实例对象列表
     * @return 影响行数
     */
    @Override
    public boolean updateBatch(List<StockInventory> stockInventoryList) {
        return this.stockInventoryDao.updateBatch(stockInventoryList) == -1;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.stockInventoryDao.deleteById(id) > 0;
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 影响行数
     */
    @Override
    public boolean deleteBatch(List<Integer> ids) {
        int row = this.stockInventoryDao.deleteBatch(ids);
        return ids.size() == row;
    }

    /**
     * 分页查询库存盘点订单列表
     * @param order
     * @return
     */
    @Override
    public List<StockInventory> conditionpage(PurchaseReceiptConditionVo order) {
        return this.stockInventoryDao.conditionpage(order);
    }
}