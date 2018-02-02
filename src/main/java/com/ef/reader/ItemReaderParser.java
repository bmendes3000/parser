package com.ef.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.ef.model.Parameters;

@Component("readerParser")
public class ItemReaderParser implements ItemReader<Parameters> {
	
	
	
	
	@Override
	public Parameters read() throws Exception, 
								UnexpectedInputException, 
								ParseException, 
								NonTransientResourceException {
		// TODO Auto-generated method stub
		return null;
	}

}
