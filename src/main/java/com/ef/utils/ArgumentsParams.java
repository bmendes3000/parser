package com.ef.utils;

import java.util.HashMap;
import java.util.Map;

public class ArgumentsParams {
	
	/**
	 * Method responsible for separate value and keys.
	 * @param arg {@link String}
	 * @return {@link Map}
	 */
	public final static Map<String, Object> getParam(final String arg) {
		//Replace and split value object for get value and key
		String[] obj = arg.replace("-", "").split("=");
		//Create object to return 
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(obj[0], obj[1]);
		
		//return the value 
		return result;
	}
	
	/**
	 * Method responsible for separate value and keys.
	 * @param arg {@link String}
	 * @return {@link Map}
	 */
	public final static Map<String, Object> getParams(final String[] args) {
		//Create object to return 
		Map<String, Object> result = new HashMap<String, Object>();
		//loop for parameter
		for (String arg : args) {
			//Replace and split value object for get value and key
			String[] obj = arg.replace("-", "").split("=");
			//include put 
			result.put(obj[0], obj[1]);
		}
		//return the value 
		return result;
	}

}
