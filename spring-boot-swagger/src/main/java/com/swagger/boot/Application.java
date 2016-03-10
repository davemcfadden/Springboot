package com.swagger.boot;


import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author Dave McFadden
 *
 */
@SpringBootApplication
@EnableSwagger2
public class Application {
		final static Logger LOGGER = Logger.getLogger(Application.class);
		
		public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
		}
}
