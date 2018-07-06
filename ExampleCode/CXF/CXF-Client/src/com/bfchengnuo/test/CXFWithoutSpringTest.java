package com.bfchengnuo.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.bfchengnuo.client.service.User;
import com.bfchengnuo.client.service.UserService;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年7月6日 上午11:06:32
 */
public class CXFWithoutSpringTest {

	public static void main(String[] args) {
		// 得到调用 webserver 的代理工厂
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress("http://localhost:8080/Spring-CXF-Server/ws/user");
		factory.setServiceClass(UserService.class);
		UserService service = (UserService) factory.create();
		
		User u = new User();
		u.setUsername("loli");
		u.setPassword("123");
		boolean b = service.checkUser(u);
		System.out.println(b);
		
	}

}
