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
	
	
		//http://localhost:8080/update/updateone/id/01011
	    @RequestMapping(value ="/updateone/id/{id}", method = RequestMethod.PUT)
	    public String updateOne(@PathVariable  String id) {
	       return mongoUpdate.updateOne(id);
	    }
	    
		//http://localhost:8080/update/updateone/id/01011/city/MANCHESTER
	    @RequestMapping(value = "/single/id/{id}/city/{city}", method = RequestMethod.PUT)
	    public String updateSingleElement(@PathVariable  String id,@PathVariable  String city) {
	    	return mongoUpdate.updateSingleElement(id,city);
	    }
	    
		//http://localhost:8080/update/updatemultiple/city/CHESTER
	    @RequestMapping(value = "/updatemultiple/city/{city}", method = RequestMethod.PUT)
	    public String updateMultiple(@PathVariable  String city) {
	    	return mongoUpdate.updateMultiple(city);
	    }
	    
		//http://localhost:8080/update/upsert/id/01011/city/BELFAST
	    @RequestMapping(value = "/upsert/id/{id}/city/{city}", method = RequestMethod.PUT)
	    public String upsert(@PathVariable  String id, @PathVariable String city) {
	    	return mongoUpdate.upsert(id,city);
	    }
	    
	    
}
