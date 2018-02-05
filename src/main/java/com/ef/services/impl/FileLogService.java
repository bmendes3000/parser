package com.ef.services.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ef.dao.IFileLogDAO;
import com.ef.model.AccessDetailLog;
import com.ef.services.IFileLogService;

@Service("fileLogService")
public class FileLogService implements IFileLogService {

	//variable to access database layer
	@Autowired
	private IFileLogDAO dao;
	
	
	@Override
	public void save(final AccessDetailLog detail) throws SQLException {
		//call method for save object information
		dao.save(detail);
	}

}
