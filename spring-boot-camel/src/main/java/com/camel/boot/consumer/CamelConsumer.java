package com.camel.boot.consumer;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.camel.boot.object.SimpleObject;
/**
 * 
 * @author Dave McFadden
 *
 */
@Component("camelConsumer")
public class CamelConsumer implements Processor  {

	final static Logger LOGGER = Logger.getLogger(CamelConsumer.class);

	
	@Override
	public void process(Exchange exchange) throws Exception {
		LOGGER.info("Received csv file");
		List<SimpleObject> object = null;
		if(exchange.getIn().getBody() instanceof List){
			 object = (List<SimpleObject>) exchange.getIn().getBody();
		}
		
		for(SimpleObject s: object){
			LOGGER.info("Message body from camel is : " + 	s.toString());
		}
	}

}
