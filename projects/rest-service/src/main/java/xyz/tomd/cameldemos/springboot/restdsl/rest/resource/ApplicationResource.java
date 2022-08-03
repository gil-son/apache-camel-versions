package xyz.tomd.cameldemos.springboot.restdsl.rest.resource;

import org.apache.camel.BeanInject;
import org.apache.camel.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;
import xyz.tomd.cameldemos.springboot.restdsl.dto.Order;
import xyz.tomd.cameldemos.springboot.restdsl.processor.OrderProcessor;
import xyz.tomd.cameldemos.springboot.restdsl.service.OrderService;

@Component
public class ApplicationResource extends RouteBuilder{

    @Autowired
    private OrderService service;

    @BeanInject
    private OrderProcessor orderProcessor;

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("servlet")
                .port(9090)
                .host("localhost")
                .bindingMode(RestBindingMode.json);


        rest()
                .get("/point")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .route()
                .setBody(constant("Point"))
                .to("direct:get-rest-resource")
                .endRest();

//        rest()
//                .get("/orders")
//                .produces(MediaType.APPLICATION_JSON_VALUE)
//                .route()
//                .setBody(() -> service.getOrders())
//                .endRest();

        rest()
                .post("/order")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .type(Order.class)
                .outType(Order.class)
                .route()
                .process(orderProcessor)
                .endRest();
    }
}
