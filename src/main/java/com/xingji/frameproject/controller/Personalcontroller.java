package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.SysUser;
import com.xingji.frameproject.service.SysUserService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.util.MD5;
import com.xingji.frameproject.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
@RequestMapping("personal")
public class Personalcontroller {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    SysUserService sus;
    /**
     * 个人中心 修改用户数据
     * @param change json对象
     * @return 是否成功
     */
    @Log("修改个人信息")
    @PostMapping("/changeuesr")
    public AjaxResponse changeuesr(@RequestBody String change) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        JSONObject jsonObject = JSONObject.parseObject(change);
        String one = jsonObject.getString("user");//用户
        SysUser user= JSON.parseObject(one, SysUser.class);
        //String roles = jsonObject.getString("roles");//角色
        //List<SysRole> sysRole = JSONArray.parseArray(roles, SysRole.class);
        user.setUpdateTime(new Date());
        user.setUpdatedBy(String.valueOf(sus.queryUserIdByUserName(user.getUpdatedBy())));
        if(user.getUserPass()!=null){
            user.setUserPass(MD5.getEncryptedPwd(user.getUserPass()));
        }
        //修改用户
         System.out.println(">>>>>>>>>>>>"+sus.update(user));
            return AjaxResponse.success(sus.update(user));
        }

    /**
     * 获取用户信息
     * @param username 用户名
     * @return
     */
    @GetMapping("/getUsermessage")
    public AjaxResponse getUsermessage(String username){
        Map<String,Object> map=new HashMap<>();
        System.out.println("-------------"+username);
        SysUser sysUser=new SysUser();
        sysUser.setUserName(username);
        List<SysUser> user= sus.queryAll(sysUser);
        user.get(0).getUserPass();
        map.put("user",user);
        System.out.println("-------------"+user);
        return AjaxResponse.success(map);
    }
    @Log("修改个人头像")
    @PostMapping("/upload")
    public AjaxResponse upload(@RequestBody String userIcon){
        JSONObject jsonObject = JSONObject.parseObject(userIcon);
        String one = jsonObject.getString("Icon");//用户
        System.out.println("22222222222222222"+one);
        SysUser user= JSON.parseObject(one, SysUser.class);
        System.out.println("33333333"+user);
        user.setUpdateTime(new Date());
        user.setUpdatedBy(String.valueOf(sus.queryUserIdByUserName(user.getUpdatedBy())));
        System.out.println("<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>"+sus.update(user));
        return AjaxResponse.success(sus.update(user));
    }
    }

