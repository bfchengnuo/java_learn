package com.bfchengnuo.action;

import com.bfchengnuo.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 冰封承諾Andy on 2017/8/30.
 */
public class UserAction extends ActionSupport {
    private UserService userService;


    public String execute() throws Exception {
        ActionContext.getContext().put("userList",userService.list());
        return "list";
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
