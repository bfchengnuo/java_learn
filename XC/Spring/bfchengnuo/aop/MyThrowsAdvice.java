package com.bfchengnuo.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by 冰封承諾Andy on 2017/7/22.
 * 异常通知
 * ThrowsAdvice 是个标记接口，可以手动添加点方法
 */
public class MyThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method m, Object[] os, Object target, Exception e) {
        // 出现异常自动调用此方法
        System.out.println("出异常了..."+e.getMessage());
    }

    // 简单点的可以使用下面的
    // public void afterThrowing(RemoteException ex) {
    //     // 出现异常自动调用此方法
    //     System.out.println("出异常了...");
    // }
}
