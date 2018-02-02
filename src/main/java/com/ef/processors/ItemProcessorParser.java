package com.ef.processors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ef.model.Parameters;

@Component("processorParser")
@Scope(value = "step")
public class ItemProcessorParser implements ItemProcessor<Object, Object> {
	
	@Value("#{jobParameters['paramsFilter']}")
	private Parameters filter;
	
	@Override
	public Object process(Object item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the filter
	 */
	public final Parameters getFilter() {
		return filter;
	}

	/**
	 * @param value the filter to set
	 */
	public final void setFilter(final Parameters value) {
		this.filter = value;
	}
	
	

}
