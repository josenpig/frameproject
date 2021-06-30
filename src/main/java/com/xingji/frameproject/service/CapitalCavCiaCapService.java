package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.CapitalCavCiaCap;

import java.util.List;

/**
 * (CapitalCavCiaCap)表服务接口
 *
 * @author makejava
 * @since 2021-06-08 20:55:55
 */
public interface CapitalCavCiaCapService {

    /**
     * 通过ID查询单条数据
     *
     * @param cavId
     * @return 实例对象
     */
    List<CapitalCavCiaCap> queryById(String cavId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalCavCiaCap> queryAllByLimit(int offset, int limit);

    boolean update(CapitalCavCiaCap capitalCavCiaCap);

    /**
     * 新增数据
     *
     * @param capitalCavCiaCap 实例对象
     * @return 实例对象
     */
    CapitalCavCiaCap insert(CapitalCavCiaCap capitalCavCiaCap);

    List<CapitalCavCiaCap> insertBatch(List<CapitalCavCiaCap> entities);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
