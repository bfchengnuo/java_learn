package com.mooc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mooc.domain.Person;

/**
 * 控制层
 */

@Controller
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping(value = "/index")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("username", "你好，Freemarker！");
		mv.addObject("personList", preparePersonList());
		return mv;
	}
	
	public List<Person> preparePersonList(){
		List<Person> list = new ArrayList<Person>();
		for(int i = 0 ;i < 5; i++){
			Person item = new Person();
			item.setName("用户 " + i);
			item.setAge(20 + i);
			list.add(item);
		}
		return list;
	}
	
}
