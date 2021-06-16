package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.CapitalPaymentAccount;
import com.xingji.frameproject.mybatis.dao.CapitalPaymentAccountDao;
import com.xingji.frameproject.service.CapitalPaymentAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CapitalPaymentAccount)表服务实现类
 *
 * @author makejava
 * @since 2021-06-16 19:14:03
 */
@Service("capitalPaymentAccountService")
public class CapitalPaymentAccountServiceImpl implements CapitalPaymentAccountService {
    @Resource
    private CapitalPaymentAccountDao capitalPaymentAccountDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CapitalPaymentAccount queryById(Integer id) {
        return this.capitalPaymentAccountDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CapitalPaymentAccount> queryAllByLimit(int offset, int limit) {
        return this.capitalPaymentAccountDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param capitalPaymentAccount 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalPaymentAccount insert(CapitalPaymentAccount capitalPaymentAccount) {
        this.capitalPaymentAccountDao.insert(capitalPaymentAccount);
        return capitalPaymentAccount;
    }
    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param capitalPaymentAccount List<CapitalPaymentAccount> 实例对象列表
     * @return 影响行数
     */
    @Override
    public List<CapitalPaymentAccount> insertBatch(List<CapitalPaymentAccount> capitalPaymentAccount) {
        this.capitalPaymentAccountDao.insertBatch(capitalPaymentAccount);
        return capitalPaymentAccount;
    }

    /**
     * 修改数据
     *
     * @param capitalPaymentAccount 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalPaymentAccount update(CapitalPaymentAccount capitalPaymentAccount) {
        this.capitalPaymentAccountDao.update(capitalPaymentAccount);
        return this.queryById(capitalPaymentAccount.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.capitalPaymentAccountDao.deleteById(id) > 0;
    }
}
