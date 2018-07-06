package com.bfchengnuo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bfchengnuo.client.service.User;
import com.bfchengnuo.client.service.UserService;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年7月6日 上午11:24:25
 */
public class CXFSpringTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us = (UserService) ac.getBean("userService");
		
		User u = new User();
		u.setUsername("ttest");
		u.setPassword("123");
		
		System.out.println(us.checkUser(u));
	}

}
