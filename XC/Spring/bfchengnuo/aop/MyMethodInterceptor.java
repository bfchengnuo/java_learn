package com.bfchengnuo.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by 冰封承諾Andy on 2017/7/22.
 * 环绕通知测试
 * 关于顺序： 前置/环绕前  谁先执行并不确定，所以说 后置/环绕后  谁先执行也是不确定的
 *          但是确定的是 两者之间才会执行原本的方法体
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕通知---方法内执行前");
        // 执行方法内的代码
        Object proceed = methodInvocation.proceed();
        System.out.println("环绕通知---方法内执行后");
        return proceed;
    }
}
