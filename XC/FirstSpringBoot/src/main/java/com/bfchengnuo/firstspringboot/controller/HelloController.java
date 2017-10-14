package com.bfchengnuo.firstspringboot.controller;

import com.bfchengnuo.firstspringboot.domain.Girl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 冰封承諾Andy on 2017/10/14.
 * RestController 在 4.x+ 的版本中加入，相当于 @ResponseBody 和 @Controller
 */
@RestController
public class HelloController {

    // 注入自定义属性
    @Value("${girl.name}")
    private String name;

    @Resource
    private Girl girl;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String test() {
        return "Hello World! " + name + "; age:" + girl.getAge();
    }

    // 组合注解，method=get
    @GetMapping("hello2")
    public String test2() {
        return "Hello World! " + name ;
    }
}
