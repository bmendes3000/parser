package com.ef.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ef.dao.IAccessFilterDAO;
import com.ef.model.BlockedAddress;
import com.ef.model.FilterParams;
import com.ef.queries.AccessFilterQuery;
import com.ef.rowmappers.BlockedAccessRowMapper;
@Repository("accessFilterDAO")
public class AccessFilterDAO implements IAccessFilterDAO {
	
	/**
	 * Variable with access data base.
	 */
	@Autowired
	private JdbcTemplate jdbc;
	
	
	@Override
	public List<BlockedAddress> findByParams(final FilterParams param) {
		
		return jdbc.query(AccessFilterQuery.findByParams(),
				new Object[] {
						param.getStartDate(),
						param.getEndDate(),
						param.getThreshold()
				},
				new BlockedAccessRowMapper());
	}


	@Override
	public void save(final BlockedAddress block) {
		//save the information in data base
		jdbc.update(AccessFilterQuery.save(), 
				new Object[]{
						block.getDtBlock(),
						block.getAddressIp(),
						block.getThreshold(),
						block.getDescription()
				}
		);
	}
}
