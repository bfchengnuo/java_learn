package com.bfchengnuo.controller;

import org.springframework.stereotype.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bfchengnuo.bean.User;
import com.bfchengnuo.service.UserService;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月26日 下午9:36:12
 */
@Controller
public class UserController {
	@Reference
	private UserService userService; // 获取远程服务代理

	public void add() {
		User user = new User();
		user.setUsername("loli");
		user.setPassword("123456");
		String result = userService.add(user); // 执行远程方法
		System.out.println(result); // 显示调用结果
	}
}
