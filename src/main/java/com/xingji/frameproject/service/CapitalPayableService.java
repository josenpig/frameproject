package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.CapitalPayable;
import com.xingji.frameproject.vo.CapitalConditionPageVo;
import com.xingji.frameproject.vo.PurchaseCapitalVo;

import java.util.List;

/**
 * (CapitalPayable)表服务接口
 *
 * @author makejava
 * @since 2021-06-17 15:23:42
 */
public interface CapitalPayableService {

    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId 主键
     * @return 实例对象
     */
    CapitalPayable queryById(String deliveryId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalPayable> queryAllByLimit(int offset, int limit);

    List<CapitalPayable> queryAllByPage(CapitalConditionPageVo vo);

    /**
     * 新增数据
     *
     * @param capitalPayable 实例对象
     * @return 实例对象
     */
    CapitalPayable insert(CapitalPayable capitalPayable);

    /**
     * 修改数据
     *
     * @param capitalPayable 实例对象
     * @return 实例对象
     */
    CapitalPayable update(CapitalPayable capitalPayable);

    /**
     * 通过主键删除数据
     *
     * @param deliveryId 主键
     * @return 是否成功
     */
    boolean deleteById(String deliveryId);

    PurchaseCapitalVo querythisPayment(String purchaseId);
}
