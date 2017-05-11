package com.bfchengnuo.strategy;

/**
 * Created by 冰封承諾Andy on 5/10/2017.
 * 测试类，使用方法
 */
public class Main {
    public static void main(String[] args) {
        MakeFriends makeFriends;

        makeFriends = new MakeFriends(new StandardLoli());
        makeFriends.start();

        System.out.println("---------------------------------");

        makeFriends = new MakeFriends(new LegitimateLoli());
        makeFriends.start();
    }
}
