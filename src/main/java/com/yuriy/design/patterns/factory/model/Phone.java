package com.yuriy.design.patterns.factory.model;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/**
 * Created by yyakymchuk on 2/26/2017.
 */
public class Phone implements Device{

	private String name;

	public Phone(final String name) {
		Preconditions.checkArgument(StringUtils.isNoneEmpty(name), DEVICE_NAME_ERROR_MESSAGE);
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		Preconditions.checkArgument(StringUtils.isNoneEmpty(name), DEVICE_NAME_ERROR_MESSAGE);
		this.name = name;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Phone)) {
			return false;
		}
		final Phone phone = (Phone) o;
		return Objects.equal(getName(), phone.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getName());
	}
}
