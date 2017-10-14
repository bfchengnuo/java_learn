package com.bfchengnuo.firstspringboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 冰封承諾Andy on 2017/10/14.
 */
@Aspect
@Component
public class HttpAspect {
    public final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.bfchengnuo.firstspringboot.controller.GirlController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        LOGGER.info("url--->{}", request.getRequestURL());
        LOGGER.info("method--->{}", request.getMethod());
        LOGGER.info("ip--->{}", request.getRemoteAddr());

        LOGGER.info("class_method--->{}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        LOGGER.info("args--->{}", joinPoint.getArgs());
    }

    @AfterReturning(returning = "o", pointcut = "log()")
    public void doAfterReturning(Object o) {
        // 获取方法执行完后的返回值
        if (o != null) {
            LOGGER.info("response:{}", o);
        }
    }
}
