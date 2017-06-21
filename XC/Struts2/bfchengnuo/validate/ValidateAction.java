package com.bfchengnuo.validate;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 * Created by 冰封承諾Andy on 2017/6/20.
 * 测试验证框架
 */
public class ValidateAction extends ActionSupport {
    private static final long serialVersionUID = -6874431547620130396L;

    private String name;
    private Integer age;
    private String pwd;
    private String confirmPwd;

    public String reg() {
        return SUCCESS;
    }

    @SkipValidation
    public String toRegView() {
        return "toView";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }
}
