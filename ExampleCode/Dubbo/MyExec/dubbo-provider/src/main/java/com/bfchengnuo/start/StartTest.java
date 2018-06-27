package com.bfchengnuo.start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月26日 下午5:01:35
 */
public class StartTest {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
		context.start();
		System.in.read(); // 按任意键退出
	}
}
