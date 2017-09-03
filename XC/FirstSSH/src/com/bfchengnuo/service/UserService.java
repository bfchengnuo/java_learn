package com.bfchengnuo.service;

import com.bfchengnuo.entity.UsersEntity;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2017/8/31.
 */
public interface UserService {
    void save(UsersEntity entity);

    void update(UsersEntity entity);

    UsersEntity find(String userName);

    void delete(String... userName);

    List list();
}
