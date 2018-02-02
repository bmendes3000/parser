package com.ef.writers;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("writerParser")
public class ItemWriterParser implements ItemWriter<Object> {

	@Override
	public void write(List<? extends Object> items) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
