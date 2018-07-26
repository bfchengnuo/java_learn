package com.bfchengnuo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bfchengnuo.bean.Fack;
import com.bfchengnuo.dao.FackDao;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年7月3日 下午7:17:41
 */
@Repository
public class FackDaoImpl implements FackDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public boolean add(Fack fack) {
		Session session = sf.openSession();
		Serializable id = session.save(fack);
		return id != null;
	}

	@Override
	public boolean delete(int id) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(new Fack(id));
		tx.commit();
		return true;
	}

	@Override
	public boolean update(Fack fack) {
		Session session = sf.openSession();
		session.update(fack);
		return true;
	}

	@Override
	public int queryCount(String username) {
		Session session = sf.openSession();
		String hql = "select count(*) from Fack where username like ?";
		Query query = session.createQuery(hql);
		query.setString(0,"%" + ((username != null && !"".equals(username)?username:"")) + "%");
		Long count = (Long) query.uniqueResult();
		return count.intValue();
	}

	@Override
	public Fack queryById(int id) {
		Session session = sf.openSession();
		Fack f = (Fack) session.get(Fack.class, id);
		return f;
	}

	@Override
	public List<Fack> querySome(String username, int start, int max) {
		Session session = sf.openSession();
		String hql = "from Fack where username like ?";
		Query query = session.createQuery(hql);
		query.setString(0,"%" + ((username != null && !"".equals(username)?username:"")) + "%");
		query.setFirstResult(start);
		query.setMaxResults(max);
		List<Fack> list = query.list();
		return list;
	}

	@Override
	public boolean check(String username, String password) {
		Session session = sf.openSession();
		String hql = "from Fack where username=? and password=?";
		Query query = session.createQuery(hql);
		query.setString(0, username);
		query.setString(1, password);
		Object f = query.uniqueResult();
		return f != null;
	}

}
