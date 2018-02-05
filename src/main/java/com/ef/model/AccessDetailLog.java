package com.ef.model;

import java.util.Date;

public class AccessDetailLog {
	/**
	 * full date access
	 */
	private Date dtAccess;
	/**
	 * address ip
	 */
	private String addressIp;
	/**
	 * method http called
	 */
	private String methodHttp;
	/**
	 * return code of web application
	 */
	private String returnCode;
	/**
	 * local access make by client
	 */
	private String localAccess;
	/**
	 * @return the dtAccess
	 */
	public final Date getDtAccess() {
		return dtAccess;
	}
	/**
	 * @param value the dtAccess to set
	 */
	public final void setDtAccess(final Date value) {
		this.dtAccess = value;
	}
	/**
	 * @return the addressIp
	 */
	public final String getAddressIp() {
		return addressIp;
	}
	/**
	 * @param value the addressIp to set
	 */
	public final void setAddressIp(final String value) {
		this.addressIp = value;
	}
	/**
	 * @return the methodHttp
	 */
	public final String getMethodHttp() {
		return methodHttp;
	}
	/**
	 * @param value the methodHttp to set
	 */
	public final void setMethodHttp(final String value) {
		this.methodHttp = value;
	}
	/**
	 * @return the returnCode
	 */
	public final String getReturnCode() {
		return returnCode;
	}
	/**
	 * @param value the returnCode to set
	 */
	public final void setReturnCode(final String value) {
		this.returnCode = value;
	}
	/**
	 * @return the localAccess
	 */
	public final String getLocalAccess() {
		return localAccess;
	}
	/**
	 * @param value the localAccess to set
	 */
	public final void setLocalAccess(final String value) {
		this.localAccess = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccessDetailLog: [dtAccess=" + dtAccess + ", addressIp=" + addressIp + ", methodHttp=" + methodHttp
				+ ", returnCode=" + returnCode + ", localAccess=" + localAccess + "]";
	}
	
	
	
}
