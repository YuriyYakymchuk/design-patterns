package com.yuriy.design.patterns.decorator.main;

import java.util.Collection;

import com.google.common.collect.Lists;
import com.yuriy.design.patterns.decorator.DataProcessor;
import com.yuriy.design.patterns.decorator.impl.DataProcessorImpl;
import com.yuriy.design.patterns.decorator.impl.HydrationProcessor;
import com.yuriy.design.patterns.decorator.impl.InterpolationProcessor;
import com.yuriy.design.patterns.decorator.model.TimeStampData;

/**
 * Created by yyakymchuk on 3/3/2017.
 */
public class DecoratorMain {

	static public void main(String[] args) {
		Collection<TimeStampData> dataToProcess = Lists.newArrayList();
		DataProcessor<TimeStampData> dataProcessorPipe = new InterpolationProcessor<TimeStampData>(new HydrationProcessor<TimeStampData>(new DataProcessorImpl<TimeStampData>()));
		dataProcessorPipe.processData(dataToProcess);
	}
}
