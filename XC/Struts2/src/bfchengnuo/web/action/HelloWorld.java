package com.bfchengnuo.web.action;

import com.bfchengnuo.domain.User;

/**
 * Created by 冰封承諾Andy on 2017/6/3.
 * 入门测试程序
 */
public class HelloWorld {
    private String name;
    private String age;
    // Action 中的 javabean
    // 不用起 mUser 这样的名字，因为属性后 getMUser 这样不符合规范；不用小写一个字母开头
    private User user;

    public HelloWorld() {
        System.out.println("实例化啦！！");
    }

    public String execute() {
        System.out.println("Hello World");
        System.out.println(user.getName());
        return "success";
    }

    public String save() {
        System.out.println("save method");
        System.out.println(name + "----" + age);
        return "save";
    }

    public String hug() {
        System.out.println("hug method");

        return "test";
    }

    public String main() {
        System.out.println("test methodName,an...execute");

        return "success";
        // return "test";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
