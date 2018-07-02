package com.bfchengnuo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @AutoConfigureAfter(xxx.class)  // 在某个配置类加载之后加载
 *
 * @author Kerronex
 * @version 创建时间：2018年6月29日 上午11:24:54
 */
@Configuration
@PropertySource(value = "classpath:jdbc.properties", encoding = "UTF-8", ignoreResourceNotFound=false)
@EnableTransactionManagement // 5.配置声明式事务, proxyTargetClass=true 启用 CGLIB, 应该可以自动配置
public class DataSourceConfig {
	
	@Value("${sp.datasource.url}")
	private String test;
	
	// 1.配置数据源
	@Bean(name="dataSource")
	@Primary
//	@ConfigurationProperties(prefix="ds")  // 使用全局的配置
	@ConfigurationProperties(prefix = "sp.datasource")
	public DataSource getDS() {
		return new DriverManagerDataSource();
	}
	
	// 2.配置session工厂
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory getSSF(DataSource ds) { // 或者使用 @Qualifier 指定 id 
		System.out.println("--------------->" + test);  // null .....
		try {
			SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
			factory.setDataSource(ds);
			factory.setTypeAliasesPackage("com.bfchengnuo.bean");
			Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:com/bfchengnuo/mapper/*.xml");
			factory.setMapperLocations(resources);
			return factory.getObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 3.扫描接口
	@Bean
	public MapperScannerConfigurer getMSC() {
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		// configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		configurer.setBasePackage("com.bfchengnuo.mapper");
		// 指定接口
		configurer.setAnnotationClass(Repository.class);
		
		return configurer;
	}
	
	
	// 4.配置事务管理器，应该可以自动配置，不需要写
	@Bean(name="tx")
	public DataSourceTransactionManager getTX(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
	
}
