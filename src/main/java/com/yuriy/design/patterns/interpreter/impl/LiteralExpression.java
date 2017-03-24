package com.yuriy.design.patterns.interpreter.impl;

import com.yuriy.design.patterns.interpreter.Expression;
import com.yuriy.design.patterns.interpreter.context.Context;

/**
 * Created by yyakymchuk on 3/23/2017.
 */
public class LiteralExpression implements Expression{

	private String word;

	public LiteralExpression(final String word) {
		this.word = word;
	}

	@Override
	public boolean match(final Context context) {
		return false;
	}
}
