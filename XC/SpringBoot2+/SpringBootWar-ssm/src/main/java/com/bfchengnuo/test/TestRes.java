package com.bfchengnuo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月29日 下午8:43:29
 */
@Component
@PropertySource(value = "classpath:jdbc.properties", encoding = "UTF-8", ignoreResourceNotFound=false)
@ConfigurationProperties(prefix = "sp.datasource")
public class TestRes {
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	@Value("${url:NaN}")
	private String test;
	
	public void log() {
		System.out.println("------------->" + driverClassName);
		System.out.println("------------->" + url);
		System.out.println("------------->" + username);
		System.out.println("------------->" + password);
		System.out.println("------------->" + test);
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
}
