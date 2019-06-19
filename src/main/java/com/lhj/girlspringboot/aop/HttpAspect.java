package com.lhj.girlspringboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @program: girl-springboot
 * @description: 记录http请求
 * @author: lhj
 * @create: 2019-03-27 23:32
 **/
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    //声明一个切入点  避免重复代码
    @Pointcut("execution(public * com.lhj.girlspringboot.controller.GirlController.*(..))")
    public void log(){
    }

    //方法执行之前去之执行的操作
    @Before("log()")
    public void doStart(JoinPoint joinPoint){
        logger.info("方法执行前");
        ServletRequestAttributes attributes =(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}","类路径:"+joinPoint.getSignature().getDeclaringTypeName() + ",类方法:" + joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    //方法执行完毕以后去执行的操作
    @After("log()")
    public void doOver(){
        logger.info("22222");
    }

    //后置返回通知
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
