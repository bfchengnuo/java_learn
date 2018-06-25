package com.mooc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mooc.domain.User;

/**
 * 取值（插值）
 */
@Controller
@RequestMapping("/")
public class Cp1Controller {
	
	@RequestMapping(value = "/cp1")
	public ModelAndView cp1(){
		ModelAndView mv = new ModelAndView("cp1");
		mv.addObject("intVar", 100);
		mv.addObject("longVar", 100000L);
		mv.addObject("stringVar", "我是字符串");
		mv.addObject("doubleVar", 3.45d);
		mv.addObject("booleanVar", Boolean.TRUE);
		mv.addObject("dateVar", new Date());
		
		User user = new User();
		user.setName("freemarker");
		mv.addObject("userObj", user);
		
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("python");
		list.add("nodejs");
		mv.addObject("myList", list);

		Map<String,String> map = new HashMap<String,String>();
		map.put("java", "你好Java");
		map.put("python", "你好python");
		map.put("nodejs", "你好nodejs");
		mv.addObject("map",map);
		
		return mv;
	}
	
}
