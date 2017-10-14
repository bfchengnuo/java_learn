package com.bfchengnuo.firstspringboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

/**
 * Created by 冰封承諾Andy on 2017/10/14.
 * 执行 mvn clean package 命令打包的时候会自动进行测试，并显示结果
 *
 *      跳过测试，打包
 *      mvn clean package -Dmaven.test.skip=true
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc  // 针对 MVC 的测试，为测试 URL 访问
public class GirlControllerTest {

    @Resource
    private MockMvc mvc;

    @Test
    public void getAge() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/getAge/12"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // 对返回的内容进行判断断言
        // mvc.perform(MockMvcRequestBuilders.get("/getAge/12"))
        //         .andExpect(MockMvcResultMatchers.content().string("xxxx"));
    }

}