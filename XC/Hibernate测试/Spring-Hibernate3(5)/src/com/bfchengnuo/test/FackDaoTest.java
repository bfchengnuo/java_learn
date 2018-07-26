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
 * @version 创建时间：2018年7月3日 上午11:24:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class FackDaoTest {
	
	@Autowired
	private FackDao dao;
	
	@Test
	public void testMd5() {
		String md5DigestAsHex = DigestUtils.md5DigestAsHex("123".getBytes());
	}
	
	@Test
	public void testAdd() {
		Fack f = new Fack();
		f.setUsername("h-test");
		f.setPassword(DigestUtils.md5DigestAsHex("123".getBytes()));
		dao.add(f);
	}
	
	@Test
	public void testQueryCount() {
		int count = dao.queryCount("l");
		System.out.println(count);
	}
	
	@Test
	public void testQuery() {
		List<Fack> list = dao.querySome(null, 1, 3);
		list.forEach(System.out::println);
	}
}
