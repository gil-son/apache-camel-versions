package com.receivemessagefrommqqueue.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ReceiveMessage extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("activemq:test-activemq-queue")
		.log("Message ${body}")
		.to("log:com.receivemessagefrommqqueue?level=TRACE&showAll=true&multiline=true");
		
	
	}

}
