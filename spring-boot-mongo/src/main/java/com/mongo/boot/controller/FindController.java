package com.mongo.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.boot.service.MongoFind;
/**
 * 
 * @author Dave McFadden
 *
 */
@RestController
@RequestMapping(value = "/find")
public class FindController {
	
	
		@Autowired
		MongoFind mongoFind;
	
	    @RequestMapping("/all")
	    public String findAll() {
	    	List<String> list = new ArrayList<String>();
			for(Document res : mongoFind.findAll()){
				list.add(res.toJson());
			}
			return list.toString();
	    }
	    
	    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	    public String findByPrimaryKey(@PathVariable  String id) {
	    	List<String> list = new ArrayList<String>();
			for(Document res : mongoFind.findById(id)){
				list.add(res.toJson());
			}
			return list.toString();
	    }
	    
	    @RequestMapping(value = "/distinct/{key}", method = RequestMethod.GET)
	    public String findDistinctByKey(@PathVariable  String key) {
	        List<String> list = new ArrayList<String>();
	        for(String res : mongoFind.findDistinct(key)){
	          list.add(res);
	        }
	        return list.toString();
	    }
	    
	    
}
