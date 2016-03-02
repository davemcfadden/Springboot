package com.mongo.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.boot.service.MongoInsert;
/**
 * 
 * @author Dave McFadden
 *
 */
@RestController
@RequestMapping(value = "/insert")
public class InsertController {
	
	
		@Autowired
		MongoInsert mongoInsert;
	

	    
	    
}
