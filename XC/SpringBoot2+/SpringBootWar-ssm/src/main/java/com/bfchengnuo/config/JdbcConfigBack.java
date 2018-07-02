package com.bfchengnuo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月29日 下午8:56:50
 */
@PropertySource(value = "classpath:jdbc.properties", encoding = "UTF-8", ignoreResourceNotFound=false)
@ConfigurationProperties(prefix = "sp.datasource")
public class JdbcConfigBack {
	private String driverClassName;
	private String url;
	private String username;
	private String password;
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
}
