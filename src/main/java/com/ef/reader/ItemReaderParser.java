package com.ef.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

@Component("readerParser")
@Scope(value = "step")
public class ItemReaderParser implements ItemReader<String> {
	//variable for log
	private final static Logger log = LogManager.getLogger(
			ItemReaderParser.class);
	
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
			log.debug("Preparer to read log file");
			//load variable with the buffer of the file.
			buffer = new BufferedReader(new FileReader(accessLog));
			//load first line
			line = buffer.readLine();
			log.debug("Reader ready for reading log file");
		}
		
	}

	@Override
	public String read() throws Exception, 
								UnexpectedInputException, 
								ParseException, 
								NonTransientResourceException {
		log.debug("checking the selected line");
		if (this.line != null && !this.line.isEmpty()) {
			//send information to item process
			return this.line;
		}
		return null;
	}
	/**
	 * Method to get next line
	 * @throws IOException
	 */
	@AfterRead
	private void afterReader() throws IOException {
		log.debug("get next file line");
		this.line = buffer.readLine();
	}
	/**
	 * Method responsible for close buffer.
	 * @throws Exception
	 */
	@AfterJob
	private void afterJobReader() throws Exception {
		log.debug("Closing the buffer to allow access to the log file");
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
