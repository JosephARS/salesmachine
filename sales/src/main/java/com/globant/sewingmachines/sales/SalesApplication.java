package com.globant.sewingmachines.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.globant.sewingmachines.sales.configuration.AmazonSNSConfiguration;


@SpringBootApplication
@ComponentScan("com.globant.sewingmachines.sales")
public class SalesApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SalesApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SalesApplication.class, args);

	}

}
