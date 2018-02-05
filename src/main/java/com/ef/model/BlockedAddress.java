package com.ef.model;

import java.util.Date;

public class BlockedAddress {
	/**
	 * full date access
	 */
	private Date dtBlock;
	/**
	 * Address ip block
	 */
	private String addressIp;
	/**
	 * threshold
	 */
	private Integer threshold;
	/**
	 * description of the block
	 */
	private String description;
	/**
	 * @return the dtBlock
	 */
	public final Date getDtBlock() {
		return dtBlock;
	}
	/**
	 * @param value the dtBlock to set
	 */
	public final void setDtBlock(final Date value) {
		this.dtBlock = value;
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
	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}
	/**
	 * @param value the description to set
	 */
	public final void setDescription(final String value) {
		this.description = value;
	}
	

}
