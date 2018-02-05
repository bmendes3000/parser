package com.ef.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ef.dao.IAccessFilterDAO;
import com.ef.model.BlockedAddress;
import com.ef.model.FilterParams;
import com.ef.services.IAccessFilterService;

@Service("accessFilterService")
public class AccessFilterService implements IAccessFilterService {
	
	//variable to access database layer
	@Autowired
	private IAccessFilterDAO dao;
	
	@Override
	public List<BlockedAddress> findByParams(final FilterParams param) {
		// call method to get all address block 
		return dao.findByParams(param);
	}

	@Override
	public void save(final BlockedAddress block) {
		// call method to save information in database
		dao.save(block);
	}

}
