package com.ef.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.AfterRead;
import org.springframework.batch.core.annotation.BeforeRead;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ef.format.AccessDetailLogFormat;
import com.ef.model.AccessDetailLog;

@Component("readerParser")
@Scope(value = "step")
public class ItemReaderParser implements ItemReader<AccessDetailLog> {
	
	@Value("#{jobParameters['accesslog']}")
	private String accessLog;
	
	//variable with buffer of the file log
	private BufferedReader buffer;
	
	//variable with line select
	private String line;
	
	/**
	 * Method for load variables's control 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@BeforeRead
	private void beforeRead() throws FileNotFoundException,
							IOException {
		if (buffer == null) {
			//load variable with the buffer of the file.
			buffer = new BufferedReader(new FileReader(accessLog));
			//load first line
			line = buffer.readLine();
		}
	}

	@Override
	public AccessDetailLog read() throws Exception, 
								UnexpectedInputException, 
								ParseException, 
								NonTransientResourceException {
		
		if (this.line != null && !this.line.isEmpty()) {
			//send information to item process
			return AccessDetailLogFormat.parse(this.line);
		}
		return null;
	}
	/**
	 * Method to get next line
	 * @throws IOException
	 */
	@AfterRead
	private void afterReader() throws IOException {
		//get next line of the file.
		this.line = buffer.readLine();
	}
	/**
	 * Method responsible for close buffer.
	 * @throws Exception
	 */
	@AfterJob
	private void afterJobReader() throws Exception {
		//close the buffer
		this.buffer.close();
	}
	
	/**
	 * @return the accessLog
	 */
	public final String getAccessLog() {
		return accessLog;
	}

	/**
	 * @param value the accessLog to set
	 */
	public final void setAccessLog(final String value) {
		this.accessLog = value;
	}

}
