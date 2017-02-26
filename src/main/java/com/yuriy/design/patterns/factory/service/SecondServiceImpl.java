package com.yuriy.design.patterns.factory.service;

import org.springframework.stereotype.Service;

/**
 * Created by yyakymchuk on 2/26/2017.
 */
@Service("secondService")
public class SecondServiceImpl implements SystemService {

	@Override
	public void print(final String text) {

	}

	@Override
	public void setState(final String state) {

	}

	@Override
	public String getState() {
		return null;
	}
}
