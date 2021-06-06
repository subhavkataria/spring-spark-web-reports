package com.subhav;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.subhav.factory.WorkFlowServiceFactory;

@SpringBootApplication
public class SparkApplication /* implements CommandLineRunner */{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SparkApplication.class);
	
	@Autowired
	private WorkFlowServiceFactory factory;

	public static void main(String[] args) {
		SpringApplication.run(SparkApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * LOGGER.info("Application started with command-line arguments: {} . \n" ,
	 * Arrays.toString(args)); String workFlow = args[0];
	 * 
	 * factory.getService(workFlow).execute(new WorkFlowBean(workFlow,null));
	 * 
	 * 
	 * }
	 */

}
