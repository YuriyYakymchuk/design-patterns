package com.yuriy.design.patterns.factory.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.base.Preconditions;

/**
 * Created by yyakymchuk on 2/26/2017.
 */
public class Computer implements Device {

	private String name;

	public Computer(final String name) {
		Preconditions.checkArgument(StringUtils.isNotEmpty(name), DEVICE_NAME_ERROR_MESSAGE);
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		Preconditions.checkArgument(StringUtils.isNotEmpty(name), DEVICE_NAME_ERROR_MESSAGE);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Computer)) {
			return false;
		}

		final Computer computer = (Computer) o;

		return new EqualsBuilder()
			.append(getName(), computer.getName())
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
			.append(getName())
			.toHashCode();
	}
}
