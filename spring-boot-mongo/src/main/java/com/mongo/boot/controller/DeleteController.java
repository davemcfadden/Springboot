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
	
		
		//http://localhost:8080/delete/id/0101199
	    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
	    public void deleteByPrimaryKey(@PathVariable  String id) {
	       mongoDelete.delete(id);
	    }
	    
	    //http://localhost:8080/delete/
	    @RequestMapping(value = "/", method = RequestMethod.DELETE)
	    public void deleteAll() {
	       mongoDelete.deleteAll();
	    }
}
	    
