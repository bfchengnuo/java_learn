package com.bfchengnuo.job;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 注解版的自定义任务，只需要在 spring 配置中开启注解扫描即可
 * 其实使用的是 Spring Scheduler
 *
 * @author Kerronex
 * @version 创建时间：2018年6月27日 下午4:36:07
 */
@Component
public class Job3 {
	
	// 相当于任务和调度器合一起了
	@Scheduled(cron="0/3 * * * * ?")
	public void job() {
		System.out.println("注解版的自定义任务...." + new Date());
	}
}
