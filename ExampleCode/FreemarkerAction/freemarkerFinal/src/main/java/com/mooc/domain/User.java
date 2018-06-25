package com.mooc.domain;

import java.util.Date;

public class User {

	//ID
	private Long id;
	
	//名字
	private String name;
	
	//年龄
	private Integer age;

	//出生年月
	private Date birthday;
	
	//工资
	private Double salary;
	
	//是否是好人
	private Boolean good;
	
	//简介
	private String brief;
	
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getGood() {
		return good;
	}

	public void setGood(Boolean good) {
		this.good = good;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}
	
}
