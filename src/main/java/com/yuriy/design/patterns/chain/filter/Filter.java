package com.yuriy.design.patterns.chain.filter;

import com.yuriy.design.patterns.chain.filter.impl.FilterChain;
import com.yuriy.design.patterns.chain.model.Request;

/**
 * Created by yyakymchuk on 3/12/2017.
 */
public interface Filter {

	void filter(Request request, FilterChain filterChain);

	Request.RequestType getFilterRequestType();

	default boolean isRequestProcessable(final Request request) {
		return request.getType() == getFilterRequestType();
	}
}
