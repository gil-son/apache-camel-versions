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

                .choice()
                        .when().jsonpath("person.middlename", true)
                        .log("Is JSON")
                        .to("direct:isJSON")
//                    .when().xpath("/person/midllename")
//                        .to("direct:isXML")
                .otherwise()
                    .to("direct:isString")
                .endChoice();

        from("direct:isJSON")
                .log("JSON Route")
                .to("direct:sendQueue");

//        from("direct:isXML")
//                .log("XML Route")
//                .to("direct:sendQueue");

                from("direct:isString")
                 .log("String Route")
                //.transform().constant("My Constant Message")
                .log(LoggingLevel.DEBUG, log, "New message received")
                .process(exchange -> {
                    String convertedMessage = exchange.getMessage().getBody() + " is converted";
                    exchange.getMessage().setBody(convertedMessage);
                }).to("direct:sendQueue");


                from("direct:sendQueue")
                        .log(" Send to Queue ${body}")
                .to("{{output.queue}}")
                .log(LoggingLevel.DEBUG, log, "Message sent to the other queue")
        .end();

    }
}
