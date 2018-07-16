package com.bfchengnuo.dao;

import java.util.List;

import com.bfchengnuo.bean.Fack;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年7月2日 上午11:12:23
 */
public interface FackDao {
	// int add(Fack fack);
	
	boolean add(Fack fack);
	boolean delete(int id);
	boolean update(Fack fack);
	int queryCount(String username);
	Fack queryById(int id);
	List<Fack> querySome(String username, int start, int max);
	boolean check(String username, String password);
}
