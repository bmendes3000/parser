package com.ef.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ef.model.BlockedAddress;

public class BlockedAccessRowMapper implements RowMapper<BlockedAddress> {

	@Override
	public BlockedAddress mapRow(ResultSet rs, int rowNum) throws SQLException {
		//create variable's return
		BlockedAddress address = new BlockedAddress();
		address.setAddressIp(rs.getString("ipAddress"));
		address.setThreshold(rs.getInt("threshold"));
		
		//return the object
		return address;
	}

}
