package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.CapitalCavCiaBill;
import com.xingji.frameproject.mybatis.dao.CapitalCavCiaBillDao;
import com.xingji.frameproject.service.CapitalCavCiaBillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CapitalCavCiaBill)表服务实现类
 *
 * @author makejava
 * @since 2021-06-08 20:55:46
 */
@Service("capitalCavCiaBillService")
public class CapitalCavCiaBillServiceImpl implements CapitalCavCiaBillService {
    @Resource
    private CapitalCavCiaBillDao capitalCavCiaBillDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cavId
     * @return 实例对象
     */
    @Override
    public List<CapitalCavCiaBill> queryById(String cavId) {
        return this.capitalCavCiaBillDao.queryById(cavId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CapitalCavCiaBill> queryAllByLimit(int offset, int limit) {
        return this.capitalCavCiaBillDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param capitalCavCiaBill 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalCavCiaBill insert(CapitalCavCiaBill capitalCavCiaBill) {
        this.capitalCavCiaBillDao.insert(capitalCavCiaBill);
        return capitalCavCiaBill;
    }
    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalCavCiaBill> 实例对象列表
     * @return 影响行数
     */
    @Override
    public List<CapitalCavCiaBill> insertBatch(List<CapitalCavCiaBill> entities) {
        this.capitalCavCiaBillDao.insertBatch(entities);
        return entities;
    }
    /**
     * 修改数据
     *
     * @param capitalCavCiaBill 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(CapitalCavCiaBill capitalCavCiaBill) {
        return this.capitalCavCiaBillDao.update(capitalCavCiaBill)>0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.capitalCavCiaBillDao.deleteById(id) > 0;
    }
}
