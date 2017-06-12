package com.bfchengnuo.web.action;

/**
 * Created by 冰封承諾Andy on 2017/6/11.
 * 测试 执行等待拦截器
 */
public class WaitAction {

    // 模拟耗时操作
    public String execute() {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
