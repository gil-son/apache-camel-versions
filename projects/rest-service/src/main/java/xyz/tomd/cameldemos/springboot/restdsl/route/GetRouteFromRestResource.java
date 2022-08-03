package xyz.tomd.cameldemos.springboot.restdsl.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class GetRouteFromRestResource extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:get-rest-resource")
                .log("${body}");

    }
}
