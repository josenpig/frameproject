package com.xingji.frameproject.controller;

import com.xingji.frameproject.mybatis.entity.BaseCharge;
import com.xingji.frameproject.service.BaseChargeService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BaseCharge)表控制层
 *
 * @author makejava
 * @since 2021-06-01 17:01:50
 */
@RestController
@RequestMapping("baseCharge")
public class BaseChargeController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private BaseChargeService baseChargeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseCharge selectOne(Integer id) {
        return this.baseChargeService.queryById(id);
    }

    /**
     * 查询所有负责人
     * @return 单条数据
     */
    @GetMapping("selectAll")
    public AjaxResponse selectAll() {
        List<BaseCharge> productShowList=baseChargeService.findAllCharge();
        System.out.println("+charges:"+productShowList);
        return AjaxResponse.success(productShowList);
    }

}
