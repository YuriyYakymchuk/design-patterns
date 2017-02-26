package com.yuriy.design.patterns.factory.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuriy.design.patterns.factory.service.SystemService;

/**
 * Created by yyakymchuk on 2/25/2017.
 */
public class FactoryMain {

	private static final ClassPathXmlApplicationContext applicationContext;

	static {
		applicationContext = new ClassPathXmlApplicationContext("spring/spring-ctx.xml");
	}

	public static void main(String[] args) {
		SystemService service = applicationContext.getBean("systemService", SystemService.class);
		service.print("Hello");
		System.out.println(service.constructDevice().getName());
	}
}
