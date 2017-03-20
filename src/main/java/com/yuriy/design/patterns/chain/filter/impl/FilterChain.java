package com.yuriy.design.patterns.chain.filter.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.yuriy.design.patterns.chain.filter.Filter;
import com.yuriy.design.patterns.chain.model.Request;

/**
 * Created by yyakymchuk on 3/12/2017.
 */
@Service
@Scope("prototype")
public class FilterChain {

	private final List<Filter> filters;
	private int filterPosition = 0;

	@Autowired
	public FilterChain(final List<Filter> filters) {
		Preconditions.checkArgument(filters != null);
		this.filters = filters;
	}

	public void doFilter(final Request request) {
		if((filterPosition == filters.size()) || isRequestProcessed(request)) {
			return;
		} else {
			this.filterPosition++;
			Filter nextFilter = filters.get(filterPosition - 1);
			nextFilter.filter(request, this);
		}
	}

	private boolean isRequestProcessed(final Request request) {
		return request.getProcessingState() == Request.ProcessingState.COMPLETED;
	}
}
