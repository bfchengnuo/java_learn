package com.bfchengnuo.firstspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication：Spring Boot项目的核心注解，主要目的是开启自动配置
@SpringBootApplication
public class FirstSpringBootApplication {

	public static void main(String[] args) {
		// 启动 SpringBoot 所必须的入口
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}
}
