package com.bfchengnuo.test;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import com.bfchengnuo.job.Job1;

/**
 * 基础 Quartz 的使用
 * @author Kerronex
 * @version 创建时间：2018年6月27日 上午10:13:07
 */
public class QuartzTest {

	public static void main(String[] args) throws Exception {
		// 1.定义任务
		// 任务名（唯一，spring 中默认是 id 名）、任务组名称（唯一，spring 中默认是 DEFAULT）、任务执行的操作
		JobDetail jobDetail = new JobDetail("job1", "g_job", Job1.class);
		
		// 2.定义触发器
		// 触发器名和触发器组名
		// 一个Job可以对应多个Trigger， 但一个Trigger只能对应一个Job
		CronTrigger cron = new CronTrigger("cron_f", "cron_g");
		// 秒 分 小时 日期 月份 星期 年(可省略)
		cron.setCronExpression("0/2 * * * * ?");
		
		// 3.定义监听器（调度器）
		StdSchedulerFactory sf = new StdSchedulerFactory();
		Scheduler s = sf.getScheduler();
		// 4.设置任务和触发器
		s.scheduleJob(jobDetail, cron);
		// 5.启动调度器
		s.start();
	}

}
