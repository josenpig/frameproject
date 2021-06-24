package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.BaseCustomer;
import com.xingji.frameproject.mybatis.dao.BaseCustomerDao;
import com.xingji.frameproject.service.BaseCustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BaseCustomer)表服务实现类
 *
 * @author makejava
 * @since 2021-06-03 16:44:14
 */
@Service("baseCustomerService")
public class BaseCustomerServiceImpl implements BaseCustomerService {
    @Resource
    private BaseCustomerDao baseCustomerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param customerNumber 主键
     * @return 实例对象
     */
    @Override
    public BaseCustomer queryById(String customerNumber) {
        return this.baseCustomerDao.queryById(customerNumber);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseCustomer> queryAllByLimit(int offset, int limit) {
        return this.baseCustomerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baseCustomer 实例对象
     * @return 实例对象
     */
    @Override
    public BaseCustomer insert(BaseCustomer baseCustomer) {
        this.baseCustomerDao.insert(baseCustomer);
        return baseCustomer;
    }

    /**
     * 修改数据
     *
     * @param baseCustomer 实例对象
     * @return 实例对象
     */
    @Override
    public BaseCustomer update(BaseCustomer baseCustomer) {
        this.baseCustomerDao.update(baseCustomer);
        return this.queryById(baseCustomer.getCustomerNumber());
    }

    /**
     * 通过主键删除数据
     *
     * @param customerNumber 主键
     * @return 是否成功
     */
    @Override
    public String deleteById(String customerNumber) {
        return this.baseCustomerDao.deleteById(customerNumber) > 0?"删除成功":"删除失败";
    }
    @Override
    public List<BaseCustomer> queryAll(BaseCustomer baseCustomer) {
        return this.baseCustomerDao.queryAll(baseCustomer);
    }
    /**
     * 查询所有客户信息||通过条件查询客户
     * @param baseCustomer
     * @return
     */
    @Override
    public List<BaseCustomer> findAllCustomer(BaseCustomer baseCustomer) {
        return this.baseCustomerDao.findAllCustomer(baseCustomer);
    }
}
