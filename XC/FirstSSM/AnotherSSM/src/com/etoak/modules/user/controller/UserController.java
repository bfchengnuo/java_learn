package com.etoak.modules.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.commons.utils.JsonResult;
import com.etoak.modules.user.bean.User;
import com.etoak.modules.user.service.UserService;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月22日 下午3:28:09
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult add(User user) {
		try {
			userService.add(user);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new JsonResult(500, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(500, e.getMessage());
		}
		return new JsonResult(200, "新增用户 " + user.getUsername() + " 成功！");
	}
}
