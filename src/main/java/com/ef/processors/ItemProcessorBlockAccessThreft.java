package com.ef.processors;

import java.util.Date;

import org.springframework.batch.core.annotation.BeforeProcess;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ef.model.BlockedAddress;

@Component("processorBlockAccessThreft")
@Scope(value = "step")
public class ItemProcessorBlockAccessThreft implements ItemProcessor<BlockedAddress, BlockedAddress> {
	
	//variable for filter by threshold	
	@Value("#{jobParameters['threshold']}")
	private Integer threshold;
	
	//variable for filter by duration
	@Value("#{jobParameters['duration']}")
	private String duration;
	
	//variable for control date
	private Date dtBlock;
	
	
	@BeforeProcess
	public void beforeProcess() {
		if (dtBlock == null) {
			dtBlock = new Date();
		}
	}
	
	@Override
	public BlockedAddress process(final BlockedAddress access) throws Exception {
		//build message for save 
		access.setDescription(messageBlock(access));
		access.setDtBlock(dtBlock);
		
		//send object for writer
		return access;
	}
	/**
	 * Method responsible for build message of block
	 * @param access 
	 * @return
	 */
	private String messageBlock(final BlockedAddress access) {
		//create variable for message return 
		StringBuilder message = new StringBuilder();
		
		message.append("Ip address: ")
			.append(access.getAddressIp())
			.append(" blocked for exceeding the limit of ")
			.append(this.threshold)
			.append(" ")
			.append(this.duration)
			.append(" accesses");
		
		//return the build message
		return message.toString();
	}

}
