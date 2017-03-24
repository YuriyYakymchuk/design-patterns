package com.yuriy.design.patterns.interpreter.builder;

import com.google.common.base.Splitter;
import com.yuriy.design.patterns.interpreter.Expression;
import com.yuriy.design.patterns.interpreter.impl.LiteralExpression;
import com.yuriy.design.patterns.interpreter.impl.LogicalOrExpression;

/**
 * Created by yyakymchuk on 3/23/2017.
 */
public class ExpressionBuilder {

	public static Expression compile(String expression) {
		if(null == expression) {
			return null;
		}
		Iterable<String> expressions = Splitter.on("|").split(expression);
		LogicalOrExpression logicalOrExpression = new LogicalOrExpression();
		expressions.forEach(s -> logicalOrExpression.addExpression(new LiteralExpression(s)));
		return logicalOrExpression;
	}
}
