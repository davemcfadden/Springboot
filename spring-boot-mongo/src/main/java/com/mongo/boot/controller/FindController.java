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
	
		//http://localhost:8080/findall
	    @RequestMapping("/all")
	    public String findAll() {
	    	List<String> list = new ArrayList<String>();
			for(Document res : mongoFind.findAll()){
				list.add(res.toJson());
			}
			return list.toString();
	    }
	    
	    //http://localhost:8080/find/id/01011
	    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	    public String findByPrimaryKey(@PathVariable  String id) {
	    	List<String> list = new ArrayList<String>();
			for(Document res : mongoFind.findById(id)){
				list.add(res.toJson());
			}
			return list.toString();
	    }
	    
	    //http://localhost:8080/find/id/greater/01010
	    @RequestMapping(value = "/id/greater/{id}", method = RequestMethod.GET)
	    public String findByIdGreaterThan(@PathVariable  String id) {
	    	List<String> list = new ArrayList<String>();
			for(Document res : mongoFind.findByIdGreaterThan(id)){
				list.add(res.toJson());
			}
			return list.toString();
	    }
	    
	    
	    
	    //TODO change method to receive a json body with a number of ids
	    //http://localhost:8080/find/firstid/01035/secondid/01033
	    @RequestMapping(value = "/firstid/{idOne}/secondid/{idTwo}", method = RequestMethod.GET)
	    public String findIdIn(@PathVariable  String idOne,@PathVariable  String idTwo) {
	    	List<String> requestIds = new ArrayList<String>();
	    	requestIds.add(idOne);
	    	requestIds.add(idTwo);
	    	List<String> list = new ArrayList<String>();
			for(Document res : mongoFind.findIdIn(requestIds)){
				list.add(res.toJson());
			}
			return list.toString();
	    }
	    
	    
	    //http://localhost:8080/find/id/01011/city/HADLEY
	    @RequestMapping(value = "/id/{id}/city/{city}", method = RequestMethod.GET)
	    public String findByIdAndCity(@PathVariable  String id,@PathVariable  String city) {
	    	List<String> list = new ArrayList<String>();
			for(Document res : mongoFind.findByIdAndCity(id,city)){
				list.add(res.toJson());
			}
			return list.toString();
	    }
	    
	    //http://localhost:8080/find/id/01011/projection
	    @RequestMapping(value = "/id/{id}/projection", method = RequestMethod.GET)
	    public String findByIdChangeResult(@PathVariable  String id) {
	    	List<String> list = new ArrayList<String>();
			for(Document res : mongoFind.findByIdChangeResult(id)){
				list.add(res.toJson());
			}
			return list.toString();
	    }
	    
	    //http://localhost:8080/find/distinct/city
	    @RequestMapping(value = "/distinct/{key}", method = RequestMethod.GET)
	    public String findDistinctByKey(@PathVariable  String key) {
	        List<String> list = new ArrayList<String>();
	        for(String res : mongoFind.findDistinct(key)){
	          list.add(res);
	        }
	        return list.toString();
	    }
	    
	    //http://localhost:8080/find/findone
	    @RequestMapping(value = "/findone", method = RequestMethod.GET)
	    public String findOne() {
	        return mongoFind.findOne().toString();
	    }
	    
	  //http://localhost:8080/find/findone/01011
	    @RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
	    public String findOne(@PathVariable  String id) {
	    	 return mongoFind.findOne(id);
	    }
	    
	    
	    
	    
}
