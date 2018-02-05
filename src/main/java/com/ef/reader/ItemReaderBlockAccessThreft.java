package com.ef.reader;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.AfterRead;
import org.springframework.batch.core.annotation.BeforeRead;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ef.format.FilterParamsFormat;
import com.ef.model.BlockedAddress;
import com.ef.model.FilterParams;
import com.ef.services.IAccessFilterService;

@Component("readerBlockAccessThreft")
@Scope(value = "step")
public class ItemReaderBlockAccessThreft implements ItemReader<BlockedAddress>{
	//variable for filter by date 
	@Value("#{jobParameters['startDate']}")
	private String startDate;
	
	//variable for filter by threshold	
	@Value("#{jobParameters['threshold']}")
	private Integer threshold;
	
	//variable for filter by duration
	@Value("#{jobParameters['duration']}")
	private String duration;
	
	//variable for get next collection
	private Integer control;
	
	//variable with collection address blocked
	List<BlockedAddress> addresses;
	
	//variable of service
	@Autowired
	private IAccessFilterService service;
	
	@BeforeRead
	private void beforeRead() throws SQLException,
					ParseException {
		if (this.addresses == null) {
			//format the values for service
			FilterParams params = FilterParamsFormat.parse(
					startDate, threshold, duration);
			
			//get all address for block
			this.addresses = service.findByParams(params);
			
			//clear control variable
			this.control = 0;
		}
	}
	
	@Override
	public BlockedAddress read() throws Exception, 
							UnexpectedInputException, 
							ParseException, 
							NonTransientResourceException {
		
		if (this.control < this.addresses.size() -1) {
			return this.addresses.get(this.control);
		}
		
		return null;
	}
	
	@AfterRead
	private void afterReader() throws IOException {
		//increment control for get next collection
		this.control++;
	}
	
	@AfterJob
	private void afterJob() {
		//clear list
		this.addresses = null;
	}
	
}
