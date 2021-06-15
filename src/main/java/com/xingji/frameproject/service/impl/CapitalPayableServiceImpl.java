package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.CapitalPayable;
import com.xingji.frameproject.mybatis.dao.CapitalPayableDao;
import com.xingji.frameproject.service.CapitalPayableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CapitalPayable)表服务实现类
 *
 * @author makejava
 * @since 2021-06-15 17:16:35
 */
@Service("capitalPayableService")
public class CapitalPayableServiceImpl implements CapitalPayableService {
    @Resource
    private CapitalPayableDao capitalPayableDao;

    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId 主键
     * @return 实例对象
     */
    @Override
    public CapitalPayable queryById(String deliveryId) {
        return this.capitalPayableDao.queryById(deliveryId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CapitalPayable> queryAllByLimit(int offset, int limit) {
        return this.capitalPayableDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param capitalPayable 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalPayable insert(CapitalPayable capitalPayable) {
        this.capitalPayableDao.insert(capitalPayable);
        return capitalPayable;
    }

    /**
     * 修改数据
     *
     * @param capitalPayable 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalPayable update(CapitalPayable capitalPayable) {
        this.capitalPayableDao.update(capitalPayable);
        return this.queryById(capitalPayable.getDeliveryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param deliveryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String deliveryId) {
        return this.capitalPayableDao.deleteById(deliveryId) > 0;
    }
}