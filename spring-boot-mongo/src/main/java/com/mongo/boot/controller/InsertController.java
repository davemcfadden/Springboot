package com.mongo.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		/**http://localhost:8080/insert
		 * 
		 * @param {_id:123, name:"test", city:"belfast"}
		 * @return null
		 */
		 @RequestMapping(value = "/", method = RequestMethod.POST)
		    public long insert(@RequestBody String json) {
			 return mongoInsert.persistMessage(json);
		    }
	    
	    
}
