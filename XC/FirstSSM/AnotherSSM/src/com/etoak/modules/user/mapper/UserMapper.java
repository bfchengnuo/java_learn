package com.etoak.modules.user.mapper;

import org.springframework.stereotype.Repository;

import com.etoak.modules.user.bean.User;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月22日 下午3:32:20
 */
@Repository
public interface UserMapper {
	int add(User user);
}
