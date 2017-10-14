package com.bfchengnuo.firstspringboot.controller;

import com.bfchengnuo.firstspringboot.entity.Girl;
import com.bfchengnuo.firstspringboot.repository.GirlRepository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by 冰封承諾Andy on 2017/10/14.
 */
@RestController
@RequestMapping("girl")
public class GirlController {

    @Resource
    private GirlRepository girlRepository;

    @GetMapping("getList")
    public List<Girl> getList() {
        return girlRepository.findAll();
    }

    @GetMapping("get/{id}")
    public Girl getGirl(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    @PostMapping("add")
    public Girl add(@RequestParam("name") String name ,
                    @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setName(name);

        System.out.println(name);
        return girlRepository.save(girl);
    }


    @PostMapping("update")
    public Girl add(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlRepository.save(girl);
    }

    @GetMapping("getAge/{age}")
    public List<Girl> getAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }
}
