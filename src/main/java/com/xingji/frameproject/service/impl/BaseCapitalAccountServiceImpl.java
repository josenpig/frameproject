package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.BaseCapitalAccount;
import com.xingji.frameproject.mybatis.dao.BaseCapitalAccountDao;
import com.xingji.frameproject.service.BaseCapitalAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BaseCapitalAccount)表服务实现类
 *
 * @author makejava
 * @since 2021-06-02 18:29:55
 */
@Service("baseCapitalAccountService")
public class BaseCapitalAccountServiceImpl implements BaseCapitalAccountService {
    @Resource
    private BaseCapitalAccountDao baseCapitalAccountDao;

    /**
     * 通过ID查询单条数据
     *
     * @param capitalId 主键
     * @return 实例对象
     */
    @Override
    public BaseCapitalAccount queryById(String capitalId) {
        return this.baseCapitalAccountDao.queryById(capitalId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseCapitalAccount> queryAllByLimit(int offset, int limit) {
        return this.baseCapitalAccountDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baseCapitalAccount 实例对象
     * @return 实例对象
     */
    @Override
    public BaseCapitalAccount insert(BaseCapitalAccount baseCapitalAccount) {
        this.baseCapitalAccountDao.insert(baseCapitalAccount);
        return baseCapitalAccount;
    }

    /**
     * 修改数据
     *
     * @param baseCapitalAccount 实例对象
     * @return 实例对象
     */
    @Override
    public BaseCapitalAccount update(BaseCapitalAccount baseCapitalAccount) {
        this.baseCapitalAccountDao.update(baseCapitalAccount);
        return this.queryById(baseCapitalAccount.getCapitalId());
    }

    /**
     * 通过主键删除数据
     *
     * @param capitalId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String capitalId) {
        return this.baseCapitalAccountDao.deleteById(capitalId) > 0;
    }
    /**
     * 查询多条数据
     *
     * @param baseCapitalAccount
     * @return 对象列表
     */
    @Override
    public List<BaseCapitalAccount> queryAll(BaseCapitalAccount baseCapitalAccount) {
        return this.baseCapitalAccountDao.queryAll(baseCapitalAccount);
    }
    @Override
    public List<BaseCapitalAccount> findAllCapitalAccount() {
        return this.baseCapitalAccountDao.findAllCapitalAccount();
    }
    @Override
    public boolean currentAmountadd(BaseCapitalAccount baseCapitalAccount) {
        return this.baseCapitalAccountDao.currentAmountadd(baseCapitalAccount);
    }
}
