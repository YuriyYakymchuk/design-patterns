package com.yuriy.design.patterns.decorator.impl;

import java.util.Collection;

import com.yuriy.design.patterns.decorator.DataProcessor;
import com.yuriy.design.patterns.decorator.model.TimeStampData;

/**
 * Created by yyakymchuk on 3/3/2017.
 */
public abstract class AbstractDecorator<T extends TimeStampData> implements DataProcessor<T>{

	private DataProcessor<T> dataProcessor;

	public AbstractDecorator(final DataProcessor<T> dataProcessor) {
		this.dataProcessor = dataProcessor;
	}

	@Override
	public Collection<T> processData(final Collection<T> dataToProcess) {
		System.out.println("Abstract decorator");
		return dataProcessor.processData(dataToProcess);
	}
}
