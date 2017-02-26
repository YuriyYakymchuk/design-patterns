package com.yuriy.design.patterns.factory.service;

import com.yuriy.design.patterns.factory.model.Device;

/**
 * Created by yyakymchuk on 2/25/2017.
 */
public interface SystemService {

	void print(String text);

	void setState(String state);

	String getState();

	default  Device constructDevice() {
		return null;
	}
}
