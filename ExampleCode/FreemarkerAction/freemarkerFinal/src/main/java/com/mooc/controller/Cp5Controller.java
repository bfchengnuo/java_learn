package com.mooc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 取值（插值）
 */
@Controller
@RequestMapping("/")
public class Cp5Controller {
	
	@RequestMapping(value = "/cp5")
	public ModelAndView cp5(){
		ModelAndView mv = new ModelAndView("cp5");
		return mv;
	}
	
}
