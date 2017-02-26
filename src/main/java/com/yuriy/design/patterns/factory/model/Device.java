package com.yuriy.design.patterns.factory.model;

/**
 * Created by yyakymchuk on 2/26/2017.
 */
public interface Device {
	String DEVICE_NAME_ERROR_MESSAGE = "Device name can't be empty";

	String getName();

	void setName(final String name);
}
