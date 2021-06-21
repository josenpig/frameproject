package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.BaseVendor;

import java.util.List;

/**
 * (BaseVendor)表服务接口
 *
 * @author makejava
 * @since 2021-06-04 15:11:45
 */
public interface BaseVendorService {

    /**
     * 通过ID查询单条数据
     *
     * @param vendorId 主键
     * @return 实例对象
     */
    BaseVendor queryById(String vendorId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseVendor> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baseVendor 实例对象
     * @return 实例对象
     */
    BaseVendor insert(BaseVendor baseVendor);

    /**
     * 修改数据
     *
     * @param baseVendor 实例对象
     * @return 实例对象
     */
    BaseVendor update(BaseVendor baseVendor);

    /**
     * 通过主键删除数据
     *
     * @param vendorId 主键
     * @return 是否成功
     */
    boolean deleteById(String vendorId);

    /**
     * 查询所有供应商信息||通过条件查询供应商
     * @return
     * @param baseVendor
     */
    List<BaseVendor> findAllVendor(BaseVendor baseVendor);

    /**
     * 根据供应商id查询供应商用户名
     * @param vendorId
     * @return
     */
    String findVendorName(String vendorId);

    /**
     * 根据供应商用户名查询供应商id
     * @param vendorName
     * @return
     */
    String findVendorId(String vendorName);
}
