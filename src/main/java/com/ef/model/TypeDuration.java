package com.ef.model;

public enum TypeDuration {
	Hourly("hourly"),
	Daily("daily");
	/**
	 * duration type code
	 */
	private String code;
	/**
	 * Constructor Default. 
	 * @param arg {@link String}
	 */
	private TypeDuration(final String arg) {
		this.code = arg;
	}
	/**
	 * @return the code
	 */
	public final String getCode() {
		return code;
	}
	/**
	 * Method responsible for get value by code
	 * @param value
	 * @return
	 */
	public final static TypeDuration valueOfCode(final String value) {
		if (Hourly.code.equalsIgnoreCase(value)) {
			return Hourly;
		} else if (Daily.code.equalsIgnoreCase(value)) {
			return Daily;
		}
		return null;
	}
	
}
