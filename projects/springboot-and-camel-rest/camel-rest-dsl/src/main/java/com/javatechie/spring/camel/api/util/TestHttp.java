package com.javatechie.spring.camel.api.util;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpMethods;
import org.springframework.stereotype.Component;

@Component
public class TestHttp extends RouteBuilder{
	
	
	@Override
	public void configure() throws Exception {


		from("timer://foo?fixedRate=true&delay=0&period=10000")


				.removeHeader(Exchange.HTTP_METHOD)
				.setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.GET))
				.toD("http4://localhost:8080/sales?")
				.log("${body}")
				.log("Response code from the operation was: ${header.CamelHttpResponseCode}");


	}
	
}
