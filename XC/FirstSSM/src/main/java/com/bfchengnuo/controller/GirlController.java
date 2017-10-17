package com.bfchengnuo.controller;

import com.bfchengnuo.service.GirlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by 冰封承諾Andy on 2017/10/17.
 */
@Controller
@RequestMapping("girl")
public class GirlController {
    @Resource
    private GirlService girlService;

    @RequestMapping("getList")
    private ModelAndView getGirls() {
        ModelAndView mv = new ModelAndView("girls");
        mv.addObject("girlList", girlService.queryGirlList());
        return mv;
    }
}
