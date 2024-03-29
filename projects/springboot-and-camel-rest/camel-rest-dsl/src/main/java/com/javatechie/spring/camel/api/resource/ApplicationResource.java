package com.javatechie.spring.camel.api.resource;

import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.javatechie.spring.camel.api.dto.Order;
import com.javatechie.spring.camel.api.processor.DuplicateValueOrderProcessor;
import com.javatechie.spring.camel.api.processor.OrderProcessor;
import com.javatechie.spring.camel.api.service.OrderService;

//@Component
public class ApplicationResource extends RouteBuilder{

	@Autowired
	private OrderService service;
	
	@BeanInject
	private OrderProcessor orderProcessor;
	
	@BeanInject
	private DuplicateValueOrderProcessor duplicateValueOrderProcessor;

	JacksonDataFormat orderDataFormat = new JacksonDataFormat(Order.class);


	@Override
	public void configure() throws Exception {

		restConfiguration()
			.component("servlet")
			.port(9090)
			.host("localhost")
			.bindingMode(RestBindingMode.json);
		
		
		rest()
		.get("/hello-world")
		.produces(MediaType.APPLICATION_JSON_VALUE)
		.route()
		.setBody(constant("Welcome to java techie"))
		.endRest();
		
		rest()
		.get("/orders")
		.produces(MediaType.APPLICATION_JSON_VALUE)
		.route()
		.setBody(() -> service.getOrders())
		.endRest();
		
		rest()
		.post("/order")
		.consumes(MediaType.APPLICATION_JSON_VALUE)

		.type(Order.class)
		.outType(Order.class)
		.route()
		.process(orderProcessor)
				.marshal(orderDataFormat)
				.to("direct:PostOrderRouter")
		.endRest();
		
		rest()
		.post("/duplicate-value")
		.consumes(MediaType.APPLICATION_JSON_VALUE)
		.type(Order.class)
		.outType(Order.class)
		.route()
		.process(duplicateValueOrderProcessor)
		.endRest();
		
	}

}
