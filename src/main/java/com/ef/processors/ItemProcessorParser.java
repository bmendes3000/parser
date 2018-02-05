package com.ef.processors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ef.format.AccessDetailLogFormat;
import com.ef.model.AccessDetailLog;

@Component("processorParser")
@Scope(value = "step")
public class ItemProcessorParser implements ItemProcessor<String, AccessDetailLog> {
	//variable for log
	private final static Logger log = LogManager.getLogger(
			ItemProcessorParser.class);

	
	@Override
	public AccessDetailLog process(final String line) throws Exception {
		log.debug("Transform line for object access detail");
		//transform line of the file to object 
		AccessDetailLog detail = AccessDetailLogFormat.parse(line);
		

		log.debug("checking primary key item");
		if (detail.getDtAccess() == null) {
			log.error("The date of access is null, please check " + detail.toString());
			
		}
		if (detail.getLocalAccess() == null) {
			log.error("The ip of access is null, please check " + detail.toString());
		}

		log.debug("Process finally, send information for writer");
		//send object for writer
		return detail;
	}

}
