package com.bfchengnuo.command;

/**
 * Created by 冰封承諾Andy on 2017/9/14.
 */
public class SimpleTest {
    public static void main(String[] args) {
        LoliconControl control = new LoliconControl();  // 调用者
        LovelyLoli loli = new LovelyLoli();   // 具体执行者
        // 创建命令
        LoliDanceCommand command = new LoliDanceCommand(loli);

        control.setCommand(command); // 设置命令
        control.action();  // 调用命令
    }
}
