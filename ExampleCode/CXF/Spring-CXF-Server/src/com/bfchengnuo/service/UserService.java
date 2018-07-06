package com.bfchengnuo.service;

import javax.jws.WebService;

import com.bfchengnuo.bean.User;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年7月6日 上午10:25:45
 */
@WebService
public interface UserService {
	boolean checkUser(User user);
}
