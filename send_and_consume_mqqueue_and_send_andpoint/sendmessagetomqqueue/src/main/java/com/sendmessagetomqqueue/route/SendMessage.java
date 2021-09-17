package com.sendmessagetomqqueue.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SendMessage extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("file:files/input")
        .log("${body}")
        .to("file:files/output")
		.to("activemq:new-activemq-queue");
		
	}

}
