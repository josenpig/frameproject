package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.BaseVendorProduct;
import com.xingji.frameproject.vo.BaseVendorProductVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BaseVendorProduct)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-25 15:14:23
 */
@Mapper
public interface BaseVendorProductDao {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    BaseVendorProduct queryById(String vendorId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseVendorProduct> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseVendorProduct 实例对象
     * @return 对象列表
     */
    List<BaseVendorProduct> queryAll(BaseVendorProduct baseVendorProduct);

    /**
     * 新增数据
     *
     * @param baseVendorProduct 实例对象
     * @return 影响行数
     */
    int insert(BaseVendorProduct baseVendorProduct);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseVendorProduct> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BaseVendorProduct> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseVendorProduct> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BaseVendorProduct> entities);

    /**
     * 修改数据
     *
     * @param baseVendorProduct 实例对象
     * @return 影响行数
     */
    int update(BaseVendorProduct baseVendorProduct);

    /**
     * 通过产品编号删除
     *
     * @param
     * @return 影响行数
     */
    int deleteById(String vendorId);

    /**
     * 通过BaseVendorProductVo作为筛选条件查询
     *
     * @param baseVendorProductVo 实例对象
     * @return 对象列表
     */
    List<BaseVendorProductVo> queryAllBaseVendorProductVo(BaseVendorProductVo baseVendorProductVo);

}

