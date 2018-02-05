package com.ef.services;

import java.sql.SQLException;

import com.ef.model.AccessDetailLog;

public interface IFileLogService {
	/**
	 * Method responsible to save the access detail object.
	 * @param detail {@link AccessDetailLog}
	 */ 
	void save(final AccessDetailLog detail) throws SQLException;

}
