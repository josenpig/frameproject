package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.PurchaseReceipt;
import com.xingji.frameproject.mybatis.entity.PurchaseReturns;
import com.xingji.frameproject.vo.form.PurchaseReceiptQueryForm;
import com.xingji.frameproject.mybatis.dao.PurchaseReceiptDao;
import com.xingji.frameproject.service.PurchaseReceiptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * (PurchaseReceipt)表服务实现类
 *
 * @author makejava
 * @since 2021-06-16 10:00:49
 */
@Service("purchaseReceiptService")
public class PurchaseReceiptServiceImpl implements PurchaseReceiptService {
    @Resource
    private PurchaseReceiptDao purchaseReceiptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PurchaseReceipt queryById(String id) {
        return this.purchaseReceiptDao.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @param purchaseReceiptQueryForm 实例对象
     * @return 实例对象
     */
    @Override
    public PageInfo<PurchaseReceipt> queryAll(PurchaseReceiptQueryForm purchaseReceiptQueryForm) {
        Page<PurchaseReceipt> page = PageHelper.startPage(purchaseReceiptQueryForm.getPageNum(), purchaseReceiptQueryForm.getPageSize());
        List<PurchaseReceipt> purchaseReceiptList = this.purchaseReceiptDao.queryAll(purchaseReceiptQueryForm);
        return new PageInfo<>(purchaseReceiptList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param purchaseReceiptQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<PurchaseReceipt> queryBySearch(PurchaseReceiptQueryForm purchaseReceiptQueryForm) {
        Page<PurchaseReceipt> page = PageHelper.startPage(purchaseReceiptQueryForm.getPageNum(), purchaseReceiptQueryForm.getPageSize());
        List<PurchaseReceipt> purchaseReceiptList = this.purchaseReceiptDao.queryOrByPojo(purchaseReceiptQueryForm);
        return new PageInfo<>(purchaseReceiptList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param purchaseReceiptQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<PurchaseReceipt> queryByScreen(PurchaseReceiptQueryForm purchaseReceiptQueryForm) {
        Page<PurchaseReceipt> page = PageHelper.startPage(purchaseReceiptQueryForm.getPageNum(), purchaseReceiptQueryForm.getPageSize());
        List<PurchaseReceipt> purchaseReceiptList = this.purchaseReceiptDao.queryAndByPojo(purchaseReceiptQueryForm);
        return new PageInfo<>(purchaseReceiptList);
    }

    /**
     * 新增数据
     *
     * @param purchaseReceipt 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseReceipt insert(PurchaseReceipt purchaseReceipt) {
        this.purchaseReceiptDao.insert(purchaseReceipt);
        return this.queryById(purchaseReceipt.getId());
    }

    /**
     * 批量新增数据
     *
     * @param PurchaseReceiptList 实例对象列表
     * @return 影响行数
     */
    @Override
    public boolean insertBatch(List<PurchaseReceipt> PurchaseReceiptList) {
        return this.purchaseReceiptDao.insertBatch(PurchaseReceiptList) == -1;
    }

    /**
     * 修改数据
     *
     * @param purchaseReceipt 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseReceipt update(PurchaseReceipt purchaseReceipt) {
        this.purchaseReceiptDao.update(purchaseReceipt);
        return this.queryById(purchaseReceipt.getId());
    }




    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.purchaseReceiptDao.deleteById(id) > 0;
    }

    /**
     * 查询所有的可可以采购退货的订单
     *      * @return
     * @return
     */
    @Override
    public List<PurchaseReceipt> queryAllByVettingState() {
        return this.purchaseReceiptDao.queryAllByVettingState();
    }


}
