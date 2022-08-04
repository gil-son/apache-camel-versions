package com.sendmessagetomqqueue.route;

import java.net.ConnectException;

import javax.jms.JMSException;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SendMessage extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("file:files/json?noop=true&delay=5s")
		.routeId("Files-Input-Route")
        .log("${file:name} ${body}")
        
        // .to("file:files/output")
        .doTry()
			.to("activemq:INBOUND.D")
		
		.doCatch(JMSException.class, ConnectException.class)
			.log("Error to connect queue");
	}

}
