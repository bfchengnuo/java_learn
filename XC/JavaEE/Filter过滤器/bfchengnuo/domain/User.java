package com.bfchengnuo.domain;

/**
 * Created by 冰封承諾Andy on 5/12/2017.
 * 登陆用户的实体类
 */
public class User {
    private String username;
    private String pwd;

    public User(String username) {
    }

    public User(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
