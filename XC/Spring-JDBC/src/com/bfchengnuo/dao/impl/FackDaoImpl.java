package com.bfchengnuo.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bfchengnuo.bean.Fack;
import com.bfchengnuo.dao.FackDao;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年7月2日 上午11:12:59
 */
@Repository
public class FackDaoImpl implements FackDao {

	@Autowired
	private JdbcTemplate tmp;

	@Override
	public boolean add(Fack fack) {
		String sql = "insert into fack values(null,?,md5(?))";
		int result = tmp.update(sql, fack.getUsername(), fack.getPassword());
		return result > 0;
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from fack where id=?";
		int result = tmp.update(sql, id);
		return result > 0;
	}

	@Override
	public boolean update(Fack fack) {
		String sql = "update fack set username=?, password=md5(?) where id=?";
		int result = tmp.update(sql, fack.getUsername(), fack.getPassword(), fack.getId());
		return result > 0;
	}

	@Override
	public int queryCount(String username) {
		String sql = "select count(*) from fack";
		if (username != null && !"".equals(username)) {
			sql +=  " where username like concat('%', '" + username + "' ,'%')";
		}
		return tmp.queryForObject(sql, Integer.class);
	}

	@Override
	public Fack queryById(int id) {
		String sql = "select * from fack where id=?";
		return tmp.queryForObject(sql, (rs, index) -> {
			Fack f = new Fack();
			f.setId(rs.getInt("id"));
			f.setUsername(rs.getString("username"));
			f.setPassword(rs.getString("password"));
			return f;
		}, id);
	}

	@Override
	public List<Fack> querySome(String username, int start, int max) {
		String sql = "select * from fack";
		if (username != null && !"".equals(username)) {
			sql +=  " where username like concat('%', '" + username + "' ,'%')";
		}
		sql += " limit ?,?";
		
		List<Fack> list = tmp.query(sql, (rs, index) -> {
			Fack f = new Fack();
			f.setId(rs.getInt("id"));
			f.setUsername(rs.getString("username"));
			f.setPassword(rs.getString("password"));
			return f;
		}, start, max);
		
		return list;
	}

	@Override
	public boolean check(String username, String password) {
		String sql = "select id from fack where username=? and password=md5(?)";
		// queryForObject 返回为空会抛异常
		// Integer id = tmp.queryForObject(sql, Integer.class, username, password);
		List<Map<String,Object>> list = tmp.queryForList(sql, username, password);
		return list.size() != 0;
	}

	/*
	 * @Override public int add(Fack fack) { String sql =
	 * "insert into fack values(null,?,md5(?))"; return
	 * tmp.update(sql,fack.getUsername(),fack.getPassword()); }
	 */

}
