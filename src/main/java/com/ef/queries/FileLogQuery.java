package com.ef.queries;

public class FileLogQuery {
	
	/**
	 * Query to save the information in database
	 * @return {@link String}
	 */
	public static final String save() {
		//Variable with the query
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO DbParser.TbAccessAddress ")
			.append("	(ipAddress, dtAccess, methodHttp, returnCode, localAccess)")
			.append(" VALUES (?, ?, ?, ?, ?) ");
		
		//return the query
		return sql.toString();
	}

}
