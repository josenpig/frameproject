package com.xingji.frameproject.aspect;

import com.alibaba.fastjson.JSON;
import com.xingji.frameproject.service.OperationlogService;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.Operationlog;


import com.xingji.frameproject.util.IpAdrressUtil;
import com.xingji.frameproject.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

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
    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(com.xingji.frameproject.annotation.Log)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
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
        String params = JSON.toJSONString(args);
        operationlog.setParams(params);

        operationlog.setCreatetime(new Date());
        //获取用户名

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if ((authentication instanceof AnonymousAuthenticationToken)) {
//            log.debug(authentication.getName());
            operationlog.setOperator("suan");
//        }

        //获取用户ip地址
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        operationlog.setIpaddress(IpAdrressUtil.getIpAdrress(request));

        //调用service保存SysLog实体类到数据库
        operationlogService.InsertLog(operationlog);
    }

}