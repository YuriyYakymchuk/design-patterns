package com.yuriy.design.patterns.interpreter.builder;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Splitter;
import com.yuriy.design.patterns.interpreter.Expression;
import com.yuriy.design.patterns.interpreter.impl.LiteralExpression;
import com.yuriy.design.patterns.interpreter.impl.LogicalOrExpression;

/**
 * Created by yyakymchuk on 3/23/2017.
 */
public class ExpressionBuilder {

	public Expression compile(final String expression) {
		if(null == expression) {
			return null;
		}
		final String cutExpression = cutExpression(expression);
		Iterable<String> expressions = Splitter.on("|").split(cutExpression);
		LogicalOrExpression logicalOrExpression = new LogicalOrExpression();
		expressions.forEach(s -> logicalOrExpression.addExpression(new LiteralExpression(s)));
		return logicalOrExpression;
	}

	private String cutExpression(final String expression) {
		return StringUtils.substringBetween(expression, "(", ")");
	}

	private String getExpressionSymbol(final String expression) {
		if(null == expression) {
			return null;
		}
		return  expression;

	}

	private boolean isAndExpression(final String symbol) {
		return Objects.equals(symbol, "&");
	}

	private boolean isOrExpression(final String symbol) {
		return com.google.common.base.Objects.equal(symbol, "|");
	}

	private boolean isRepeatExpression(final String symbol) {
		return Objects.equals(symbol, "*") || Objects.equals(symbol, "?") || Objects.equals(symbol, "+");
	}
}
