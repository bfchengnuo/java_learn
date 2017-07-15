package com.bfchengnuo.domain;

/**
 * Created by 冰封承諾Andy on 2017/7/14.
 */
public class Loli {
    private String desc;
    private User mUser;

    @Override
    public String toString() {
        return mUser.getName() + "::" + desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }
}
