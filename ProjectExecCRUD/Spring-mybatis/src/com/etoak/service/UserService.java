package com.etoak.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.etoak.bean.User;
import com.etoak.mapper.UserMapper;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月14日 下午5:49:11
 */
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	// 注入编程式事务
	@Autowired
	private TransactionTemplate template;
	
	/*
	 * 事务的传播特性 propagation
	 * 	1. REQUIRED（默认）		当前有事务使用当前事务，不存在创建新的事务
	 * 	2. SUPPORTS				支持当前事务（当前有事务使用当前事务），没有事务以非事务方式运行
	 * 	3. MANDATORY			支持当前事务，事务不存在 抛异常
	 * 
	 * 	4. REQUIRES_NEW			支持事务，事务存在，挂起（暂停）事务，并创建一个新事务；事务不存在，创建新事务
	 * 	5. NOT_SUPPORTED		以非事务运行，事务存在，挂起当前事务
	 * 	6. NEVER				以非事务存在，事务存在，抛异常
	 * 
	 * 	7. NESTED				支持当前事务，在嵌套事务中执行 保存点 操作		
	 * 
	 * 只读属性 readOnly
	 * 	默认为 false ，true 为只读，一般应用在查询语句上
	 * 
	 * 超时时间 timeout
	 * 	默认 -1 为无限制，单位为秒
	 * 
	 * 遇到什么异常回滚 rollbackForClassName={""}
	 * 	默认是遇到运行时异常时回滚 RuntimeException
	 * 
	 * 遇到什么异常回滚 rollbackFor={xxx.class}
	 * 	和上面一样，这次是传 class
	 * 
	 * 遇到某些异常不回滚 noRollbackFor
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false, timeout=-1)
	public int add(User user) {
		int result = userMapper.add(user);
		// int a = 1/0;
		return result;
	}
	
	/*
	 * *******Test********
	 * 
	 * 在同一个类中，方法嵌套调用，最外层方法加了事务就表示所有方法都有事务；最外层没加，就算都没加
	 * 
	 */
	@Transactional
	public void save1() {
		User user1 = new User();
		user1.setId(UUID.randomUUID().toString());
		user1.setUsername("Pning");
		userMapper.add(user1);
		
		save2();
	}
	
	@Transactional
	public void save2() {
		User user1 = new User();
		user1.setId(UUID.randomUUID().toString());
		user1.setUsername("Nxuan");
		userMapper.add(user1);
		int a = 1/0;
	}
	
	// 编程式事务
	public void save3() {
		template.execute((status) -> {
			// TransactionStatus - status 参数：事务开启、回滚等状态
			User user = new User();
			user.setId(UUID.randomUUID().toString());
			user.setUsername("Nxuan");
			
			int x = 1/0;
			
			return userMapper.add(user);
		});
	}
}
