 package com.utrons.springbootexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootMybatisXmlTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisXmlTransactionApplication.class, args);
	}
}
