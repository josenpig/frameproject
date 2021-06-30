package com.xingji.frameproject.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.Message1;

import com.xingji.frameproject.service.MessageService;
import com.xingji.frameproject.service.SysUserService;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.messageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private MessageService service;
    @Autowired
    private SysUserService sus;

    /**
     * 查询所有未删除如订单审批单（包括已读未读）
     * @param currentPage
     * @param pagesize
     * @param userName
     * @return
     */
    @Log("查询所有未删除如订单审批单（包括已读未读）")
    @GetMapping("allm")
    public AjaxResponse getmessage(Integer currentPage, Integer pagesize,String userName){
        System.out.println("currentPage:"+currentPage+"pagesize:"+pagesize+"userId"+userName);
        Map<String, Object> map = new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pagesize);
        List<Message1> list=service.selecctByRecver(sus.queryUserIdByUserName(userName));
        List<messageVo> messageVo=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            String status="";
            if(list.get(i).getStatus()==0) {
             status="未读";
            }else{
            status="已读";
        }
        String mid="";
            if(list.get(i).getMid()==0){
                mid="待审批";
            }else if(list.get(i).getMid()==1){
                mid="审批通过";
            }else if(list.get(i).getMid()==-1){
                mid="审批未通过";
            }
            messageVo.add(new messageVo(
                    mid
                    ,sus.queryUserNameByUserId(list.get(i).getRecver())
                    ,status
                    ,sus.queryUserNameByUserId(list.get(i).getSender())
                    ,list.get(i).getOrdertype()
                    ,list.get(i).getOrderid()
                    ,list.get(i).getSendtime()));
//            messageVo.get(i).setMid(list.get(i).getMid());
//            messageVo.get(i).setRecver(sus.queryUserNameByUserId(list.get(i).getRecver()));

//            messageVo.get(i).setSender(sus.queryUserNameByUserId(list.get(i).getSender()));
//            messageVo.get(i).setOrdertype(list.get(i).getOrdertype());
//            messageVo.get(i).setOrderid(list.get(i).getOrderid());
//            messageVo.get(i).setSendtime(list.get(i).getSendtime());
        }
        map.put("total",page.getTotal());
        map.put("rows",messageVo);
        return AjaxResponse.success(map);
    }


    @Log("消息标记已读")
    @GetMapping("/isread")
    //标记已读
    public AjaxResponse isread( String userName,String orderid){
        System.out.println("userId:"+userName+"orderid:"+orderid);
        List<Message1> list=service.updateisreadByorderid(sus.queryUserIdByUserName(userName),orderid);
        return AjaxResponse.success();
    }

    @Log("修改所有消息为已读状态")
    //标记已读所有
    @GetMapping("/isreadAll")
    public AjaxResponse isreadAll(Integer currentPage, Integer pagesize,String userName){
        System.out.println("currentPage:"+currentPage+"pagesize:"+pagesize+"userId:"+userName);
        List<String> orderid=service.selectstatusis1(sus.queryUserIdByUserName(userName));
        for(int i=0;i<orderid.size();i++){
            service.updateisreadAll(orderid.get(i));
        }
        return AjaxResponse.success();
    }

    @Log("消息标记为读")
    //标记未读
    @GetMapping("/notread")
    public AjaxResponse notread(String userName,String orderid){
        System.out.println("userId:"+userName+"orderid:"+orderid);

        List<Message1> list=service.updatenotreadByorderid(sus.queryUserIdByUserName(userName),orderid);
        return AjaxResponse.success();
    }


    //查看已读
    @Log("查看已读")
    @GetMapping("/qureyisread")
    public AjaxResponse qureyisread(Integer currentPage, Integer pagesize,String userName){
        System.out.println("currentPage:"+currentPage+"pagesize:"+pagesize+"userId"+userName);
        Map<String, Object> map = new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pagesize);
        List<Message1> list=service.selecctByRecverandstatusis1(sus.queryUserIdByUserName(userName));
        List<messageVo> messageVo=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            String mid="";
            if(list.get(i).getMid()==0){
                mid="待审批";
            }else if(list.get(i).getMid()==1){
                mid="审批通过";
            }else if(list.get(i).getMid()==-1){
                mid="审批未通过";
            }
            messageVo.add(new messageVo(

                    mid
                    ,sus.queryUserNameByUserId(list.get(i).getRecver())
                    ,"已读"
                    ,sus.queryUserNameByUserId(list.get(i).getSender())
                    ,list.get(i).getOrdertype()
                    ,list.get(i).getOrderid()
                    ,list.get(i).getSendtime()));
//            messageVo.get(i).setMid(list.get(i).getMid());
//            messageVo.get(i).setRecver(sus.queryUserNameByUserId(list.get(i).getRecver()));

//            messageVo.get(i).setSender(sus.queryUserNameByUserId(list.get(i).getSender()));
//            messageVo.get(i).setOrdertype(list.get(i).getOrdertype());
//            messageVo.get(i).setOrderid(list.get(i).getOrderid());
//            messageVo.get(i).setSendtime(list.get(i).getSendtime());
        }
        map.put("total",page.getTotal());
        map.put("rows",messageVo);
        return AjaxResponse.success(map);
    }

    @Log("查看未读")
    //查看未读
    @GetMapping("/qureynotread")
    public AjaxResponse qureynotread(Integer currentPage, Integer pagesize,String userName){
        System.out.println("currentPage:"+currentPage+"pagesize:"+pagesize+"userId"+userName);
        Map<String, Object> map = new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pagesize);
        List<Message1> list=service.selecctByRecverandstatusis0(sus.queryUserIdByUserName(userName));
        List<messageVo> messageVo=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            String mid="";
            if(list.get(i).getMid().equals(0)){
                mid="待审批";
            }else if(list.get(i).getMid().equals(1)){
                mid="审批通过";
            }else if(list.get(i).getMid().equals(-1)){
                mid="审批未通过";
            }
            messageVo.add(new messageVo(
                    mid
                    ,sus.queryUserNameByUserId(list.get(i).getRecver())
                    ,"未读"
                    ,sus.queryUserNameByUserId(list.get(i).getSender())
                    ,list.get(i).getOrdertype()
                    ,list.get(i).getOrderid()
                    ,list.get(i).getSendtime()));
//            messageVo.get(i).setMid(list.get(i).getMid());
//            messageVo.get(i).setRecver(sus.queryUserNameByUserId(list.get(i).getRecver()));

//            messageVo.get(i).setSender(sus.queryUserNameByUserId(list.get(i).getSender()));
//            messageVo.get(i).setOrdertype(list.get(i).getOrdertype());
//            messageVo.get(i).setOrderid(list.get(i).getOrderid());
//            messageVo.get(i).setSendtime(list.get(i).getSendtime());
        }
        map.put("total",page.getTotal());
        map.put("rows",messageVo);
        return AjaxResponse.success(map);
    }
    //查看所有
    public AjaxResponse qureyAll(){
        return null;
    }
}
