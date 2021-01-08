package com.ltfs.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ltfs")
public class Main extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("application started..");
		SpringApplication.run(Main.class, args);
		// ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
		// ctx.close();
	}

}
