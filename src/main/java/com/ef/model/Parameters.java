package com.ef.model;

import java.util.Date;

public class Parameters {
	/**
	 * access log
	 */
	private String accesslog;
	/**
	 * start date for filter
	 */
	private Date startDate;
	/**
	 * duration type 
	 */
	private TypeDuration duration;
	/**
	 * threshold
	 */
	private Integer threshold;
	
	/**
	 * @return the accesslog
	 */
	public final String getAccesslog() {
		return accesslog;
	}
	/**
	 * @param value the accesslog to set
	 */
	public final void setAccesslog(final String value) {
		this.accesslog = value;
	}
	/**
	 * @return the startDate
	 */
	public final Date getStartDate() {
		return startDate;
	}
	/**
	 * @param value the startDate to set
	 */
	public final void setStartDate(final Date value) {
		this.startDate = value;
	}
	/**
	 * @return the duration
	 */
	public final TypeDuration getDuration() {
		return duration;
	}
	/**
	 * @param value the duration to set
	 */
	public final void setDuration(final TypeDuration value) {
		this.duration = value;
	}
	/**
	 * @return the threshold
	 */
	public final Integer getThreshold() {
		return threshold;
	}
	/**
	 * @param value the threshold to set
	 */
	public final void setThreshold(final Integer value) {
		this.threshold = value;
	}
	

}
