package com.xingji.frameproject.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
/**
* @author: 顾渊白
* @date: 2021/6/30 8:51
* @Description:  阿里云短信接口
* @Param: phone 手机号
* @return: code 验证码
*/
@Component
public class SendSms {
    Map<String,String> map=new HashMap<>();
    public String SendCode(String phone,int i){
        String accessKeyId=null;
        String accessSecret=null;
        String SignName="星际供销链";
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request=new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName",SignName);
        if (i==1){
            request.putQueryParameter("TemplateCode","SMS_199600531");//注册
        }else if(i==2){
            request.putQueryParameter("TemplateCode","SMS_199771688");//快速登录
        }else if(i==3){
            request.putQueryParameter("TemplateCode","SMS_199791543");//修改手机号
        }else if(i==4){
            request.putQueryParameter("TemplateCode","SMS_201651159");//修改密码
        }
        String code=smsCode(phone);
        map.put(phone,code);
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
        trydel(map,phone);//启动线程
        try {
            CommonResponse response=client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ClientException e) {
            //e.printStackTrace();
        }
        return code;
    }

    //创建验证码
    public static String smsCode(String phone){
        String random=(int)((Math.random()*9+1)*100000)+"";
        System.out.print("验证码:"+random);
        return random;
    }

    //创建线程存储已发送的验证码
    public static void trydel(Map map,String phone){
        System.out.println("当前所有有效验证码"+map);
        //1分钟后删除验证码
        final Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(map.get(phone)+"------验证码已失效");
                map.remove(phone);
                timer.cancel();
            }
        },60*1000);
    }
    //判断验证码是否过期 以及是否有效
    public String isphonecode(String phone) {
        if (map.size() >0 && map.containsKey(phone)){
            return map.get(phone);
        }else {
            return null;
        }
    }
}
