package com.bfchengnuo.start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bfchengnuo.bean.User;
import com.bfchengnuo.controller.UserController;
import com.bfchengnuo.service.UserService;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月26日 下午5:53:43
 */
public class ConsumerTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
		context.start();

		UserController uc = (UserController) context.getBean("userController");
		uc.add();
	}

	public static void main2(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
		context.start();
		UserService userService = (UserService) context.getBean("userService"); // 获取远程服务代理
		User user = new User();
		user.setUsername("loli");
		user.setPassword("123456");
		String result = userService.add(user); // 执行远程方法
		System.out.println(result); // 显示调用结果
	}
}
