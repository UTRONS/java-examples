/*
 * Copyright (c) 2017 朱泽才 版权所有
 */
package com.utrons.springbootexamples.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * TODO
 *
 * @author Nic
 * @version 1.0.0
 * @date 2017年11月8日 上午9:55:29
 * @link
 * @see
 */
@Configuration
@MapperScan(basePackages = "com.utrons.**.dao.utestb", sqlSessionTemplateRef = "utestBSqlSessionTemplate")
public class DataSourceBConfig {

	@Bean
	@ConfigurationProperties("spring.datasource.utestb")
	public DataSourceProperties utestBDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("spring.datasource.utestb")
	public DataSource utestBDataSource() {
		return utestBDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean
	public SqlSessionFactory utestBSqlSessionFactory(@Qualifier("utestBDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:config/system/mybatis/mapper/utestB/**/*.xml"));
		return bean.getObject();
	}

	@Bean
	public DataSourceTransactionManager utestBTransactionManager(@Qualifier("utestBDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public SqlSessionTemplate utestBSqlSessionTemplate(@Qualifier("utestBSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
