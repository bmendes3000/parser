package com.ef.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

import com.ef.model.AccessDetailLog;
/**
 * Class responsible for format line to access detail class
 * @author bruno 
 *
 */
public class AccessDetailLogFormat {
	
	// Date format for date
	private final static SimpleDateFormat dtFormat = new 
			SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	/**
	 * Method responsible for parse line to class detail
	 * @param line {@link String}
	 * @return {@link AccessDetailLog}
	 */
	public static AccessDetailLog parse(final String line) 
			throws	ParseException {
		
		//variable with information split on tokens 
		StringTokenizer inf = new StringTokenizer(line, "|");
		
		//Variable for return 
		AccessDetailLog detail = new AccessDetailLog();
		detail.setDtAccess(dtFormat.parse(inf.nextToken()));
		detail.setAddressIp(inf.nextToken());
		detail.setMethodHttp(inf.nextToken());
		detail.setReturnCode(inf.nextToken());
		detail.setLocalAccess(inf.nextToken());
		
		return detail;
	}

}
