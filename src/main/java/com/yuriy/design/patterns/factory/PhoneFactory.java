package com.yuriy.design.patterns.factory;

import org.springframework.stereotype.Service;

import com.yuriy.design.patterns.factory.model.Device;
import com.yuriy.design.patterns.factory.model.Phone;

/**
 * Created by yyakymchuk on 2/26/2017.
 */
@Service("phoneFactory")
public class PhoneFactory implements DeviceFactory {

	private static final String DEFAULT_PHONE_NAME = "Phone name";

	@Override
	public Device createDevice() {
		return new Phone(DEFAULT_PHONE_NAME);
	}
}
