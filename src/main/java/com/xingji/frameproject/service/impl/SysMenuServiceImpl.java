package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.SysMenu;
import com.xingji.frameproject.mybatis.dao.SysMenuDao;
import com.xingji.frameproject.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysMenu)表服务实现类
 *
 * @author makejava
 * @since 2021-05-15 15:33:39
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuDao sysMenuDao;

}
