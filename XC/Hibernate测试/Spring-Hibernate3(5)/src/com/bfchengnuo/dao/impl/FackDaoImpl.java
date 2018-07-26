package com.bfchengnuo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bfchengnuo.bean.Fack;
import com.bfchengnuo.dao.FackDao;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年7月3日 上午11:23:01
 */
@Repository
public class FackDaoImpl implements FackDao {
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public boolean add(Fack fack) {
		Serializable id = ht.save(fack);
		return id != null;
	}

	@Override
	public boolean delete(int id) {
		ht.delete(new Fack(id));
		return true;
	}

	@Override
	public boolean update(Fack fack) {
		ht.update(fack);
		return true;
	}

	@Override
	public int queryCount(String username) {
		String hql = "select id from Fack";
		if (username != null && !"".equals(username)) {
			hql += " where username like '%" + username + "%'";
		}
		List<Object> list = ht.find(hql);
		return list.size();
	}

	@Override
	public Fack queryById(int id) {
		return ht.get(Fack.class, id);
	}

	@Override
	public List<Fack> querySome(String username, int start, int max) {
		@SuppressWarnings("unchecked")
		List<Fack> list = ht.execute((session) -> {
			String hql = "from Fack where username like ?";
			Query query = session.createQuery(hql);
			if (username != null && !"".equals(username)) {
				query.setString(0, "%" + username + "%");
			}else {
				query.setString(0, "%");
			}
			query.setFirstResult(start);
			query.setMaxResults(max);
			return query.list();
		});
		return list;
		
		/*
		ht.setMaxResults(start + max);
		List<Object> list = ht.find(hql);
		List<Fack> newList = new ArrayList<>(list.size());
		for (int i = start; i < list.size(); i++) {
			newList.add((Fack) list.get(i));
		}
		return newList;
		*/
	}

	@Override
	public boolean check(String username, String password) {
		String hql = "from Fack where username=? and password=?";
		List<Object> list = ht.find(hql, username, password);
		return list != null && list.size() != 0;
	}

}
