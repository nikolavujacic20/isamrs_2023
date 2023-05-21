package com.isamrs.isamrs_projekat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@SpringBootApplication
public class IsamrsProjekatApplication {

	private static Logger log = LoggerFactory.getLogger(IsamrsProjekatApplication.class);
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(IsamrsProjekatApplication.class, args);

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);

		StringBuilder sb = new StringBuilder("Application beans:\n");
		for (String beanName : beanNames) {
			sb.append(beanName + "\n");
		}
		log.info(sb.toString());

	}
//	public static void main(String[] args) {
//		SpringApplication.run(IsamrsProjekatApplication.class, args);
//	}

}
