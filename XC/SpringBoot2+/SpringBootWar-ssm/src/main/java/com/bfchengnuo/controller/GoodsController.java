package com.bfchengnuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfchengnuo.bean.Goods;
import com.bfchengnuo.service.GoodsService;
import com.bfchengnuo.test.TestRes;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月29日 下午3:37:24
 */
@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	private GoodsService gs;
	
	@PostMapping("add")
	public String add(Goods goods, Model m) {
		int result = gs.add(goods);
		m.addAttribute("msg", "change：" + result);
		
		return "success";
	}
	
	@Autowired
	private TestRes test;
	@GetMapping("test")
	public String test() {
		test.log();
		return "success";
	}
}
