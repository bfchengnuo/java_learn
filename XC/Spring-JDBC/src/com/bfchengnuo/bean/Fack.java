package com.bfchengnuo.bean;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年7月2日 上午11:47:47
 */
public class Fack {
	private Integer id;
	private String username;
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Fack [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
