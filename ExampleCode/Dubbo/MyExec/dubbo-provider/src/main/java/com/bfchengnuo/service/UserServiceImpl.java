package com.bfchengnuo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.bfchengnuo.bean.User;

/**
 * 生产者提供服务，实现接口
 * @author Kerronex
 * @version 创建时间：2018年6月26日 下午4:27:03
 */
@Service
public class UserServiceImpl implements UserService {

	public String add(User user) {
		System.out.println("生产者接收消息....");
		System.out.println(user);
		return "生产者响应的消息 <---> " + user.getUsername();
	}

}
