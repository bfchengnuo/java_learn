package com.mooc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 取值（插值）
 */
@Controller
@RequestMapping("/")
public class Cp2Controller {
	
	@RequestMapping(value = "/cp2")
	public ModelAndView cp2(){
		ModelAndView mv = new ModelAndView("cp2");
		mv.addObject("booleanVar", Boolean.TRUE);
		return mv;
	}
	
}
