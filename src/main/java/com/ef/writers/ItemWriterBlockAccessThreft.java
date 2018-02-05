package com.ef.writers;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ef.model.BlockedAddress;
import com.ef.services.IAccessFilterService;

@Component("writerBlockAccessThreft")
@Scope(value = "step")
public class ItemWriterBlockAccessThreft implements ItemWriter<BlockedAddress> {
	
	//variable for log
	private final static Logger log = LogManager.getLogger(
			ItemWriterBlockAccessThreft.class);
	
	//variable of service
	@Autowired
	private IAccessFilterService service;
	
	@Override
	public void write(List<? extends BlockedAddress> items) throws Exception {
		log.debug("Writer preparer to save information");
		log.info("########Ips list Blocked ################");
		for (BlockedAddress block : items ) {
			log.debug("Call service responsible for save information");
			
			//send information to service layer
			service.save(block);
			
			//print the address block on console
			log.info(block.getDescription());
			
			
		}
		
	}
	

}
