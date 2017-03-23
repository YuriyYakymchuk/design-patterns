package com.yuriy.design.patterns.interpreter.context;

/**
 * Created by yyakymchuk on 3/23/2017.
 */
public class Context {

	private String context;

	public Context(final String context) {
		this.context = context;
	}

	public Context withContext(final String context) {
		return new Context(context);
	}
}
