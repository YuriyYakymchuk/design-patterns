package com.yuriy.design.patterns.interpreter.impl;

import java.util.Collection;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.yuriy.design.patterns.interpreter.Expression;
import com.yuriy.design.patterns.interpreter.context.Context;

/**
 * Created by yyakymchuk on 3/23/2017.
 */
public class LogicalAndExpression implements Expression{

	private Collection<Expression> expressions;


	@Override
	public boolean match(final Context context) {
		return false;
	}

	@Override
	public void addExpression(final Expression expression) {
		Preconditions.checkArgument(null == expression);

		if(null == expressions) {
			expressions = Lists.newArrayList();
		}
		expressions.add(expression);
	}
}
