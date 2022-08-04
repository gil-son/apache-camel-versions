package xyz.tomd.cameldemos.springboot.restdsl.route.method;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class GetRouteFromRestResourceConsume extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:get-rest-resource-consume")
                .log("GetRouteFromRestResourceConsume")
                .log("${body}");

    }
}
