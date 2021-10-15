package com.basic01.create_route;

import static org.apache.camel.LoggingLevel.INFO;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

import com.basic01.entities.BrazilAddress;

@Component
public class BrazilHttpRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		JacksonDataFormat addressesDataFormat = new JacksonDataFormat(BrazilAddress.class);
		
		from("direct:named-http")
			.log(INFO, this.log, "This will be second message...")
			.to("https://viacep.com.br/ws/01001000/json")
			.unmarshal(addressesDataFormat)
			.log(INFO, this.log, "Deserialized Data: ${body}")
			.marshal(addressesDataFormat)
			.log(INFO, this.log, "Serialized Data: ${body}");
	}

}
