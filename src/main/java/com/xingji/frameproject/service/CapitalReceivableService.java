package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.CapitalReceivable;
import com.xingji.frameproject.vo.SaleReceiptVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * (CapitalReceivable)表服务接口
 *
 * @author makejava
 * @since 2021-06-01 11:26:57
 */
public interface CapitalReceivableService {

    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId 主键
     * @return 实例对象
     */
    CapitalReceivable queryById(String deliveryId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalReceivable> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param capitalReceivable 实例对象
     * @return 实例对象
     */
    CapitalReceivable insert(CapitalReceivable capitalReceivable);

    /**
     * 修改数据
     *
     * @param capitalReceivable 实例对象
     * @return 实例对象
     */
    CapitalReceivable update(CapitalReceivable capitalReceivable);

    /**
     * 通过主键删除数据
     *
     * @param deliveryId 主键
     * @return 是否成功
     */
    boolean deleteById(String deliveryId);

    List<CapitalReceivable> queryAllByPage();

    List<SaleReceiptVo> queryReceipt(SaleReceiptVo vo);

    SaleReceiptVo querythisReceipt(String saleId);
    /**
     * 修改已收金额数据
     *
     * @param capitalReceivable 实例对象
     * @return 实例对象
     */
    CapitalReceivable receivedadd(CapitalReceivable capitalReceivable);
}
