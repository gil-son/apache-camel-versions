package com.basic01.create_route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import static org.apache.camel.LoggingLevel.INFO;

@Component
public class ExampleRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		// https://viacep.com.br/ws/01001000/json/
		
		from("timer:foo?period=10000")
		.routeId("Main Route")
		
		.log(INFO, this.log, "This will be first message...")
		.to("direct:named-http");
		
		
		from("direct:named-http")
		// .log("Id: ${id}  Body: ${body}")
		.log(INFO, this.log, "This will be second message...")
		// .to("log:test")
		// .log("test")
		.to("https://viacep.com.br/ws/01001000/json/")
		.log(INFO, this.log, "${body}");
	}
}
