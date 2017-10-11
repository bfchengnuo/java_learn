package com.bfchengnuo.controller;

import com.bfchengnuo.pojo.User;
import com.bfchengnuo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 冰封承諾Andy on 2017/10/10.
 */
@RequestMapping("user")
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("users")
    public String toUsers() {
        return "users";
    }

    @RequestMapping("getList")
    public ModelAndView getUserList() {
        ModelAndView mv = new ModelAndView("users");
        List<User> users = userService.queryUserList();
        mv.addObject("userList",users);
        return mv;
    }
}
