package com.yuriy.design.patterns.interpreter;

import com.yuriy.design.patterns.interpreter.context.Context;

/**
 * Created by yyakymchuk on 3/23/2017.
 */
public interface Expression {

	boolean match(Context context);

	default void addExpression(Expression expression) {
		return;
	}
}
