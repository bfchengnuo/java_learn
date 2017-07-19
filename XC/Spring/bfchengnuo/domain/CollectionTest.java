package com.bfchengnuo.domain;

import java.util.List;
import java.util.Map;

/**
 * Created by 冰封承諾Andy on 2017/7/19.
 * 使用 spring 装载 bean 中的集合元素
 * 后期使用注解更方便
 */
public class CollectionTest {
    private String[] strs;
    private List<User> mUsers;
    private Map<String,User> mMap;

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public List<User> getUsers() {
        return mUsers;
    }

    public void setUsers(List<User> users) {
        mUsers = users;
    }

    public Map<String, User> getMap() {
        return mMap;
    }

    public void setMap(Map<String, User> map) {
        mMap = map;
    }
}
