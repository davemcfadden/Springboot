package com.mongo.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.boot.service.MongoUpdate;
/**
 * 
 * @author Dave McFadden
 *
 */
@RestController
@RequestMapping(value = "/update")
public class UpdateController {
	
	
		@Autowired
		MongoUpdate mongoUpdate;
	
	
		
	    @RequestMapping(value ="/id/{id}/city/{city}", method = RequestMethod.PUT)
	    public String updateOne(@PathVariable  String id,@PathVariable  String city) {
	       return mongoUpdate.updateOne(id);
	    }
	    
	    @RequestMapping(value = "/id/{id}/city/{city}", method = RequestMethod.PUT)
	    public String updateSingleElement(@PathVariable  String id,@PathVariable  String city) {
	    	return mongoUpdate.updateSingleElement(id,city);
	    }
	    
	    @RequestMapping(value = "/city/{city}", method = RequestMethod.PUT)
	    public String updateMultiple(@PathVariable  String city) {
	    	return mongoUpdate.updateMultiple(city);
	    }
	    
	    @RequestMapping(value = "/id/{id}/city/{city}", method = RequestMethod.PUT)
	    public String upsert(@PathVariable  String id, @PathVariable String city) {
	    	return mongoUpdate.upsert(id,city);
	    }
	    
	    
}
