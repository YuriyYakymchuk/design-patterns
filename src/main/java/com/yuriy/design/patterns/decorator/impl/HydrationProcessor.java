package com.yuriy.design.patterns.decorator.impl;

import java.util.Collection;

import com.yuriy.design.patterns.decorator.DataProcessor;
import com.yuriy.design.patterns.decorator.model.TimeStampData;

/**
 * Created by yyakymchuk on 3/3/2017.
 */
public class HydrationProcessor<T extends TimeStampData> extends AbstractDecorator<T> {

	public HydrationProcessor(final DataProcessor<T> dataProcessor) {
		super(dataProcessor);
	}

	@Override
	public Collection<T> processData(final Collection<T> dataToProcess) {
		final Collection<T> processedData = super.processData(dataToProcess);
		System.out.println("Hydration of data");
		return processedData;
	}
}
