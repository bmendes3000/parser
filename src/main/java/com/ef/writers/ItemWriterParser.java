package com.ef.writers;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ef.model.AccessDetailLog;
import com.ef.services.IFileLogService;

@Component("writerParser")
public class ItemWriterParser implements ItemWriter<AccessDetailLog> {
	//variable for log
	private final static Logger log = LogManager.getLogger(
			ItemWriterParser.class);
	//service's log file
	@Autowired
	private IFileLogService service;
	
	@Override
	public void write(final List<? extends AccessDetailLog> items) 
			throws Exception {
		log.debug("Writer preparer to save information");
		for (AccessDetailLog detail : items ) {
			log.debug("Call service responsible for save information");
			//send information to service layer
			service.save(detail);
		}
	}

}
