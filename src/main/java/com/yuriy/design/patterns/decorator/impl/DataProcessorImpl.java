package com.yuriy.design.patterns.decorator.impl;

import java.util.Collection;

import com.yuriy.design.patterns.decorator.DataProcessor;
import com.yuriy.design.patterns.decorator.model.TimeStampData;

/**
 * Created by yyakymchuk on 3/3/2017.
 */
public class DataProcessorImpl<T extends TimeStampData> implements DataProcessor<T> {

	@Override
	public Collection<T> processData(final Collection<T> dataToProcess) {
		System.out.println("Data retrieving");
		return dataToProcess;
	}
}
