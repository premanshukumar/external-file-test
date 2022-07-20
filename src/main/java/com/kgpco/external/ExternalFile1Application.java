package com.kgpco.external;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@SpringBootApplication
public class ExternalFile1Application {

	private static final Logger logger = LoggerFactory.getLogger(ExternalFile1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(ExternalFile1Application.class, args);

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("my-beans.xml");

		SimpleDriverDataSource dataSource = (SimpleDriverDataSource) ctx.getBean("dataSource");

		logger.info("Url: {}", dataSource.getUrl());
		logger.info("User name: {}", dataSource.getUsername());
		logger.info("Password: {}", dataSource.getPassword());

		ctx.close();

	}

}
