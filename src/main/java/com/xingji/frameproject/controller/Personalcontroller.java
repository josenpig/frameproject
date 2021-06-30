package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.SysMenu;
import com.xingji.frameproject.mybatis.entity.SysUser;
import com.xingji.frameproject.service.SysUserService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.util.MD5;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("personal")
public class Personalcontroller {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private SysUserService sus;
    @Autowired
    private UserController sysuserContorller;
    /**
     * 个人中心 修改用户数据
     *
     * @param change json对象
     * @return 是否成功
     */
    @Log("个人中心 修改用户数据")
    @PostMapping("/changeuesr")
    public AjaxResponse changeuesr(@RequestBody String change) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        JSONObject jsonObject = JSONObject.parseObject(change);
        String one = jsonObject.getString("user");//用户
        SysUser user = JSON.parseObject(one, SysUser.class);
        user.setUpdateTime(new Date());
        user.setUpdatedBy(String.valueOf(sus.queryUserIdByUserName(user.getUpdatedBy())));
        user.setUserPass(null);
        //修改用户
        System.out.println(">>>>>>>>>>>>" + sus.update(user));
        List<SysMenu> usermenu = sus.usermenu(user.getUserId());
        //获取父菜单
        List<SysMenu> treemenu = usermenu.stream().filter(m -> m.getParentId() == 0).map(
                (m) -> {
                    m.setChildMenu(sysuserContorller.getChildrens(m, usermenu));
                    return m;
                }
        ).collect(Collectors.toList());
        UserVo userVo = new UserVo();
        userVo.setUser(sus.login(user.getUserName()));
        System.out.println("userIcon:"+ userVo.getUser().getUserIcon());
        userVo.setMenus(treemenu);
        String token=jwtTokenUtil.generateToken(user.getUserName(),user.getUserId()+"");
        userVo.setToken(token);
        userVo.setValidate(true);
        return AjaxResponse.success(userVo);

    }

    /**
     * 修改密码
     * @param
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @Log("修改密码")
    @GetMapping("/changeuesrPass")
    public AjaxResponse changeuesrPass(String userName,String userPass,String updatedBy) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        SysUser user =new SysUser();
        System.out.println("-----userName:"+userName);
        System.out.println("-----userPass:"+userPass);
        System.out.println("-----updateBy:"+updatedBy);
        user.setUserId(sus.queryUserIdByUserName(userName));
        user.setUpdateTime(new Date());
        user.setUpdatedBy(updatedBy.toString());
        if (userPass != null) {
            user.setUserPass(MD5.getEncryptedPwd(userPass));
        }
        return AjaxResponse.success(sus.update(user));
    }
    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return
     */
    @Log("获取用户信息")
    @GetMapping("/getUsermessage")
    public AjaxResponse getUsermessage(String username) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("-------------" + username);
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);
        List<SysUser> user = sus.queryAll(sysUser);
        user.get(0).getUserPass();
        map.put("user", user);
        System.out.println("-------------" + user);
        return AjaxResponse.success(map);
    }

    @PostMapping("/upload")
    public AjaxResponse upload(@RequestBody String userIcon) {
        JSONObject jsonObject = JSONObject.parseObject(userIcon);
        String one = jsonObject.getString("Icon");//用户
        System.out.println("22222222222222222" + one);
        SysUser user = JSON.parseObject(one, SysUser.class);
        System.out.println("33333333" + user);
        user.setUpdateTime(new Date());
        user.setUpdatedBy(String.valueOf(sus.queryUserIdByUserName(user.getUpdatedBy())));
        System.out.println("<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>" + sus.update(user));
        return AjaxResponse.success(sus.update(user));
    }

    /**
     * 验证密码
     * @param userPass
     * @param userName
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @GetMapping("/ispass")
    public AjaxResponse ispass(String userPass, String userName) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        SysUser loginuser = sus.login(userName);
        if (!MD5.validPassword(userPass, loginuser.getUserPass())) {
            return AjaxResponse.success("密码错误");
        }
        return AjaxResponse.success("密码正确");
    }
}

