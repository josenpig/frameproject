package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.BaseOpening;
import com.xingji.frameproject.mybatis.dao.BaseOpeningDao;
import com.xingji.frameproject.service.BaseOpeningService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BaseOpening)表服务实现类
 *
 * @author makejava
 * @since 2021-05-28 08:59:41
 */
@Service("baseOpeningService")
public class BaseOpeningServiceImpl implements BaseOpeningService {
    @Resource
    private BaseOpeningDao baseOpeningDao;

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @Override
    public BaseOpening queryById() {
        return this.baseOpeningDao.queryById();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseOpening> queryAllByLimit(int offset, int limit) {
        return this.baseOpeningDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baseOpening 实例对象
     * @return 实例对象
     */
    @Override
    public BaseOpening insert(BaseOpening baseOpening) {
        this.baseOpeningDao.insert(baseOpening);
        return baseOpening;
    }

    /**
     * 修改数据
     *
     * @param baseOpening 实例对象
     * @return 实例对象
     */
    @Override
    public BaseOpening update(BaseOpening baseOpening) {
        this.baseOpeningDao.update(baseOpening);
        return this.queryById();
    }

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    @Override
    public boolean deleteById() {
        return this.baseOpeningDao.deleteById() > 0;
    }
    /**
     * 通过商品id查询库存信息
     *
     * @return list
     */
    @Override
    public List<BaseOpening> finddepot(String productId){
        return this.baseOpeningDao.finddepot(productId);
    }
    /**
     * 通过产品及仓库 减预计库存
     *
     * @return 是否成功
     */
    @Override
    public boolean expectreduce(String productId, String depotName, int expectNumber){
        return this.baseOpeningDao.expectreduce(productId,depotName,expectNumber);
    }
    /**
     * 通过产品及仓库 减当前实际库存
     *
     * @return 是否成功
     */
    @Override
    public boolean productereduce(String productId, String depotName, int product_number){
        return this.baseOpeningDao.productereduce(productId,depotName,product_number);
    }
    /**
     * 通过产品及仓库 加预计库存
     *
     * @return 是否成功
     */
    @Override
    public boolean expectadd(String productId, String depotName, int expectNumber){
        return this.baseOpeningDao.expectadd(productId,depotName,expectNumber);
    }
    /**
     * 通过产品及仓库 加当前实际库存
     *
     * @return 是否成功
     */
    @Override
    public boolean producteadd(String productId, String depotName, int product_number){
        return this.baseOpeningDao.producteadd(productId,depotName,product_number);
    }
}
