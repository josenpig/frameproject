package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.PurchaseReturnsDetailsDao;
import com.xingji.frameproject.mybatis.entity.PurchaseReturnsDetails;
import com.xingji.frameproject.service.PurchaseReturnsDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PurchaseReturnDetailsService")
public class PurchaseReturnDetailsServiceImpl implements PurchaseReturnsDetailsService {

    @Resource
    PurchaseReturnsDetailsDao detailsDao;

    @Override
    public PurchaseReturnsDetails queryById(Integer id) {
        return null;
    }

    @Override
    public List<PurchaseReturnsDetails> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public PurchaseReturnsDetails insert(PurchaseReturnsDetails purchaseReturnsDetails) {
        return null;
    }

    @Override
    public PurchaseReturnsDetails update(PurchaseReturnsDetails purchaseReturnsDetails) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public int insertBatch(List<PurchaseReturnsDetails> deliverydetails) {
        return this.detailsDao.batchInsert(deliverydetails);
    }
}
