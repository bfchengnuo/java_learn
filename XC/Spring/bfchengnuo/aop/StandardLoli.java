package com.bfchengnuo.aop;

/**
 * Created by 冰封承諾Andy on 2017/7/21.
 * 目标对象，也就是被代理对象
 * 每一个方法都是一个连接点；如果进行了切人就是切入点
 */
public class StandardLoli implements Loli {
    private String flag;

    @Override
    public String speak(String name) {
        return name + "::" + flag;
    }

    @Override
    public void hug() {
        System.out.println("要抱抱");
        // int a = 1/0;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
