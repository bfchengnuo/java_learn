package com.bfchengnuo.service;

import com.bfchengnuo.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 冰封承諾Andy on 5/12/2017.
 * 处理登陆的业务层
 */
public class BusinessService {
    private static List<User> list = new ArrayList<>();
    static {
        list.add(new User("admin", "123"));
        list.add(new User("loli", "123"));
    }

    public User login(String username, String pwd) {
        for (User user : list) {
            if (user.getUsername().equals(username) && user.getPwd().equals(pwd)) {
                return user;
            }
        }
        return null;
    }

    public User find(String username) {
        for (User user : list) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
