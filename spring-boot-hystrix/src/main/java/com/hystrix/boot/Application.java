package com.hystrix.boot;


import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import com.hystrix.boot.service.HystrixService;
/**
 * 
 * @author Dave McFadden
 *
 */
@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
public class Application{
		public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
		}

		/*public static void main(String [] arg0) {
			Application app = new Application();
			app.mockWebServiceCall();
			
		}*/
		
		/*private void mockWebServiceCall(){
			HystrixService service = new HystrixService();
			String responseOne = null;
			String responseTwo = null;
			try {
				responseOne = service.webService(0);
			} catch (Exception e) {
				LOGGER.info("Should not fail " + e);
			}
			
			try {
				//timeout
				responseTwo = service.webService(10);
			} catch (Exception e) {
				LOGGER.info("Should not fail");
			}
			
			LOGGER.info(responseOne);
			LOGGER.info(responseTwo);
			
			
		}*/
}
