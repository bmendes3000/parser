package com.ef.queries;

public class AccessFilterQuery {
	/**
	 * Query responsible for get all address with access improper. 
	 * @return {@link String}
	 */
	public final static String findByParams() {
		//Variable with the query
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT a.ipAddress, ")
			.append(" COUNT(a.ipAddress) as threshold ")
			.append("FROM DbParser.TbAccessAddress a ")
			.append("WHERE a.dtAccess BETWEEN ? AND ? ")
			.append("GROUP BY a.ipAddress ")
			.append("HAVING COUNT(a.ipAddress) > ? ");
		
		//return the query
		return sql.toString();
	}
	
	/**
	 * Query responsible for save information. 
	 * @return {@link String}
	 */
	public static String save() {
		//Variable with the query
		StringBuilder sql = new StringBuilder();
		
		sql.append(" INSERT INTO DbParser.TbBlockedAddress  ")
			.append("  (dtBlocked, addressIp, threshold, description) ")
			.append(" VALUES(?, ?, ?, ?) ");
		
		//return the query
		return sql.toString();
	}

}
