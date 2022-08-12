package com.javatechie.spring.camel.api.direct;

import com.javatechie.spring.camel.api.dto.Order;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

//@Component
public class OrderPostRouter extends RouteBuilder {


    @Override
    public void configure() throws Exception {


        from("direct:PostOrderRouter")
                //.unmarshal(orderDataFormat)
                .log("${body}")
                .setBody(constant("{\n" +
                        "        \n" +
                        "        \"payment\": \"WAITTING\",\n" +
                        "        \"startMoment\": \"2020-07-13T20:50:07.123450Z\",\n" +
                        "        \"endMoment\": \"2020-07-13T20:50:07.123450Z\",\n" +
                        "        \"items\": [{\n" +
                        "            \"id\": 1\n" +
                        "            \n" +
                        "        }]\n" +
                        "    }\n"))

                .log("${body}");
                //.toD("http4://localhost:8080/orders");

    }
}
