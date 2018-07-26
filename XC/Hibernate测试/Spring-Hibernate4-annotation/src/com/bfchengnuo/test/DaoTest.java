package com.bfchengnuo.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import com.bfchengnuo.bean.Fack;
import com.bfchengnuo.dao.FackDao;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年7月3日 下午7:13:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class DaoTest {

	@Autowired
	private FackDao dao;
	
	@Test
	public void testAdd() {
		Fack fack = new Fack();
		fack.setUsername("h-anno");
		fack.setPassword(DigestUtils.md5DigestAsHex("123".getBytes()));
		dao.add(fack);
	}
	
	@Test
	public void testQueryById() {
		Fack fack = dao.queryById(7);
		System.out.println(fack);
	}
	
	@Test
	public void testQueryCount() {
		System.out.println(dao.queryCount(null));
	}
	
	@Test
	public void testQuery() {
		List<Fack> list = dao.querySome(null, 1, 5);
		list.forEach(System.out::println);
	}
	
	@Test
	public void testCheck() {
		System.out.println(dao.check("hibernate", "0123456"));
	}
	
	@Test
	public void testDel() {
		dao.delete(7);
	}
}
