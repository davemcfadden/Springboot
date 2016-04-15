package com.hystrix.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hystrix.boot.service.HystrixService;

@RestController
public class ApplicationController {
	
	@Autowired
	HystrixService service;
	
    @RequestMapping(value = "/seconds/{seconds}", method = RequestMethod.GET)
	public String mockCall(@PathVariable Integer seconds){
    	
    	String response = null;
    	if(seconds > 0){
    		response=	service.webServiceTimeout(seconds);
		}else{
    		response=	service.webServiceException(seconds);
		}
		return response;
	}

}
