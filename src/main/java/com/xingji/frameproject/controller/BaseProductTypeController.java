package com.xingji.frameproject.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.BaseDepot;
import com.xingji.frameproject.mybatis.entity.BaseProductType;
import com.xingji.frameproject.mybatis.entity.SysMenu;
import com.xingji.frameproject.service.BaseProductTypeService;
import com.xingji.frameproject.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * (BaseProductType)表控制层
 *
 * @author makejava
 * @since 2021-06-15 10:00:17
 */
@RestController
@RequestMapping("baseProductType")
public class BaseProductTypeController {
    /**
     * 服务对象
     */
    @Resource
    private BaseProductTypeService baseProductTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseProductType selectOne(Integer id) {
        return this.baseProductTypeService.queryById(id);
    }

    /**
     * 查询所有产品分类信息
     * @return 产品集合
     */
    @GetMapping("/findProType")
    public AjaxResponse findAllProduct(){
        BaseProductType baseProductType=new BaseProductType();
        List<BaseProductType> usermenu = baseProductTypeService.queryAll(baseProductType);
        //获取父菜单
        List<BaseProductType> treemenu = usermenu.stream().filter(m -> m.getProductTypeParentId() == 0).map(
                (m) -> {
                    m.setChildren(getChildrens(m, usermenu));
                    return m;
                }
        ).collect(Collectors.toList());
        return AjaxResponse.success(treemenu);
    };

    /**
     * 递归查询子菜单
     * @param root 根菜单
     * @param all  所有菜单
     * @return 菜单信息
     */
    private List<BaseProductType> getChildrens(BaseProductType root, List<BaseProductType> all) {
        List<BaseProductType> children = all.stream().filter(m -> {
            return Objects.equals(m.getProductTypeParentId(), root.getId());
        }).map(
                (m) -> {
                    m.setChildren(getChildrens(m, all));
                    return m;
                }
        ).collect(Collectors.toList());
        return children;
    }
}
