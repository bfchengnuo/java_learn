package com.bfchengnuo.ex;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月29日 下午5:04:32
 */
@ControllerAdvice
public class ExController {
	@ExceptionHandler
	public String ex(Exception ex, Model m) {
		m.addAttribute("msg", "出现错误：" + ex.getMessage());
		return "/error";
	}
}
