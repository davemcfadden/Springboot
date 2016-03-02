package com.camel.boot;


import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
/**
 * 
 * @author Dave McFadden
 *
 */
@SpringBootApplication
@ImportResource({"classpath:/config/applicationContext.xml"})
public class Application {
		final static Logger LOGGER = Logger.getLogger(Application.class);
		
		public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
		}
}
