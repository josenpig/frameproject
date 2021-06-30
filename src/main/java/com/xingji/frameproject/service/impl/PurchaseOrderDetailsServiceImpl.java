package com.xingji.frameproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingji.frameproject.mybatis.dao.PurchaseOrderDetailsDao;
import com.xingji.frameproject.mybatis.entity.BaseProduct;
import com.xingji.frameproject.mybatis.entity.BaseVendorProduct;
import com.xingji.frameproject.mybatis.entity.PurchaseOrderDetails;
import com.xingji.frameproject.service.PurchaseOrderDetailsService;
import com.xingji.frameproject.vo.form.PurchaseOrderDetailsQueryForm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PurchaseOrderDetails)表服务实现类
 *
 * @author makejava
 * @since 2021-06-02 09:52:32
 */
@Service("purchaseOrderDetailsService")
public class PurchaseOrderDetailsServiceImpl implements PurchaseOrderDetailsService {
    @Resource
    private PurchaseOrderDetailsDao purchaseOrderDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PurchaseOrderDetails queryById(Integer id) {
        return this.purchaseOrderDetailsDao.queryById(id);
    }

    /**
     * 通过采购订单进行查询订单详情
     * @param orderid
     * @return
     */
    @Override
    public List<PurchaseOrderDetails> queryAllByOrderId(String orderid) {
        return this.purchaseOrderDetailsDao.queryAllByOrderId(orderid);
    }

    /**
     * 查询所有数据
     *
     * @param purchaseOrderDetailsQueryForm 实例对象
     * @return 实例对象
     */
    @Override
    public PageInfo<PurchaseOrderDetails> queryAll(PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm) {
        Page<PurchaseOrderDetails> page = PageHelper.startPage(purchaseOrderDetailsQueryForm.getPageNum(), purchaseOrderDetailsQueryForm.getPageSize());
        List<PurchaseOrderDetails> purchaseOrderDetailsList = this.purchaseOrderDetailsDao.queryAll(purchaseOrderDetailsQueryForm);
        return new PageInfo<>(purchaseOrderDetailsList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param purchaseOrderDetailsQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<PurchaseOrderDetails> queryBySearch(PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm) {
        Page<PurchaseOrderDetails> page = PageHelper.startPage(purchaseOrderDetailsQueryForm.getPageNum(), purchaseOrderDetailsQueryForm.getPageSize());
        List<PurchaseOrderDetails> purchaseOrderDetailsList = this.purchaseOrderDetailsDao.queryOrByPojo(purchaseOrderDetailsQueryForm);
        return new PageInfo<>(purchaseOrderDetailsList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param purchaseOrderDetailsQueryForm
     * @return 对象列表
     */
    @Override
    public PageInfo<PurchaseOrderDetails> queryByScreen(PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm) {
        Page<PurchaseOrderDetails> page = PageHelper.startPage(purchaseOrderDetailsQueryForm.getPageNum(), purchaseOrderDetailsQueryForm.getPageSize());
        List<PurchaseOrderDetails> purchaseOrderDetailsList = this.purchaseOrderDetailsDao.queryAndByPojo(purchaseOrderDetailsQueryForm);
        return new PageInfo<>(purchaseOrderDetailsList);
    }

    /**
     * 新增数据
     *
     * @param purchaseOrderDetails 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseOrderDetails insert(PurchaseOrderDetails purchaseOrderDetails) {
        this.purchaseOrderDetailsDao.insert(purchaseOrderDetails);
        return purchaseOrderDetails;
    }

    @Override
    public int insertBatch(List<PurchaseOrderDetails> PurchaseOrderDetailsList) {
        System.out.println(PurchaseOrderDetailsList);
        return this.purchaseOrderDetailsDao.batchInsert(PurchaseOrderDetailsList);
    }


    /**
     * 修改数据
     *
     * @param purchaseOrderDetails 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(PurchaseOrderDetails purchaseOrderDetails) {
        int i  = this.purchaseOrderDetailsDao.update(purchaseOrderDetails);
        return i>0?true:false;
    }



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.purchaseOrderDetailsDao.deleteById(id) > 0;
    }

    /**
     * 通过实体作为并且条件查询
     *
     * @param purchaseOrderDetailsQueryForm 实例对象
     * @return 对象列表
     */
    @Override
    public List<PurchaseOrderDetails> queryAndByPojo(PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm) {
        return this.purchaseOrderDetailsDao.queryAndByPojo(purchaseOrderDetailsQueryForm);
    }

    @Override
    public List<PurchaseOrderDetails> findPODofVidAndPid(BaseVendorProduct baseVendorProduct) {
        return this.purchaseOrderDetailsDao.findPODofVidAndPid(baseVendorProduct);
    }

}