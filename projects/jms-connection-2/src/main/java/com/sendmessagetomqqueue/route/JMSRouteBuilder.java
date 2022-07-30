package com.sendmessagetomqqueue.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class JMSRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jmsComponent:queue:codeusingjava-inputqueue").process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                System.out.println(exchange.getIn().getBody());
            }
        }).to("jmsComponent:queue:codeusingjava-outputqueue");
    }

}
