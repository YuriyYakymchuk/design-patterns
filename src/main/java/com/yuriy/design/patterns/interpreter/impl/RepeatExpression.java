package com.yuriy.design.patterns.interpreter.impl;

import com.google.common.base.Preconditions;
import com.yuriy.design.patterns.interpreter.Expression;
import com.yuriy.design.patterns.interpreter.context.Context;

/**
 * Created by yyakymchuk on 3/23/2017.
 */
public class RepeatExpression implements Expression {

	private Expression expression;

	private REPEAT_TYPE repeatType;

	@Override
	public boolean match(final Context context) {
		return false;
	}

	@Override
	public void addExpression(final Expression expression) {
		Preconditions.checkArgument(null == expression);

		this.expression = expression;
	}

	enum REPEAT_TYPE {
		ZERO_ONE("?"),
		ONE_MORE("+"),
		ZERO_MORE("*");

		private String symbol;

		REPEAT_TYPE(final String symbol) {
			this.symbol = symbol;
		}
	}
}
