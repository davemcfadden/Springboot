package com.async.boot.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.async.boot.service.AsyncService;
/**
 * 
 * @author Dave McFadden
 *
 */
@RestController
public class ApplicationController {
	
	
		@Autowired
		AsyncService service;
		
	    @RequestMapping("/{id}")
	    public String index(@PathVariable String id) {
	        Future<String> returnVal= service.slowThread(id);
	        String result = null;
	        try {
				result= returnVal.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				result = e.toString();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				result = e.toString();
			}
	        
	        return result;
	    }
	    
	    
	    
}
