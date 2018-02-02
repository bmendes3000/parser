package com.ef.validators;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ef.model.TypeDuration;
import com.ef.utils.ArgumentsParams;

public class ParamsFilterValidator implements Validator {

	@Override
	public boolean supports(final Class<?> clazz) {
		return String[].class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors error) {
		//convert to validation arguments
		String[] argsCommand = (String[]) obj;
		//Check if all arguments was sent in line command
		if (argsCommand.length < 4) {
			error.reject("0", "Please! send everything arguments to program execution");
			return;
		}
		//get all parameter to validation
		Map<String, String> values = ArgumentsParams.getParams(argsCommand);
		
		//Check the key access log
		String value = (String) values.get("accesslog");
		if (value.isEmpty()) {
			error.reject("1", "Send path to access log");
		} else if (!new File(value).exists()) {
			error.reject("1", "File Not Found.");
		}
		
		//check start date
		value = (String) values.get("startDate");
		if (value.isEmpty()) {
			error.reject("2", "Send date for filter");
		} else {
			try {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
	            Date date = sdf.parse(value);
	            if (!value.equals(sdf.format(date))) {
	            	error.reject("2", "The format date isn't valid");
	            }
	        } catch (ParseException ex) {
	            error.reject("2", "Error on convert the date value");
	        }
		}
		//check duration 
		value = (String) values.get("duration");
		if (value.isEmpty()) {
			error.reject("Send duration for filter");
		} else if (TypeDuration.valueOfCode(value) == null) {
			error.reject("3", "The value sent in the duration parameter isn't correct");
		}
		
		//check threshold
		value = (String) values.get("threshold");
		if (new Integer(value).intValue() < 0) {
			error.reject("4", "The value sent in the threshold parameter isn't correct");
		}
		
		
	}

}
