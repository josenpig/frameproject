package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.SaleReturn;
import com.xingji.frameproject.mybatis.dao.SaleReturnDao;
import com.xingji.frameproject.service.SaleReturnService;
import com.xingji.frameproject.vo.SaleConditionPageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SaleReturn)表服务实现类
 *
 * @author makejava
 * @since 2021-05-30 19:06:41
 */
@Service("saleReturnService")
public class SaleReturnServiceImpl implements SaleReturnService {
    @Resource
    private SaleReturnDao saleReturnDao;

    /**
     * 通过ID查询单条数据
     *
     * @param returnId 主键
     * @return 实例对象
     */
    @Override
    public SaleReturn queryByIdVo(String returnId) {
        return this.saleReturnDao.queryByIdVo(returnId);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param returnId 主键
     * @return 实例对象
     */
    @Override
    public SaleReturn queryById(String returnId) {
        return this.saleReturnDao.queryById(returnId);
    }
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SaleReturn> queryAllByLimit(int offset, int limit) {
        return this.saleReturnDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param saleReturn 实例对象
     * @return 实例对象
     */
    @Override
    public SaleReturn insert(SaleReturn saleReturn) {
        this.saleReturnDao.insert(saleReturn);
        return saleReturn;
    }

    /**
     * 修改数据
     *
     * @param saleReturn 实例对象
     * @return 实例对象
     */
    @Override
    public SaleReturn update(SaleReturn saleReturn) {
        this.saleReturnDao.update(saleReturn);
        return this.queryById(saleReturn.getReturnId());
    }

    /**
     * 通过主键删除数据
     *
     * @param returnId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String returnId) {
        return this.saleReturnDao.deleteById(returnId) > 0;
    }
    @Override
    //@Cacheable(cacheNames = "allsaleorder")
    public List<SaleReturn> conditionpage(SaleConditionPageVo order) {
        return this.saleReturnDao.conditionpage(order);
    }
}
