package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.CapitalCavCiaBill;

import java.util.List;

/**
 * (CapitalCavCiaBill)表服务接口
 *
 * @author makejava
 * @since 2021-06-08 20:55:46
 */
public interface CapitalCavCiaBillService {

    /**
     * 通过ID查询单条数据
     *
     * @param cavId
     * @return 实例对象
     */
    List<CapitalCavCiaBill> queryById(String cavId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalCavCiaBill> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param capitalCavCiaBill 实例对象
     * @return 实例对象
     */
    CapitalCavCiaBill insert(CapitalCavCiaBill capitalCavCiaBill);

    List<CapitalCavCiaBill> insertBatch(List<CapitalCavCiaBill> entities);

    boolean update(CapitalCavCiaBill capitalCavCiaBill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
