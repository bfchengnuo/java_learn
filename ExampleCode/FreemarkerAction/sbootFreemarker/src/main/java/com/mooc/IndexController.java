package com.mooc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model, HttpServletRequest request) {
		return "index";
	}
	
}
