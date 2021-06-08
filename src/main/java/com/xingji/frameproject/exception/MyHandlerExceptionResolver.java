package com.xingji.frameproject.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

//@Component
@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Map<String ,String >map=new HashMap<>();
        log.debug("MyHandlerExceptionResolver***********************************************");
        map.put("error",ex.getMessage()+" 这是我们的消息");
        ModelAndView mv=new ModelAndView("error",map);

        return mv;
    }
}
