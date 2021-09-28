package com.basic01.create_route;

import static org.apache.camel.LoggingLevel.INFO;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class HttpRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:named-http")
		// .log("Id: ${id}  Body: ${body}")
		.log(INFO, this.log, "This will be second message...")
		// .to("log:test")
		// .log("test")
		.to("https://viacep.com.br/ws/01001000/json/")
		.log(INFO, this.log, "${body}");
		
	}

}
