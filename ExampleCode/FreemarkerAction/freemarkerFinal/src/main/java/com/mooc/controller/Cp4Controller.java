package com.mooc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 取值（插值）
 */
@Controller
@RequestMapping("/")
public class Cp4Controller {
	
	@RequestMapping(value = "/cp4")
	public ModelAndView cp4(){
		ModelAndView mv = new ModelAndView("cp4");
		return mv;
	}
	
}
