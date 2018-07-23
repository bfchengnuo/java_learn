package com.etoak.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.etoak.spring.SpringConfig;
import com.etoak.spring.Student;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月27日 下午5:05:00
 */
public class SpringTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Student stu = (Student) context.getBean("student");
		
		System.out.println(stu);
	}

}
