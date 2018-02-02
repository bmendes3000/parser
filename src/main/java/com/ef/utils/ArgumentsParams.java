package com.ef.utils;

import java.util.HashMap;
import java.util.Map;

public class ArgumentsParams {
	
	/**
	 * Method responsible for separate value and keys.
	 * @param arg {@link String}
	 * @return {@link Map}
	 */
	public final static Map<String, String> getParam(final String arg) {
		//Replace and split value object for get value and key
		String[] obj = arg.replace("--", "").split("=");
		//Create object to return 
		Map<String, String> result = new HashMap<String, String>();
		result.put(obj[0], obj[1]);
		
		//return the value 
		return result;
	}
	
	/**
	 * Method responsible for separate value and keys.
	 * @param arg {@link String}
	 * @return {@link Map}
	 */
	public final static Map<String, String> getParams(final String[] args) {
		//Create object to return 
		Map<String, String> result = new HashMap<String, String>();
		//loop for parameter
		for (String arg : args) {
			//Replace and split value object for get value and key
			String[] obj = arg.replace("--", "").split("=");
			//include put 
			result.put(obj[0], obj[1]);
		}
		//return the value 
		return result;
	}

}
