package com.xingji.frameproject.controller;

import com.xingji.frameproject.mybatis.entity.Loginin;
import com.xingji.frameproject.mybatis.entity.SysMenu;
import com.xingji.frameproject.mybatis.entity.SysRole;
import com.xingji.frameproject.mybatis.entity.SysUser;
import com.xingji.frameproject.service.LogininService;
import com.xingji.frameproject.service.SysRoleService;
import com.xingji.frameproject.service.SysUserRoleService;
import com.xingji.frameproject.service.SysUserService;
import com.xingji.frameproject.util.JacksonUtil;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.util.SendSms;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.HttpResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/***
 * @author: 顾渊白
 * @date: 2021/5/14 16:06
 * @version 1.0
 */
@Slf4j
@RestController
@EnableSwagger2
@Api(description = "用户Api")
public class UserController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    SendSms sendSms;
    @Autowired
    SysUserService us;
    @Autowired
    LogininService logininService;
    @Autowired
    SysUserRoleService sysUserRoleService;
    @Autowired
    SysRoleService sysRoleService;

    @PostMapping("/login")
    @ApiOperation(value = "用户账户登录",produces = "application/json")
    public AjaxResponse login(HttpSession session, @RequestBody SysUser user) {
        SysUser loginuser = us.login(user.getUserName());
        if (loginuser == null) {
            return AjaxResponse.success("账户不存在");
        } else {
            if(loginuser.getUserState()!=0){
                return AjaxResponse.success("账户已停用！请联系超级管理员！");
            }else if (!user.getUserPass().equals(loginuser.getUserPass())) {
                return AjaxResponse.success("密码错误");
            } else {
                Integer userid=us.queryUserIdByUserName(loginuser.getUserName());
                Loginin loginin=new Loginin();
                //通过用户id获取角色id
                List<Integer> roleId =  sysUserRoleService.queryRoleIdbyUserId(userid);
                //通过角色id获取角色名
                List<String> roleNames=new ArrayList<String>();
                for (int i=0;i<roleId.size();i++) {
                  String roleName= sysRoleService.queryRoleNameByroleId(roleId.get(i));
                  roleNames.add(roleName);
                }
                loginin.setLogintime(new Date());
                loginin.setOperator(loginuser.getUserName());
                loginin.setTypeofoperator(roleNames + "");
                //插入一条登录日志
                logininService.insertLoginin(loginin);
                List<SysMenu> usermenu = us.usermenu(loginuser.getUserId());
                //获取父菜单
                List<SysMenu> treemenu = usermenu.stream().filter(m -> m.getParentId() == 0).map(
                        (m) -> {
                            m.setChildMenu(getChildrens(m, usermenu));
                            return m;
                        }
                ).collect(Collectors.toList());
                UserVo userVo = new UserVo();
                userVo.setUser(loginuser);
                userVo.setMenus(treemenu);
                String token=jwtTokenUtil.generateToken(loginuser.getUserName(),loginuser.getUserId()+"");
                userVo.setToken(token);
                userVo.setValidate(true);
                return AjaxResponse.success(userVo);
            }
        }
    }


    @PostMapping("/login/getcode/{phone}")
    @ApiOperation(value = "获取验证码",produces = "application/json")
    public AjaxResponse gologin(@PathVariable("phone") String phone) {
        String code=sendSms.SendCode(phone,2);
        return AjaxResponse.success(code);
    }

    @PostMapping("/login/fast")
    @ApiOperation(value = "用户手机号登录",produces = "application/json")
    public AjaxResponse gologin(String phone,String code) {
        SysUser loginuser = us.gologin(phone);
        if (loginuser == null) {
            return  AjaxResponse.success("手机号不存在");
        } else {
            if(loginuser.getUserState()!=0){
                return  AjaxResponse.success("账户已停用！请联系超级管理员！");
            }else if (sendSms.isphonecode(phone)==null || !sendSms.isphonecode(phone).equals(code)) {
                return  AjaxResponse.success("手机号与验证码不匹配或已失效！");
            } else {
                Integer userid=us.queryUserIdByUserName(loginuser.getUserName());
                List<SysMenu> usermenu = us.usermenu(loginuser.getUserId());
                //获取父菜单
                List<SysMenu> treemenu = usermenu.stream().filter(m -> m.getParentId() == 0).map(
                        (m) -> {
                            m.setChildMenu(getChildrens(m, usermenu));
                            return m;
                        }
                ).collect(Collectors.toList());
                UserVo userVo = new UserVo();
                userVo.setUser(loginuser);
                userVo.setMenus(treemenu);
                String token=jwtTokenUtil.generateToken(loginuser.getUserName(),loginuser.getUserId()+"");
                userVo.setToken(token);
                userVo.setValidate(true);
                return AjaxResponse.success(userVo);
            }
        }
    }
    @GetMapping("/roleusers/{id}")
    public AjaxResponse roleusers(@PathVariable("id") Integer id){
        List<SysUser> sysUsers=us.roleusers(id);
        return AjaxResponse.success(sysUsers);
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