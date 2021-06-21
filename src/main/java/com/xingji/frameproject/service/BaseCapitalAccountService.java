package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.BaseCapitalAccount;
import com.xingji.frameproject.vo.BaseCapitalAccountVo;

import java.util.List;

/**
 * (BaseCapitalAccount)表服务接口
 *
 * @author makejava
 * @since 2021-06-10 15:19:49
 */
public interface BaseCapitalAccountService {

    /**
     * 通过ID查询单条数据
     *
     * @param capitalId 主键
     * @return 实例对象
     */
    BaseCapitalAccount queryById(String capitalId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseCapitalAccount> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baseCapitalAccount 实例对象
     * @return 实例对象
     */
    BaseCapitalAccount insert(BaseCapitalAccount baseCapitalAccount);

    /**
     * 修改数据
     *
     * @param baseCapitalAccount 实例对象
     * @return 实例对象
     */
    BaseCapitalAccount update(BaseCapitalAccount baseCapitalAccount);

    /**
     * 通过主键删除数据
     *
     * @param capitalId 主键
     * @return 是否成功
     */
    boolean deleteById(String capitalId);

    /**
     * 通过Vo作为筛选条件查询
     *
     * @param baseCapitalAccountVo 实例对象
     * @return 对象列表
     */
    List<BaseCapitalAccountVo> queryAllVo(BaseCapitalAccountVo baseCapitalAccountVo);

    /**
     * 修改当前金额数据--加
     *
     * @param baseCapitalAccount 实例对象
     * @return 实例对象
     */
    boolean currentAmountadd(BaseCapitalAccount baseCapitalAccount);

    boolean currentAmountreduce(BaseCapitalAccount baseCapitalAccount);
}
