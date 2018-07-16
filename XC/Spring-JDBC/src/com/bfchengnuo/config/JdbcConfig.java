package com.bfchengnuo.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年7月2日 上午11:34:40
 */
@Configuration
@ComponentScan(basePackages = "com.bfchengnuo")
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {

	@Value("${jdbc.url:NaN}")
	private String url;

	@Autowired
	private Environment env;

	// 解决 @Value 占位符问题
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public DataSource dataSource() {
		System.out.println(url);
		System.out.println(env.getProperty("jdbc.url"));

		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/1803?useSSL=true&characterEncoding=utf-8");
		ds.setUsername("loli");
		ds.setPassword("12358");
		return ds;
	}

	@Bean
	public JdbcTemplate jt(DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
