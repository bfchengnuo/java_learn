package com.bfchengnuo.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 冰封承諾Andy on 2017/6/11.
 * 测试处理表单的重复提交
 */
public class TokenAction extends ActionSupport {
    private static final long serialVersionUID = 8281147629456397148L;

    private String name;

    public String reg() {
        System.out.println("name---->" + name);
        return "success";
    }

    public String toReg() {
        return "regView";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
