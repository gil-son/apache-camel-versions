package com.javatechie.spring.camel.api.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.javatechie.spring.camel.api.dto.Order;

public class FileOrderProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		Order order = exchange.getMessage().getBody(Order.class);
	
	
	}

}
