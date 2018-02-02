package com.ef.processors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ef.model.AccessDetailLog;

@Component("processorParser")
@Scope(value = "step")
public class ItemProcessorParser implements ItemProcessor<AccessDetailLog, Object> {
	
	@Value("#{jobParameters['paramsFilter']}")
	private String filter;
	
	@Override
	public Object process(AccessDetailLog item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
