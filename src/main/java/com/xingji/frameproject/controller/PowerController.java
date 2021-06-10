package com.xingji.frameproject.controller;

import com.xingji.frameproject.mybatis.entity.SysMenu;
import com.xingji.frameproject.mybatis.entity.SysUser;
import com.xingji.frameproject.service.SysMenuService;
import com.xingji.frameproject.service.SysUserService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/***
 * @author: 顾渊白
 * @date: 2021/6/10 10:50
 * @version 1.0
 */
@RestController
@RequestMapping("/systempower")
public class PowerController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    SysUserService us;
    @Resource
    SysMenuService sms;

    @PostMapping("/findmenulist")
    public AjaxResponse findmenulist(){
        List<SysMenu> menulist=us.usermenu(0);
        List<SysMenu> treemenu = menulist.stream().filter(m -> m.getParentId() == 0).map(
                (m) -> {
                    m.setChildMenu(getChildrens(m, menulist));
                    return m;
                }
        ).collect(Collectors.toList());
        return AjaxResponse.success(treemenu);
    }
    @PostMapping("/changemenu/{username}")
    public AjaxResponse change(@RequestBody SysMenu sysMenu, @PathVariable("username")String username){
        boolean tf=sms.change(sysMenu);
        if(tf==false){
            return AjaxResponse.success(false);
        }else {
            SysUser loginuser = us.login(username);
            List<SysMenu> usermenu = us.usermenu(loginuser.getUserId());
            //获取父菜单
            List<SysMenu> treemenu = usermenu.stream().filter(m -> m.getParentId() == 0).map(
                    (m) -> {
                        m.setChildMenu(getChildrens(m, usermenu));
                        return m;
                    }
            ).collect(Collectors.toList());
            return AjaxResponse.success(treemenu);
        }
    }
    /**
     * 递归查询子菜单
     * @param root 根菜单
     * @param all  所有菜单
     * @return 菜单信息
     */
    private List<SysMenu> getChildrens(SysMenu root, List<SysMenu> all) {
        List<SysMenu> children = all.stream().filter(m -> {
            return Objects.equals(m.getParentId(), root.getMenuId());
        }).map(
                (m) -> {
                    m.setChildMenu(getChildrens(m, all));
                    return m;
                }
        ).collect(Collectors.toList());
        return children;
    }
}
