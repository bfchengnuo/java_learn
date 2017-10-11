package com.bfchengnuo.mapper;

import com.bfchengnuo.pojo.User;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2017/10/9.
 */
public interface UserMapper {
    User queryUserById(Long id);

    List<User> queryUserList();
}
