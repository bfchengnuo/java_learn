package com.bfchengnuo.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by 冰封承諾Andy on 2017/7/22.
 * 后置通知，使用注解更简单方便
 */
public class MyAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("我是后置通知----如果有异常那就不会执行了");
    }
}
