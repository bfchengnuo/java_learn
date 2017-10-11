package com.bfchengnuo.service;

import com.bfchengnuo.mapper.UserMapper;
import com.bfchengnuo.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 冰封承諾Andy on 2017/10/10.
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }
}
