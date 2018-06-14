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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * TODO
 *
 * @author Nic
 * @version 1.0.0
 * @date 2017年11月7日 下午4:26:36
 * @link
 * @see
 */
@Configuration
@MapperScan(basePackages = "com.utrons.**.dao.utesta", sqlSessionTemplateRef = "utestASqlSessionTemplate")
public class DataSourceAConfig {

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.utesta")
	public DataSourceProperties utestADataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.utesta")
	@Primary
	public DataSource utestADataSource() {
		return utestADataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean
	@Primary
	public SqlSessionFactory utestASqlSessionFactory(@Qualifier("utestADataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:config/system/mybatis/mapper/utestA/**/*.xml"));
		return bean.getObject();
	}

	@Bean
	@Primary
	public DataSourceTransactionManager utestATransactionManager(@Qualifier("utestADataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	@Primary
	public SqlSessionTemplate utestASqlSessionTemplate(@Qualifier("utestASqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
