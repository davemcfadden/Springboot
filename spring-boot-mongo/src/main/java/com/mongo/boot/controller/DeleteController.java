package com.mongo.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.boot.service.MongoDelete;
/**
 * 
 * @author Dave McFadden
 *
 */
@RestController
@RequestMapping(value = "/delete")
public class DeleteController {
	
	
		@Autowired
		MongoDelete mongoDelete;
	
	    @RequestMapping("/all")
	    public String findAll() {
	       return "s";
	    }
	    
	    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	    public String findByPrimaryKey(@PathVariable  String id) {
	       return "s";
	    }
	    
	    
}
