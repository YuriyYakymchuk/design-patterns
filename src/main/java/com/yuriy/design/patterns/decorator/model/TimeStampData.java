package com.yuriy.design.patterns.decorator.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

/**
 * Created by yyakymchuk on 3/3/2017.
 */
public class TimeStampData {

	private DateTime timeStamp;

	private String value;

	public DateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(final DateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof TimeStampData)) {
			return false;
		}

		final TimeStampData that = (TimeStampData) o;

		return new EqualsBuilder()
			.append(getTimeStamp(), that.getTimeStamp())
			.append(getValue(), that.getValue())
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
			.append(getTimeStamp())
			.append(getValue())
			.toHashCode();
	}
}
