package com.bfchengnuo.service.impl;

import com.bfchengnuo.bean.User;
import com.bfchengnuo.service.UserService;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年7月6日 上午10:26:31
 */
public class UserServiceImpl implements UserService {

	@Override
	public boolean checkUser(User user) {
		System.out.println("服务被调用.....");
		System.out.println("用户信息：" + user.getUsername() + "\t" + user.getPassword());
		if ("loli".equals(user.getUsername()) && "123".equals(user.getPassword())) {
			return true;
		}
		return false;
	}

}
