package com.ef;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

import com.ef.validators.ParamsFilterValidator;

@Configuration
@ImportResource({"classpath:/com/spring/jobs/parser-job.xml"})
public class Parser {
	/*
	 * variable for log
	 */
	private final static Logger log = LogManager.getLogger(Parser.class);
 
	/**
	 * Method for start application
	 * @param args {@link String}
	 */
	public static void main(String[] args) {
		Parser parser = new Parser();
		//call method for start app. 
		parser.run(args);
	}
	
	/**
	 * Method for start job processor in spring batch.
	 * @param args {@link String}
	 */
	private void run(final String[] args) {
		try {
			//context variable 
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			
			//register and refresh parser application in context
			context.register(Parser.class);
			context.refresh();
			
			//It check parameters send by command line
			ParamsFilterValidator validator = new ParamsFilterValidator();
			
			//map for binding result
			Map<String,String> map = new HashMap<String,String>(); 
			MapBindingResult err = new MapBindingResult(map, String.class.getName());
			
			//calling the validate
			validator.validate(args, err);
			
			//check amount of error
			if(err.hasErrors()) {
				List<ObjectError> list = err.getAllErrors();
				for(ObjectError objErr : list){
					log.error(objErr.getDefaultMessage());
				}
				
				log.info("The application will be stoped");
				//stop the app
				System.exit(0);
			}
			
			//load launcher
			JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
			
			//load parser in file parser-job
			Job job = (Job) context.getBean("loadParseJob");
			
			
			//run job 
			JobExecution exec = launcher.run(job, new JobParameters());
			
			//get status execution
			log.info("The application finished with successful, status code [" + exec.getStatus() + "]");
			
			//close context
			context.close();
			
		} catch (JobExecutionAlreadyRunningException | JobRestartException | 
				JobInstanceAlreadyCompleteException  | 
				JobParametersInvalidException e) {
			log.error("Application execution error", e);
		} catch (Exception e) {
			log.error("Fatal error in application execution", e);
		}
	}
}
