package com.bfchengnuo.sbdemo.controller;

import com.bfchengnuo.sbdemo.domain.User;
import com.bfchengnuo.sbdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 冰封承諾Andy on 2018/1/16.
 * Web MVC 模式
 */
@RestController
public class UserController {
    private final UserRepository userRepository;

    /**
     * 使用构造器的方式来进行初始化，这样能保证不能修改和提早的完成初始化
     * @param userRepository
     */
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name) {
        User user = new User();
        user.setName(name);

        if (userRepository.save(user)){
            System.out.printf("用户 %s 保存成功 \n", user);
        }
        return user;
    }
}
