package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.SysMenuService;
import com.xingji.frameproject.service.SysRoleService;
import com.xingji.frameproject.service.SysUserService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.util.MD5;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.SaleConditionPageVo;
import com.xingji.frameproject.vo.SystemPowerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
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
    SysUserService sus;
    @Resource
    SysMenuService sms;
    @Resource
    SysRoleService srs;
    /**
     * 角色管理 查询角色所有的菜单及某个角色所具有菜单
     * @param roleId  角色id
     * @return vo
     */
    @PostMapping("/findmenus")
    public AjaxResponse findmenus(Integer roleId){
        SystemPowerVo vo=new SystemPowerVo();
        //查询角色独有菜单
        List<SysMenu> usermenu = sms.rolemenu(roleId);
        //查询所有菜单
        List<SysMenu> menulist=sms.rolemenu(0);
        List<SysMenu> allmenu = menulist.stream().filter(m -> m.getParentId() == 0).map(
                (m) -> {
                    m.setChildMenu(getChildrens(m, menulist));
                    return m;
                }
        ).collect(Collectors.toList());
        vo.setAllmenus(allmenu);
        vo.setMenus(usermenu);
        return AjaxResponse.success(vo);
    }
    /**
     * 角色管理 通过实体类修改角色菜单
     * @param change  json对象
     * @return vo
     */
    @PostMapping("/changerolemenu")
    public AjaxResponse changerolemenu(@RequestBody String change){
        JSONObject jsonObject = JSONObject.parseObject(change);
        String menus = jsonObject.getString("menus");//菜单
        List<SysMenu> sysMenu=JSONArray.parseArray(menus, SysMenu.class);
        String roles = jsonObject.getString("roles");//角色
        SysRole sysRole = JSON.parseObject(roles, SysRole.class);
        sysRole.setUpdatedBy(String.valueOf(sus.queryUserIdByUserName(sysRole.getUpdatedBy())));
        sysRole.setUpdateTime(new Date());
        //判断菜单数据是否被修改
        if (sysMenu.size()==0){
            if(sysRole.getDelFlag()==-1 && srs.findtfhasuser(sysRole.getRoleId()).size()==0){//判断角色新是否存在用户
                return AjaxResponse.success(srs.update(sysRole));
            }else {
                return AjaxResponse.success(false);
            }
        }else {
            srs.deletemenus(sysRole.getRoleId());//先删除原有的数据
            List<SysRoleMenu> lists=new ArrayList<>();
            for (int i=0;i<sysMenu.size();i++){
                SysRoleMenu sysRoleMenu=new SysRoleMenu();
                sysRoleMenu.setRoleId(sysRole.getRoleId());
                sysRoleMenu.setMenuId(sysMenu.get(i).getMenuId());
                lists.add(sysRoleMenu);
            }
            srs.insertBatch(lists);
        }
        return AjaxResponse.success(srs.update(sysRole));
    }
    /**
     * 角色管理 添加角色
     * @param add json对象
     * @return vo
     */
    @PostMapping("/addnewrole")
    public AjaxResponse addnewrole(@RequestBody String add){
        JSONObject jsonObject = JSONObject.parseObject(add);
        String menus = jsonObject.getString("menus");//菜单
        List<SysMenu> sysMenu=JSONArray.parseArray(menus, SysMenu.class);
        String roles = jsonObject.getString("roles");//角色
        SysRole sysRole = JSON.parseObject(roles, SysRole.class);
        sysRole.setFounder(String.valueOf(sus.queryUserIdByUserName(sysRole.getFounder())));
        sysRole.setFoundTime(new Date());
        sysRole.setDelFlag(0);
        //新增角色
        srs.insert(sysRole);
        //新增角色菜单
        List<SysRoleMenu> lists=new ArrayList<>();
        for (int i=0;i<sysMenu.size();i++){
            SysRoleMenu sysRoleMenu=new SysRoleMenu();
            sysRoleMenu.setRoleId(sysRole.getRoleId());
            sysRoleMenu.setMenuId(sysMenu.get(i).getMenuId());
            lists.add(sysRoleMenu);
        }
        return AjaxResponse.success(srs.insertBatch(lists));
    }
    /**
     * 用户管理 查询某个用户所具有的角色
     * @return 菜单信息
     */
    @PostMapping("/findroles")
    public AjaxResponse findroles(String username){
        SysUser loginuser = sus.login(username);
        //查询用户具有的角色
        List<SysRole> roles=srs.userhasrole(loginuser.getUserId());
        return AjaxResponse.success(roles);
    }
    /**
     * 用户管理 查询用户所有的角色
     * @return 菜单信息
     */
    @PostMapping("/findallroles")
    public AjaxResponse findallroles(){
        //查询所有角色
        List<SysRole> allroles=srs.queryAll(new SysRole());
        return AjaxResponse.success(allroles);
    }
    /**
     * 用户管理 添加用户
     * @param add json对象
     * @return vo
     */
    @PostMapping("/addnewuser")
    public AjaxResponse addnewuser(@RequestBody String add) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("user");//用户
        SysUser user=JSON.parseObject(one, SysUser.class);
        String roles = jsonObject.getString("roles");//角色
        List<SysRole> sysRole = JSONArray.parseArray(roles, SysRole.class);
        user.setFounder(String.valueOf(sus.queryUserIdByUserName(user.getFounder())));
        user.setFoundTime(new Date());
        user.setDelFlag(0);
        user.setUserPass(MD5.getEncryptedPwd("a123456"));
        //新增用户
        sus.insert(user);
        //新增用户角色
        List<SysUserRole> lists=new ArrayList<>();
        for (int i=0;i<sysRole.size();i++){
            SysUserRole sysUserRole=new SysUserRole();
            sysUserRole.setUserId(user.getUserId());
            sysUserRole.setRoleId(sysRole.get(i).getRoleId());
            lists.add(sysUserRole);
        }
        return AjaxResponse.success(sus.insertBatch(lists));
    }
    /**
     * 用户管理 修改用户数据
     * @param change json对象
     * @return 是否成功
     */
    @PostMapping("/changeuesr")
    public AjaxResponse changeuesr(@RequestBody String change) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        JSONObject jsonObject = JSONObject.parseObject(change);
        String one = jsonObject.getString("user");//用户
        SysUser user=JSON.parseObject(one, SysUser.class);
        String roles = jsonObject.getString("roles");//角色
        List<SysRole> sysRole = JSONArray.parseArray(roles, SysRole.class);
        user.setUpdateTime(new Date());
        user.setUpdatedBy(String.valueOf(sus.queryUserIdByUserName(user.getUpdatedBy())));
        if(user.getUserPass()!=null){
            user.setUserPass(MD5.getEncryptedPwd(user.getUserPass()));
        }
        //修改用户
        if(sysRole.size()==0){
            return AjaxResponse.success(sus.update(user));
        }else {
        //修改用户角色
        sus.deleteroles(user.getUserId());//先删除原有的数据
        List<SysUserRole> lists=new ArrayList<>();
        for (int i=0;i<sysRole.size();i++){
            SysUserRole sysUserRole=new SysUserRole();
            sysUserRole.setUserId(user.getUserId());
            sysUserRole.setRoleId(sysRole.get(i).getRoleId());
            lists.add(sysUserRole);
        }
        sus.insertBatch(lists);
        return AjaxResponse.success(sus.update(user));
        }
    }
    /**
     * 菜单管理查询所有菜单
     * @return 菜单信息
     */
    @PostMapping("/findmenulist")
    public AjaxResponse findmenulist(){
        List<SysMenu> menulist=sus.usermenu(0);
        List<SysMenu> treemenu = menulist.stream().filter(m -> m.getParentId() == 0).map(
                (m) -> {
                    m.setChildMenu(getChildrens(m, menulist));
                    return m;
                }
        ).collect(Collectors.toList());
        return AjaxResponse.success(treemenu);
    }
    /**
     * 通过菜单实体类修改菜单
     * @param sysMenu 菜单
     * @param username  用户名
     * @return 菜单信息
     */
    @PostMapping("/changemenu/{username}")
    public AjaxResponse change(@RequestBody SysMenu sysMenu, @PathVariable("username")String username){
        boolean tf=sms.change(sysMenu);
        if(tf==false){
            return AjaxResponse.success(false);
        }else {
            SysUser loginuser = sus.login(username);
            List<SysMenu> usermenu = sus.usermenu(loginuser.getUserId());
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
     * 条件分页查询用户信息
     * @param conditionpage 查询条件
     * @return 菜单信息
     */
    @PostMapping("/conditionpageuser")
    public AjaxResponse conditionpageuser(@RequestBody String conditionpage){
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件
        SysUser user = JSON.parseObject(condition, SysUser.class);
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<SysUser> users=sus.queryAll(user);
        for(int i=0;i<users.size();i++){
            users.get(i).setFounder(sus.queryById(Integer.valueOf(users.get(i).getFounder())).getUserName());
            users.get(i).setUpdatedBy(sus.queryById(Integer.valueOf(users.get(i).getUpdatedBy())).getUserName());
        }
        map.put("total",page.getTotal());
        map.put("rows",users);
        return AjaxResponse.success(map);
    }
    /**
     * 条件分页查询角色信息
     * @param conditionpage 查询条件
     * @return 菜单信息
     */
    @PostMapping("/conditionpagerole")
    public AjaxResponse conditionpagerole(@RequestBody String conditionpage){
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件
        SysRole role = JSON.parseObject(condition, SysRole.class);
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<SysRole> users=srs.queryAll(role);
        for(int i=0;i<users.size();i++){
            users.get(i).setFounder(sus.queryById(Integer.valueOf(users.get(i).getFounder())).getUserName());
            users.get(i).setUpdatedBy(sus.queryById(Integer.valueOf(users.get(i).getUpdatedBy())).getUserName());
        }
        map.put("total",page.getTotal());
        map.put("rows",users);
        return AjaxResponse.success(map);
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
