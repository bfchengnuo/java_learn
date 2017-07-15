package com.bfchengnuo.domain;

/**
 * Created by 冰封承諾Andy on 2017/7/14.
 * 简单测试类
 */
public class User {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Name -->" + name + "Age -->" + age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
