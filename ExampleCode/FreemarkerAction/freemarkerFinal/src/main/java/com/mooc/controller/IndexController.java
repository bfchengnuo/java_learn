package com.mooc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 控制层
 */
@Controller
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping(value = "/index")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
}
