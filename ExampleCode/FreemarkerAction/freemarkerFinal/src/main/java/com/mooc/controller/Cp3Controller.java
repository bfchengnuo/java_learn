package com.mooc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 取值（插值）
 */
@Controller
@RequestMapping("/")
public class Cp3Controller {
	
	@RequestMapping(value = "/cp3")
	public ModelAndView cp3(){
		ModelAndView mv = new ModelAndView("cp3");
		mv.addObject("sortFunction", new SortMethod());
		return mv;
	}
	
}
