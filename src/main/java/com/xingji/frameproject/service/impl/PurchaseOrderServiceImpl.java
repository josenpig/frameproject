package com.xingji.frameproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingji.frameproject.mybatis.dao.PurchaseOrderDao;
import com.xingji.frameproject.mybatis.entity.PurchaseOrder;
import com.xingji.frameproject.service.PurchaseOrderService;
import com.xingji.frameproject.vo.PurchaseReceiptVo;
import com.xingji.frameproject.vo.form.PurchaseOrderQueryForm;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PurchaseOrder)表服务实现类
 *
 * @author makejava
 * @since 2021-06-02 15:24:43
 */
@Service("purchaseOrderService")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Resource
    private PurchaseOrderDao purchaseOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PurchaseOrder queryById(String id) {
        return this.purchaseOrderDao.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @param purchaseOrderQueryForm 实例对象
     * @return 实例对象
     */
    @Override
    public PageInfo<PurchaseOrder> queryAll(PurchaseOrderQueryForm purchaseOrderQueryForm) {
        Page<PurchaseOrder> page = PageHelper.startPage(purchaseOrderQueryForm.getPageNum(), purchaseOrderQueryForm.getPageSize());
        List<PurchaseOrder> purchaseOrderList = this.purchaseOrderDao.queryAll(purchaseOrderQueryForm);
        return new PageInfo<>(purchaseOrderList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param purchaseOrderQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<PurchaseOrder> queryBySearch(PurchaseOrderQueryForm purchaseOrderQueryForm) {
        Page<PurchaseOrder> page = PageHelper.startPage(purchaseOrderQueryForm.getPageNum(), purchaseOrderQueryForm.getPageSize());
        List<PurchaseOrder> purchaseOrderList = this.purchaseOrderDao.queryOrByPojo(purchaseOrderQueryForm);
        return new PageInfo<>(purchaseOrderList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param purchaseOrderQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<PurchaseOrder> queryByScreen(PurchaseOrderQueryForm purchaseOrderQueryForm) {
        Page<PurchaseOrder> page = PageHelper.startPage(purchaseOrderQueryForm.getPageNum(), purchaseOrderQueryForm.getPageSize());
        List<PurchaseOrder> purchaseOrderList = this.purchaseOrderDao.queryAndByPojo(purchaseOrderQueryForm);
        return new PageInfo<>(purchaseOrderList);
    }

    /**
     * 新增数据
     *
     * @param purchaseOrder 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseOrder insert(PurchaseOrder purchaseOrder) {
        this.purchaseOrderDao.insert(purchaseOrder);
        return purchaseOrder;
    }

    /**
     * 批量新增数据
     *
     * @param PurchaseOrderList 实例对象列表
     * @return 影响行数
     */
    @Override
    public boolean insertBatch(List<PurchaseOrder> PurchaseOrderList) {
        return this.purchaseOrderDao.insertBatch(PurchaseOrderList) == -1;
    }

    /**
     * 修改数据
     *
     * @param purchaseOrder 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseOrder update(PurchaseOrder purchaseOrder) {
        this.purchaseOrderDao.update(purchaseOrder);
        return this.queryById(purchaseOrder.getId());
    }

    /**
     * 批量修改数据
     *
     * @param purchaseOrderList 实例对象列表
     * @return 影响行数
     */
    @Override
    public boolean updateBatch(List<PurchaseOrder> purchaseOrderList) {
        return this.purchaseOrderDao.updateBatch(purchaseOrderList) == -1;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.purchaseOrderDao.deleteById(id) > 0;
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 影响行数
     */
    @Override
    public boolean deleteBatch(List<Integer> ids) {
        int row = this.purchaseOrderDao.deleteBatch(ids);
        return ids.size() == row;
    }

    /**
     * 查询所有的采购订单
     * @return
     */
    @Override
    public List<PurchaseOrder> queryAllByPage(PurchaseOrderQueryForm queryForm) {
        return this.purchaseOrderDao.queryOrByPojo(queryForm);
    }
    /**
     * 通过订单id查询本次付款单信息
     * @param purchaseId 采购单id
     * @return 对象列表
     */
    @Override
    public PurchaseReceiptVo querythisReceipt(String purchaseId){
        return this.purchaseOrderDao.querythisReceipt(purchaseId);
    }
}