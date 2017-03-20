package com.yuriy.design.patterns.chain.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuriy.design.patterns.chain.filter.impl.FilterChain;
import com.yuriy.design.patterns.chain.model.Request;

/**
 * Created by yyakymchuk on 3/12/2017.
 */
public class ChainOfResponsibilityMain {

	private static ClassPathXmlApplicationContext applicationContext;

	static {
		applicationContext = new ClassPathXmlApplicationContext("/spring/chain-ctx.xml");
	}

	public static void main(String[] args) {
		final Request request = new Request("Request", Request.RequestType.ERROR, Request.ProcessingState.WAITING);
		final FilterChain filterChain = applicationContext.getBean(FilterChain.class);
		filterChain.doFilter(request);
		System.out.println("Hello chain");
	}
}
