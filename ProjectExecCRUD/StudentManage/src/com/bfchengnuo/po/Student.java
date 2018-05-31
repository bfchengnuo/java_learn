package com.bfchengnuo.po;

import java.util.Date;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年5月23日 下午3:47:03
 */
public class Student {
	private Integer id;
	private String name;
	private Integer age;
	private Date birth;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", birth=" + birth + "]";
	}

}
