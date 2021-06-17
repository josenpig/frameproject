package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.CapitalCavCia;
import com.xingji.frameproject.vo.CavConditionPageVo;

import java.util.List;

/**
 * (CapitalCavCia)表服务接口
 *
 * @author makejava
 * @since 2021-06-08 20:42:07
 */
public interface CapitalCavCiaService {

    /**
     * 通过ID查询单条数据
     *
     * @param cavId 主键
     * @return 实例对象
     */
    CapitalCavCia queryById(String cavId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalCavCia> queryAllByLimit(int offset, int limit);

    List<CapitalCavCia> queryAll(CapitalCavCia capitalCavCia);

    List<CapitalCavCia> queryonePage(CavConditionPageVo vo);

    List<CapitalCavCia> querytwoPage(CavConditionPageVo vo);

    /**
     * 新增数据
     *
     * @param capitalCavCia 实例对象
     * @return 实例对象
     */
    CapitalCavCia insert(CapitalCavCia capitalCavCia);

    /**
     * 修改数据
     *
     * @param capitalCavCia 实例对象
     * @return 实例对象
     */
    CapitalCavCia update(CapitalCavCia capitalCavCia);

    /**
     * 通过主键删除数据
     *
     * @param cavId 主键
     * @return 是否成功
     */
    boolean deleteById(String cavId);

}
