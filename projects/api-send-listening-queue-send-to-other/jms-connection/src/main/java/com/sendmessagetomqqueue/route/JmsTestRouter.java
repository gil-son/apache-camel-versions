package com.sendmessagetomqqueue.route;


import lombok.extern.slf4j.Slf4j;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JmsTestRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        System.out.println("Configuring route");

        from("{{input.queue}}")
                //.transform().constant("My Constant Message")
                .log("${body}")
                //.log(LoggingLevel.DEBUG, log, "New message received")
                .log("New message received")
                .process(exchange -> {
                    //String convertedMessage = exchange.getMessage().getBody() + " is converted";
                    exchange.getMessage().setBody(exchange.getMessage().getBody());
                })
                .to("{{output.queue}}")
                .log("Message sent to the other queue")
                //.log(LoggingLevel.DEBUG, log, "Message sent to the other queue")
        .end();

        from("{{output.queue}}")
                .log("${body}")
                //.log("API")
                //.to("direct:route-resources")
                .end();


    }
}
