package com.bfchengnuo.test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bfchengnuo.bean.Fack;
import com.bfchengnuo.dao.FackDao;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年7月2日 上午11:14:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=com.bfchengnuo.config.JdbcConfig.class)
// @ContextConfiguration(locations="classpath:beans.xml")
public class FackDaoTest {

	@Autowired
	private FackDao dao;
	
	@Autowired
	private JdbcTemplate tmp;
	
	/*
	@Test
	public void testAdd() {
		Fack f = new Fack();
		f.setUsername("PN");
		f.setPassword("123456");
		int result = dao.add(f);
		System.out.println(result);
	}*/
	
	@Test
	public void testQueryCount() {
		Integer result = tmp.queryForObject("select count(*) from fack", Integer.class);
		System.out.println(result);
	}
	
	@Test
	public void testQueryC() {
		int count = dao.queryCount("l");
		System.out.println(count);
	}
	
	@Test
	public void testQuerySome() {
		List<Fack> list = dao.querySome(null, 0, 2);
		
		list.forEach(System.out::println);
	}
	
	@Test
	public void testCheck() {
		boolean check = dao.check("ll", "test");
		System.out.println(check);
	}
	
	@Test
	public void testQueryById() {
		Fack fack = dao.queryById(2);
		System.out.println(fack);
	}
	
	@Test
	public void testAdd() {
		Fack f = new Fack();
		f.setUsername("PN");
		f.setPassword("123456");
		boolean flag = dao.add(f);
		System.out.println(flag);
	}
	
	
	@Test
	public void testLike() {
		String sql = "select * from fack where username like concat('%', ? , '%')";
		Map<String, Object> map = tmp.queryForMap(sql, "ll");
		// yes
		System.out.println(map);
	}
	
	@Test
	public void show() {
		BigDecimal b = new BigDecimal("123456");
		System.out.println(Integer.parseInt(b.toString()));
		
	}
}
