package com.ef.model;

import java.util.Date;

public class FilterParams {
	/**
	 * start date
	 */
	private Date startDate;
	/**
	 * duration type
	 */
	private Date endDate;
	/**
	 * threshold
	 */
	private Integer threshold;
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
	 * @return the endDate
	 */
	public final Date getEndDate() {
		return endDate;
	}
	/**
	 * @param value the endDate to set
	 */
	public final void setEndDate(final Date value) {
		this.endDate = value;
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
