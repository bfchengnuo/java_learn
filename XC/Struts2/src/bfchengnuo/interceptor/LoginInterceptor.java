package com.bfchengnuo.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

/**
 * Created by 冰封承諾Andy on 2017/6/12.
 * 自定义拦截器
 */
public class LoginInterceptor implements Interceptor {
    private static final long serialVersionUID = 5175604343895716587L;

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Object action = actionInvocation.getAction();
        if (action instanceof LoginAction) {
            // 直接放行
            return actionInvocation.invoke();
        }

        Map<String, Object> sessionMap = actionInvocation.getInvocationContext().getSession();
        if (sessionMap.get("username") == null) {
            // 没有登陆，跳转到登陆
            return "login";
        } else {
            return actionInvocation.invoke();
        }
    }
}
