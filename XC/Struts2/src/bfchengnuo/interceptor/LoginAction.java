package com.bfchengnuo.interceptor;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by 冰封承諾Andy on 2017/6/12.
 * 自定义过滤器之--登陆
 */
public class LoginAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = -9178854276859257157L;

    private String name;
    // 实现了 SessionAware 接口，以此来获得 session 中的 map
    private Map<String,Object> sessionMap;

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = map;
    }

    // 简单模拟，只要用户名对就通过
    public String reg() {
        if ("admin".equalsIgnoreCase(name)) {
            sessionMap.put("username", name);
        }else {
            return LOGIN;
        }
        return SUCCESS;
    }

    public String toView() {
        return "toLoginView";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
