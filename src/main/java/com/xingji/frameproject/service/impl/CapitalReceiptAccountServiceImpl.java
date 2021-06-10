package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.CapitalReceiptAccount;
import com.xingji.frameproject.mybatis.dao.CapitalReceiptAccountDao;
import com.xingji.frameproject.service.CapitalReceiptAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CapitalReceiptAccount)表服务实现类
 *
 * @author makejava
 * @since 2021-06-02 20:21:38
 */
@Service("capitalReceiptAccountService")
public class CapitalReceiptAccountServiceImpl implements CapitalReceiptAccountService {
    @Resource
    private CapitalReceiptAccountDao capitalReceiptAccountDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public List<CapitalReceiptAccount> queryById(String id) {
        return this.capitalReceiptAccountDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CapitalReceiptAccount> queryAllByLimit(int offset, int limit) {
        return this.capitalReceiptAccountDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param capitalReceiptAccount 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalReceiptAccount insert(CapitalReceiptAccount capitalReceiptAccount) {
        this.capitalReceiptAccountDao.insert(capitalReceiptAccount);
        return capitalReceiptAccount;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param capitalReceiptAccount 实例对象
     * @return 对象列表
     */
    @Override
    public List<CapitalReceiptAccount> queryAll(CapitalReceiptAccount capitalReceiptAccount) {
        return this.capitalReceiptAccountDao.queryAll(capitalReceiptAccount);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.capitalReceiptAccountDao.deleteById(id) > 0;
    }
    /**
     * 新增多条数据
     *
     * @param capitalReceiptAccount 实例对象
     * @return 实例对象
     */
    @Override
    public List<CapitalReceiptAccount> insertBatch(List<CapitalReceiptAccount> capitalReceiptAccount) {
        this.capitalReceiptAccountDao.insertBatch(capitalReceiptAccount);
        return capitalReceiptAccount;
    }
}
