package com.async.boot.service;

import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncService {
	
	final static Logger LOGGER = Logger.getLogger(AsyncService.class);
	
	@Async
	public Future<String> slowThread(String id){
		if(id.equals("1")){
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				//do something here
			}
			logRequest(id);
			return new AsyncResult<String>("Slow Thread...");
		}
		else{
			logRequest(id);
			return new AsyncResult<String>("quick Thread...");
			
		}
	}
	
	public void logRequest(String id){
		LOGGER.info("Completed processing id : "+ id + " on ThreadId : " + Thread.currentThread().getId());
	}
	
	
}