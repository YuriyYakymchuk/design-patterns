package com.yuriy.design.patterns.factory.service;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.yuriy.design.patterns.factory.ComputerFactory;
import com.yuriy.design.patterns.factory.DeviceFactory;
import com.yuriy.design.patterns.factory.PhoneFactory;
import com.yuriy.design.patterns.factory.model.Device;
import com.yuriy.design.patterns.factory.model.DeviceType;

/**
 * Created by yyakymchuk on 2/25/2017.
 */
@Service("systemService")
public class SystemServiceImpl implements SystemService, ApplicationContextAware{

	private String state;

	private String factoryType;

	private DeviceFactory deviceFactory;

	private ApplicationContext applicationContext;

	@Autowired
	public SystemServiceImpl(final @Value("#{patternsProperties['current.state']}") String state,
		final @Value("#{patternsProperties['factory.type']}") String factoryType) {

		Preconditions.checkArgument(StringUtils.isNoneEmpty(state));
		Preconditions.checkArgument(StringUtils.isNoneEmpty(factoryType));

		this.state = state;
		this.factoryType = factoryType;
	}

	@Override
	public void print(final String text) {
		System.out.println(text);
	}

	@Override
	public Device constructDevice() {
		return deviceFactory.createDevice();
	}

	public String getState() {
		return state;
	}

	public void setState(final String state) {
		this.state = state;
	}

	public String getFactoryType() {
		return factoryType;
	}

	public void setFactoryType(final String factoryType) {
		this.factoryType = factoryType;
	}

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@PostConstruct
	public void setDeviceFactory() {
		DeviceType deviceType = null;
		try {
			deviceType = DeviceType.valueOf(getFactoryType());
		} catch (IllegalArgumentException ex) {
			System.err.println("Not supported factory type was configured");
			deviceType = DeviceType.COMPUTER;
		}
		switch (deviceType) {
			case COMPUTER: {
				deviceFactory = applicationContext.getBean(ComputerFactory.class);
				break;
			}
			case PHONE: {
				deviceFactory = applicationContext.getBean(PhoneFactory.class);
				break;
			}
		}
	}
}
