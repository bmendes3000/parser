package com.ef.dao.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ef.dao.IFileLogDAO;
import com.ef.model.AccessDetailLog;
import com.ef.queries.FileLogQuery;

@Repository("fileLogDAO")
public class FileLogDAO implements IFileLogDAO {
	
	/**
	 * Variable with access data base.
	 */
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public void save(final AccessDetailLog detail) throws SQLException {
		//save the information in data base
		jdbc.update(FileLogQuery.save(), 
				new Object[]{
					detail.getAddressIp(),
					detail.getDtAccess(),
					detail.getMethodHttp(),
					detail.getReturnCode(),
					detail.getLocalAccess()
				}
		);
	}
	

}
