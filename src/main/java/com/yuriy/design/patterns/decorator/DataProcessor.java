package com.yuriy.design.patterns.decorator;

import java.util.Collection;

/**
 * Created by yyakymchuk on 3/3/2017.
 */
public interface DataProcessor<T> {

	Collection<T> processData(Collection<T> dataToProcess);
}
