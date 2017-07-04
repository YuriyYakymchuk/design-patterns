package com.yuriy.design.patterns.interpreter.main;

import com.yuriy.design.patterns.interpreter.Expression;
import com.yuriy.design.patterns.interpreter.builder.ExpressionBuilder;

/**
 * Created by yyakymchuk on 3/23/2017.
 */
public class InterpreterMain {

	public static void main(String[] args) {
		ExpressionBuilder expressionBuilder = new ExpressionBuilder();
		Expression expression = expressionBuilder.compile("(a|b)");
		System.out.println(expression);
	}
}
