package com.ef.dao;

import java.util.List;

import com.ef.model.BlockedAddress;
import com.ef.model.FilterParams;

public interface IAccessFilterDAO {
	/**
	 * Method responsible for find the access improper
	 * @param param {@link FilterParams}
	 * @return {@link List}
	 */
	List<BlockedAddress> findByParams(final FilterParams param);
	
	/**
	 * Method responsible for save address block
	 * @param block {@link BlockedAddress}
	 */
	void save(final BlockedAddress block);


}
