package com.bfchengnuo.job;

import java.util.Date;

/**
 * 结合 spring 的 bean 注入实现的定时任务
 * 必要的 bean 由 spring 来初始化，配置在 spring 的配置文件中
 * 自定义业务 2
 *
 * @author Kerronex
 * @version 创建时间：2018年6月27日 下午2:43:19
 */
public class Job2 {
	
	// 自定义业务方法，不能有参数
	public void job() {
		System.out.println("自定义 Job：" + new Date());
	}
}
