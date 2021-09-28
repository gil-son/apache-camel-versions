package com.basic01.decision_route;

import static org.apache.camel.LoggingLevel.INFO;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class DecisionFile extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		
		from("file:files?delay=5s&noop=true")
		.log("${body}")
			
			.choice()
			
			.when(body().contains("site01"))
				.to("https://viacep.com.br/ws/05050020/json/")
				.log(INFO, this.log, "${body}")
		
				.when(body().contains("site02"))
				.to("https://viacep.com.br/ws/05055020/json/")
				.log(INFO, this.log, "${body}")
				
				.otherwise()
				.to("https://viacep.com.br/ws/01001000/json/")
				.log(INFO, this.log, "${body}");
			
	}

}
