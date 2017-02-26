package com.yuriy.design.patterns.factory;

import org.springframework.stereotype.Service;

import com.yuriy.design.patterns.factory.model.Computer;
import com.yuriy.design.patterns.factory.model.Device;

/**
 * Created by yyakymchuk on 2/26/2017.
 */
@Service("computerFactory")
public class ComputerFactory implements DeviceFactory {

	private static final String DEFAULT_COMPUTER_NAME = "Computer name";

	@Override
	public Device createDevice() {
		return new Computer(DEFAULT_COMPUTER_NAME);
	}
}
