package com.xingji.frameproject.aspect;

import com.alibaba.fastjson.JSONObject;
import com.xingji.frameproject.mybatis.entity.SysUser;
import com.xingji.frameproject.service.OperationlogService;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.Operationlog;


import com.xingji.frameproject.service.SysUserService;
import com.xingji.frameproject.util.JacksonUtil;
import com.xingji.frameproject.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * 系统日志：切面处理类
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private OperationlogService operationlogService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private SysUserService us;
    private static String username;
    @Pointcut("execution(public * com.xingji.frameproject.controller.UserController.gologinByPhone(..))")
    public void getuserByPhone(){
        System.out.println("loginByphone");
    }
    @Before("getuserByPhone()")
    public void doBefore1(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("REQUEST：" + joinPoint.getArgs().toString());
        String xx=JSONObject.toJSONString(joinPoint.getArgs());
        System.out.println(">>>>>>>>>>>"+xx);
        int index=xx.indexOf("["+'"');
        int index2=xx.indexOf('"'+","+'"');
        String cha=xx.substring(index+2,index2);
        Integer userid=us.queryUserIdByPhone(cha);
        //用户名
        String  userName=us.queryUserNameByUserId(userid);
        username = userName;
    }
    /**
     * 定义切点l
     */
    @Pointcut("execution(public * com.xingji.frameproject.controller.UserController.login(..))")
    public void getuserByUserName(){
        System.out.println("loginByusername");
        // this.
    }

    /**
     * 用户名密码登录时
     * @param joinPoint
     */
    @Before("getuserByUserName()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("REQUEST：" + joinPoint.getArgs().toString());
        String xx=JSONObject.toJSONString(joinPoint.getArgs());
        int index=xx.indexOf("userName");
        int index2=xx.indexOf('"'+","+'"'+"userPass");
        String cha=xx.substring(index+11,index2);
        username = cha;
    }
    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(com.xingji.frameproject.annotation.Log)")
    public void logPoinCut() {

    }
    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) throws UnknownHostException {
        System.out.println("切面。。。。。");
        //保存日志
        Operationlog operationlog = new Operationlog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        //获取操作
        Log myLog = method.getAnnotation(Log.class);
        if (myLog != null) {
            String value = myLog.value();
            operationlog.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        operationlog.setMethod(className + "." + methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params=null;
        try {
            params = JacksonUtil.obj2json(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        operationlog.setParams(params);
        //获取操作时间
        operationlog.setCreatetime(new Date());
        //获取用户名
        operationlog.setOperator(username);
        //获取用户ip地址
        String ip= InetAddress.getLocalHost().getHostAddress();
        operationlog.setIpaddress(ip);
        //调用service保存SysLog实体类到数据库
        operationlogService.InsertLog(operationlog);
    }

}