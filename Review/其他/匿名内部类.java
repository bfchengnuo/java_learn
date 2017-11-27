package com.bfchengnuo.internal;

/**
 * 匿名内部类的前提：继承某个类或者实现某个接口
 * 一般需要实现的方法不会超过三个，否则阅读性极差
 * 特殊的，因为所有的类都继承 object
 */
public class Main {
    public static void main(String[] args) {
        // 但是不能用 object 去接收（这就相当于隐式的向上转型了）
        new Object(){
            public void show(){
                System.out.println("haha");
            }
        }.show();
    }
}
