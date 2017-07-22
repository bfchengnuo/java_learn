package com.bfchengnuo.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by 冰封承諾Andy on 2017/7/21.
 * 编写通知 (使用 Spring 的前置通知)
 */
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {
    /**
     * 在被代理对象的前面执行
     * @param method 方法对象--被调用方法的方法名
     * @param objects 传入被调用方法的参数
     * @param o 目标对象（被代理对象）
     * @throws Throwable 异常
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        // 下面的代码就属于通知了
        System.out.println("Before...记录..." + method.getName());
    }
}
