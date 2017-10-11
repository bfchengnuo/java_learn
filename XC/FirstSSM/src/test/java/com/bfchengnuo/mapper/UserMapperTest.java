package com.bfchengnuo.mapper;

import com.bfchengnuo.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 冰封承諾Andy on 2017/10/9.
 */
public class UserMapperTest {
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml", "spring/applicationContext-mybatis.xml");
        this.userMapper = ac.getBean(UserMapper.class);
    }

    @Test
    public void queryUserById() throws Exception {
        User user = userMapper.queryUserById(1L);
        System.out.println(user);
    }

}