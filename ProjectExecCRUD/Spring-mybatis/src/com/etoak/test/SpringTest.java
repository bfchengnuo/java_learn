package com.etoak.test;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.etoak.bean.User;
import com.etoak.service.UserService;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月14日 下午5:55:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SpringTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void show() {
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setUsername("Loli");
		user.setPassword("123456");
		user.setNickname("喵帕斯");
		user.setEmail("ll@yousa.tech");
		user.setTel("110");
		user.setState(1);
		user.setCreateTime(new Date());
		
		int result = userService.add(user);
		System.out.println("影响的行数：" + result);
	}
	
	@Test
	public void testSave() {
		userService.save1();
	}
	
	@Test
	public void testSave3() {
		userService.save3();
	}
}
