package com.hystrix.boot.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


/**
 * {@link https://github.com/Netflix/Hystrix/wiki/Configuration}
 * 
 * @author n0237982
 *
 */
@Service
public class HystrixService {
	
	
	final static String RUNEXP = "runtime";
	final static String TIMEOUT = "timeout";
	
	private void delay(Integer seconds){
		Integer delay = Math.multiplyExact(seconds, 1000);
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	private void throwStandardException(String exceptionType){
		if(exceptionType.equals(RUNEXP)){
			throw new RuntimeException();
		}
		/*else if(exceptionType.equals(TIMEOUT)) {
			throw new TimeoutException();
		}
		else{
			throw new Exception();
		}*/
	}
	
	
	@HystrixCommand(fallbackMethod = "recoverMethod")
	public String webServiceException(Integer seconds){
		
		throwStandardException(RUNEXP);
		return "Web service method";
	}
    
	
	 @HystrixCommand(fallbackMethod = "recoverMethod", commandProperties = {
	            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="500")
	    })
    public String webServiceTimeout(Integer seconds){
		if(seconds > 0){
			delay(seconds);
		}
		return "Web service method Timeout";
	}
	
	
	public String recoverMethod(Integer seconds){
		return "Reached recovery fallover method";
	}
}
