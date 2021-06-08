package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.SaleOrder;
import com.xingji.frameproject.vo.SaleConditionPageVo;
import com.xingji.frameproject.vo.SaleReceiptVo;

import java.util.List;

/**
 * (SaleOrder)表服务接口
 *
 * @author makejava
 * @since 2021-05-20 19:04:20
 */
public interface SaleOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    SaleOrder queryById(String orderId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SaleOrder> queryAllByLimit(int offset, int limit);
    List<SaleOrder> queryAll(SaleOrder saleOrder);
    /**
     * 新增数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    SaleOrder insert(SaleOrder saleOrder);

    /**
     * 修改数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    SaleOrder update(SaleOrder saleOrder);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    boolean deleteById(String orderId);

    List<SaleOrder> conditionpage(SaleConditionPageVo order);

    List<SaleReceiptVo> queryReceipt(SaleReceiptVo vo);

    SaleReceiptVo querythisReceipt(String saleId);
    /**
     * 修改订单已收款数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    boolean advanceadd(SaleOrder saleOrder);
}
