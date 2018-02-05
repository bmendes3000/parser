package com.ef.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ef.model.AccessDetailLog;
import com.ef.model.FilterParams;
import com.ef.model.TypeDuration;

public class FilterParamsFormat {
	
	// Date format for date
		private final static SimpleDateFormat dtFormat = new 
				SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
		
		/**
		 * Method responsible for parse line to class detail
		 * @param line {@link String}
		 * @return {@link AccessDetailLog}
		 */
		public static FilterParams parse(final String startDate, 
				final Integer threshold, final String duration)	
						throws	ParseException {
			//convert values
			FilterParams params = new FilterParams();
			params.setStartDate(dtFormat.parse(startDate));
			params.setThreshold(threshold);
			params.setEndDate(calculateEndDate(
					params.getStartDate(), 
					TypeDuration.valueOfCode(duration)));
			//return the parameters
			return params;
		}
		/**
		 * Method responsible for calculate end date for filter
		 * @param type {@link TypeDuration}
		 * @return {@link Date}
		 */
		private static Date calculateEndDate(
				final Date start, final TypeDuration type) {
			//create variable of date
			Calendar end = Calendar.getInstance();
			end.setTime(start);
			
			//check type duration
			if (TypeDuration.Daily.equals(type)) {
				end.add(Calendar.DAY_OF_MONTH, 1);
			} else if (TypeDuration.Hourly.equals(type)) {
				end.add(Calendar.HOUR_OF_DAY, 1);
			}
			
			//return the parameter
			return end.getTime();
			
		}
		
		

}
