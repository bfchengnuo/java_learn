package com.bfchengnuo.bean;

import java.io.Serializable;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月26日 下午4:18:53
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

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

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}
