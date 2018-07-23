package com.bfchengnuo.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 纯 Quartz 实现
 * 定义业务，该类需要实现 Job 接口
 *
 * @author Kerronex
 * @version 创建时间：2018年6月27日 上午10:04:10
 */
public class Job1 implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("job1.......run......." + new Date());
	}

}
