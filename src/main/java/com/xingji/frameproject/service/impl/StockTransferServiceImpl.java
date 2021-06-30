package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.StockTransfer;
import com.xingji.frameproject.vo.PurchaseReceiptConditionVo;
import com.xingji.frameproject.vo.form.StockTransferQueryForm;
import com.xingji.frameproject.mybatis.dao.StockTransferDao;
import com.xingji.frameproject.service.StockTransferService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * (StockTransfer)表服务实现类
 *
 * @author hdr666
 * @since 2021-06-22 14:17:27
 */
@Service("stockTransferService")
public class StockTransferServiceImpl implements StockTransferService {
    @Resource
    private StockTransferDao stockTransferDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StockTransfer queryById(String id) {
        return this.stockTransferDao.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @param stockTransferQueryForm 实例对象
     * @return 实例对象
     */
    @Override
    public PageInfo<StockTransfer> queryAll(StockTransferQueryForm stockTransferQueryForm) {
        Page<StockTransfer> page = PageHelper.startPage(stockTransferQueryForm.getPageNum(), stockTransferQueryForm.getPageSize());
        List<StockTransfer> stockTransferList = this.stockTransferDao.queryAll(stockTransferQueryForm);
        return new PageInfo<>(stockTransferList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param stockTransferQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<StockTransfer> queryBySearch(StockTransferQueryForm stockTransferQueryForm) {
        Page<StockTransfer> page = PageHelper.startPage(stockTransferQueryForm.getPageNum(), stockTransferQueryForm.getPageSize());
        List<StockTransfer> stockTransferList = this.stockTransferDao.queryOrByPojo(stockTransferQueryForm);
        return new PageInfo<>(stockTransferList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param stockTransferQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<StockTransfer> queryByScreen(StockTransferQueryForm stockTransferQueryForm) {
        Page<StockTransfer> page = PageHelper.startPage(stockTransferQueryForm.getPageNum(), stockTransferQueryForm.getPageSize());
        List<StockTransfer> stockTransferList = this.stockTransferDao.queryAndByPojo(stockTransferQueryForm);
        return new PageInfo<>(stockTransferList);
    }

    /**
     * 新增数据
     *
     * @param stockTransfer 实例对象
     * @return 实例对象
     */
    @Override
    public StockTransfer insert(StockTransfer stockTransfer) {
        this.stockTransferDao.insert(stockTransfer);
        return this.queryById(stockTransfer.getId());
    }

    /**
     * 批量新增数据
     *
     * @param StockTransferList 实例对象列表
     * @return 影响行数
     */
    @Override
    public boolean insertBatch(List<StockTransfer> StockTransferList) {
        return this.stockTransferDao.insertBatch(StockTransferList) == -1;
    }

    /**
     * 修改数据
     *
     * @param stockTransfer 实例对象
     * @return 实例对象
     */
    @Override
    public StockTransfer update(StockTransfer stockTransfer) {
        this.stockTransferDao.update(stockTransfer);
        return this.queryById(stockTransfer.getId());
    }

    /**
     * 批量修改数据
     *
     * @param stockTransferList 实例对象列表
     * @return 影响行数
     */
    @Override
    public boolean updateBatch(List<StockTransfer> stockTransferList) {
        return this.stockTransferDao.updateBatch(stockTransferList) == -1;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.stockTransferDao.deleteById(id) > 0;
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 影响行数
     */
    @Override
    public boolean deleteBatch(List<Integer> ids) {
        int row = this.stockTransferDao.deleteBatch(ids);
        return ids.size() == row;
    }

    /**
     * 分页查询订单列表
     * @param order
     * @return
     */
    @Override
    public List<StockTransfer> conditionpage(PurchaseReceiptConditionVo order) {
        return this.stockTransferDao.conditionpage(order);
    }
}
