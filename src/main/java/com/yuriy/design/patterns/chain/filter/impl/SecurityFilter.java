package com.yuriy.design.patterns.chain.filter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.yuriy.design.patterns.chain.filter.Filter;
import com.yuriy.design.patterns.chain.model.Request;

/**
 * Created by yyakymchuk on 3/12/2017.
 */
@Service
@Order(value = 3)
public class SecurityFilter implements Filter{

	private final Request.RequestType filterRequestType;

	@Autowired
	public SecurityFilter(final @Value("SECURITY") String filterRequestType) {
		Preconditions.checkArgument(filterRequestType != null);

		this.filterRequestType = Request.RequestType.valueOf(filterRequestType);
	}

	@Override
	public void filter(final Request request, final FilterChain filterChain) {
		if (isRequestProcessable(request)) {
			request.setProcessingState(Request.ProcessingState.IN_PROGRESS);
			System.out.println("Security processing");
			request.setProcessingState(Request.ProcessingState.COMPLETED);
		}
		filterChain.doFilter(request);
	}

	@Override
	public Request.RequestType getFilterRequestType() {
		return filterRequestType;
	}
}
