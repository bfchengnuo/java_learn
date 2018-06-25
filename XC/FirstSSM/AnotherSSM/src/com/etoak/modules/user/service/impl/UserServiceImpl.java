package com.etoak.modules.user.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etoak.modules.user.bean.User;
import com.etoak.modules.user.mapper.UserMapper;
import com.etoak.modules.user.service.UserService;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月22日 下午3:44:16
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Transactional
	public void add(User user) {
		user.setId(UUID.randomUUID().toString());
		user.setCreateTime(new Date());
		int result = userMapper.add(user);
		// int a = 1/0;
		if(result <= 0) {
			throw new RuntimeException("插入用户" + user.getUsername() + "失败！");
		}
	}

}
