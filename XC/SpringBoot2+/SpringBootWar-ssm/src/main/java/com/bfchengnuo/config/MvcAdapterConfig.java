package com.bfchengnuo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bfchengnuo.interceptor.AuthInterceptor;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月29日 下午5:36:50
 */
@Configuration
// @PropertySource(value = "classpath:jdbc.properties", encoding = "UTF-8", ignoreResourceNotFound=false)
public class MvcAdapterConfig implements WebMvcConfigurer {

	// @Value("${sp.datasource.url}")
	// private String test;
	
	@Autowired
	private AuthInterceptor authInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// System.out.println("--------------->" + test);  yes...
		
		// 注册一个拦截器
		registry.addInterceptor(authInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns("/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("goods-add");
	}

	/*
	// 放行自定义的静态资源
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/skin/**")
			.addResourceLocations("/skin/");
	}
	*/
	
	
}
