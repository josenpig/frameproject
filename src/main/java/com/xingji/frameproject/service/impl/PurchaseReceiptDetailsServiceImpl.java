package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.PurchaseReceiptDetails;
import com.xingji.frameproject.mybatis.entity.SaleDeliveryDetails;
import com.xingji.frameproject.vo.form.PurchaseReceiptDetailsQueryForm;
import com.xingji.frameproject.mybatis.dao.PurchaseReceiptDetailsDao;
import com.xingji.frameproject.service.PurchaseReceiptDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * (PurchaseReceiptDetails)表服务实现类
 *
 * @author makejava
 * @since 2021-06-16 23:42:53
 */
@Service("purchaseReceiptDetailsService")
public class PurchaseReceiptDetailsServiceImpl implements PurchaseReceiptDetailsService {
    @Resource
    private PurchaseReceiptDetailsDao purchaseReceiptDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PurchaseReceiptDetails queryById(Integer id) {
        return this.purchaseReceiptDetailsDao.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @param purchaseReceiptDetailsQueryForm 实例对象
     * @return 实例对象
     */
    @Override
    public PageInfo<PurchaseReceiptDetails> queryAll(PurchaseReceiptDetailsQueryForm purchaseReceiptDetailsQueryForm) {
        Page<PurchaseReceiptDetails> page = PageHelper.startPage(purchaseReceiptDetailsQueryForm.getPageNum(), purchaseReceiptDetailsQueryForm.getPageSize());
        List<PurchaseReceiptDetails> purchaseReceiptDetailsList = this.purchaseReceiptDetailsDao.queryAll(purchaseReceiptDetailsQueryForm);
        return new PageInfo<>(purchaseReceiptDetailsList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param purchaseReceiptDetailsQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<PurchaseReceiptDetails> queryBySearch(PurchaseReceiptDetailsQueryForm purchaseReceiptDetailsQueryForm) {
        Page<PurchaseReceiptDetails> page = PageHelper.startPage(purchaseReceiptDetailsQueryForm.getPageNum(), purchaseReceiptDetailsQueryForm.getPageSize());
        List<PurchaseReceiptDetails> purchaseReceiptDetailsList = this.purchaseReceiptDetailsDao.queryOrByPojo(purchaseReceiptDetailsQueryForm);
        return new PageInfo<>(purchaseReceiptDetailsList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param purchaseReceiptDetailsQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<PurchaseReceiptDetails> queryByScreen(PurchaseReceiptDetailsQueryForm purchaseReceiptDetailsQueryForm) {
        Page<PurchaseReceiptDetails> page = PageHelper.startPage(purchaseReceiptDetailsQueryForm.getPageNum(), purchaseReceiptDetailsQueryForm.getPageSize());
        List<PurchaseReceiptDetails> purchaseReceiptDetailsList = this.purchaseReceiptDetailsDao.queryAndByPojo(purchaseReceiptDetailsQueryForm);
        return new PageInfo<>(purchaseReceiptDetailsList);
    }

    /**
     * 新增数据
     *
     * @param purchaseReceiptDetails 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseReceiptDetails insert(PurchaseReceiptDetails purchaseReceiptDetails) {
        this.purchaseReceiptDetailsDao.insert(purchaseReceiptDetails);
        return this.queryById(purchaseReceiptDetails.getId());
    }

    /**
     * 批量新增数据
     *
     * @param PurchaseReceiptDetailsList 实例对象列表
     * @return 影响行数
     */
    @Override
    public boolean insertBatch(List<PurchaseReceiptDetails> PurchaseReceiptDetailsList) {
        return this.purchaseReceiptDetailsDao.insertBatch(PurchaseReceiptDetailsList) == -1;
    }

    /**
     * 修改数据
     *
     * @param purchaseReceiptDetails 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseReceiptDetails update(PurchaseReceiptDetails purchaseReceiptDetails) {
        this.purchaseReceiptDetailsDao.update(purchaseReceiptDetails);
        return this.queryById(purchaseReceiptDetails.getId());
    }

    /**
     * 批量修改数据
     *
     * @param purchaseReceiptDetailsList 实例对象列表
     * @return 影响行数
     */
    @Override
    public boolean updateBatch(List<PurchaseReceiptDetails> purchaseReceiptDetailsList) {
        return this.purchaseReceiptDetailsDao.updateBatch(purchaseReceiptDetailsList) == -1;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.purchaseReceiptDetailsDao.deleteById(id) > 0;
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 影响行数
     */
    @Override
    public boolean deleteBatch(List<Integer> ids) {
        int row = this.purchaseReceiptDetailsDao.deleteBatch(ids);
        return ids.size() == row;
    }
    /**
     * 根据采购入库单查询采购入库单商品详情
     * @param id
     * @return
     */
    @Override
    public List<PurchaseReceiptDetails> queryAllByOrderId(String id) {
        return this.purchaseReceiptDetailsDao.queryAllByOrderId(id);
    }
}
