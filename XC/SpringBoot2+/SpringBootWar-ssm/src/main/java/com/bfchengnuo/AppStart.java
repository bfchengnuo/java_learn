package com.bfchengnuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.bfchengnuo.config.JdbcConfigBack;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月29日 下午4:27:33
 */
@SpringBootApplication
@ComponentScan(basePackages="com.bfchengnuo")
// @EnableConfigurationProperties(JdbcConfigBack.class)
// @Import()
// @ImportResource(locations="classpath:xxx.xml")
public class AppStart {

	public static void main(String[] args) {
		SpringApplication.run(AppStart.class, args);
	}

}
