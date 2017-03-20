package com.yuriy.design.patterns.chain.model;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

/**
 * Created by yyakymchuk on 3/12/2017.
 */
public class Request {

	private final String name;
	private final RequestType type;
	private ProcessingState processingState;

	public Request(final String name, final RequestType type, final ProcessingState processingState) {
		this.name = name;
		this.type = type;
		this.processingState = processingState;
	}

	public static Request of(final String name, final RequestType requestType, final ProcessingState processingState) {
		Preconditions.checkArgument(StringUtils.isNoneEmpty(name));
		Preconditions.checkArgument(requestType != null);
		return new Request(name, requestType, processingState);
	}

	public Request withName(final String name) {
		Preconditions.checkArgument(StringUtils.isNoneEmpty(name));

		return new Request(name, type, processingState);
	}

	public Request withType(final RequestType type) {
		Preconditions.checkArgument(type != null);

		return new Request(name, type, processingState);
	}

	public Request withProcessingState(final ProcessingState processingState) {
		Preconditions.checkArgument(processingState != null);

		return new Request(name, type, processingState);
	}

	public String getName() {
		return name;
	}

	public RequestType getType() {
		return type;
	}

	public ProcessingState getProcessingState() {
		return processingState;
	}

	public void setProcessingState(final ProcessingState processingState) {
		this.processingState = processingState;
	}

	public enum RequestType {
		HTTP, SECURITY, ERROR
	}

	public enum ProcessingState {
		WAITING, IN_PROGRESS, COMPLETED, ERROR
	}
}
