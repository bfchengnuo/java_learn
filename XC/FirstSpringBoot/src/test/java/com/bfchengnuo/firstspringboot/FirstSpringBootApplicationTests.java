package com.bfchengnuo.firstspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)  // 低层用的还是 Junit，表名是在测试环境下跑
@SpringBootTest  // 启动整个工程
public class FirstSpringBootApplicationTests {

	@Test
	public void contextLoads() {
		// 使用断言
		// Assert.assertEquals();
	}

}
