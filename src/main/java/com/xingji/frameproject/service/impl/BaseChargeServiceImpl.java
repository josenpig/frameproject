package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.BaseCharge;
import com.xingji.frameproject.mybatis.dao.BaseChargeDao;
import com.xingji.frameproject.mybatis.entity.BaseCharge;
import com.xingji.frameproject.service.BaseChargeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BaseCharge)表服务实现类
 *
 * @author makejava
 * @since 2021-06-01 17:01:50
 */
@Service("baseChargeService")
public class BaseChargeServiceImpl implements BaseChargeService {
    @Resource
    private BaseChargeDao baseChargeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param chargeId 主键
     * @return 实例对象
     */
    @Override
    public BaseCharge queryById(Integer chargeId) {
        return this.baseChargeDao.queryById(chargeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseCharge> queryAllByLimit(int offset, int limit) {
        return this.baseChargeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baseCharge 实例对象
     * @return 实例对象
     */
    @Override
    public BaseCharge insert(BaseCharge baseCharge) {
        this.baseChargeDao.insert(baseCharge);
        return baseCharge;
    }

    /**
     * 修改数据
     *
     * @param baseCharge 实例对象
     * @return 实例对象
     */
    @Override
    public BaseCharge update(BaseCharge baseCharge) {
        this.baseChargeDao.update(baseCharge);
        return this.queryById(baseCharge.getChargeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param chargeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer chargeId) {
        return this.baseChargeDao.deleteById(chargeId) > 0;
    }

    @Override
    public List<BaseCharge> findAllCharge() {
        return this.baseChargeDao.findAllCharge();
    }
}
