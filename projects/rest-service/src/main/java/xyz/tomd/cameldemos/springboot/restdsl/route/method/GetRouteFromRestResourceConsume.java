package xyz.tomd.cameldemos.springboot.restdsl.route.method;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;



@Component
public class GetRouteFromRestResourceConsume extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:get-rest-resource-consume")
                .log("GetRouteFromRestResourceConsume")
                .log("${body}")
                //.to("activemq:test-activemq-queue");
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        log.info("{}",exchange.getMessage().getHeaders());
                        log.info("{}",exchange.getMessage().getHeader("CamelHttpMethod"));
                    }
                })
        .choice()
                .when(header("CamelHttpMethod").isEqualTo(Boolean.TRUE))
                    .log("true")
                .otherwise()
                    .log("false");
//                .to("direct:access-uri");

//        from("direct:access-uri")

                // Set up some variables for our HTTP request - we'll use these later!
//                .setHeader("cep", constant("01001000"))


                // Set the body to null, because it is required by the GitHub API.
                // .setBody(simple("${null}"))

                // Now invoke the GitHub API with the null Body
                // PUT /user/starred/:owner/:repo
//                .toD("http://localhost:8080/sales?minDate=2021-11-01&maxDate=2021-12-31")

//                .log("Response code from the operation was: ${header.CamelHttpResponseCode}");

    }
}
