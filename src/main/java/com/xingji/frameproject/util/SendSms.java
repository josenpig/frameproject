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
    private String accessKeyId="LTAI4Fgzwq2Q6LfhWhpRJQL8";
    private String accessSecret="kw2ekRkeTrncBBq8ZVplflZq19QTls";
    private String SignName="宇义商城";
    //获取验证码
    public String SendCode(String phone){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request=new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName",SignName);
        request.putQueryParameter("TemplateCode","SMS_199771688");//快速登录
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
    //发送注册成功通知
    public void notice(String phone,String roles){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request=new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName",SignName);
        request.putQueryParameter("TemplateCode","SMS_218549025");//注册--超管注册
        request.putQueryParameter("TemplateParam", "{\"phone\":"+phone+",\"roles\":"+roles+"}");
        System.out.println("{\"phone\":"+phone+",\"roles\":"+roles+"}");
        try {
            CommonResponse response=client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ClientException e) {
            //e.printStackTrace();
        }
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
