package com.tulay.springcourse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
@RestController
public class SpringcourseApplication implements ApplicationRunner {
	@Autowired
	RestTemplate restTemplate;

	private static final Logger logger= LoggerFactory.getLogger(SpringcourseApplication.class);
	public static void main(String[] args) {
		logger.info("this.is a info message");

		SpringApplication.run(SpringcourseApplication.class, args);
	}



	@RequestMapping(value = "/")
	public String helloWorld(){
		return "hello world from Tomcat";
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("This is application runner interface");

	}
}
