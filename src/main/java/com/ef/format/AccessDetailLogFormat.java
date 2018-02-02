package com.ef.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.ef.model.AccessDetailLog;
/**
 * Class responsible for format line to access detail class
 * @author bruno 
 *
 */
public class AccessDetailLogFormat {
	
	// Date format for date
	private final static SimpleDateFormat dtFormat = new 
			SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
	
	/**
	 * Method responsible for parse line to class detail
	 * @param line {@link String}
	 * @return {@link AccessDetailLog}
	 */
	public static AccessDetailLog parse(final String line) 
			throws	ParseException {
		
		//variable with information split on tokens 
		String[] inf = line.split("|");
		
		//Variable for return 
		AccessDetailLog detail = new AccessDetailLog();
		detail.setDtAccess(dtFormat.parse(inf[0]));
		detail.setAddressIp(inf[1]);
		detail.setMethodHttp(inf[3]);
		detail.setReturnCode(inf[4]);
		detail.setLocalAccess(inf[5]);
		
		return detail;
	}

}
