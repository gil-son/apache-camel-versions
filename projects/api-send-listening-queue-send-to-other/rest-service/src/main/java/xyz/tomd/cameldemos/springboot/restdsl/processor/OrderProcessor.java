package xyz.tomd.cameldemos.springboot.restdsl.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.tomd.cameldemos.springboot.restdsl.dto.Order;
import xyz.tomd.cameldemos.springboot.restdsl.service.OrderService;


@Component
public class OrderProcessor implements Processor{

    @Autowired
    private OrderService service;

    @Override
    public void process(Exchange exchange) throws Exception {

        service.addOrder(exchange.getIn().getBody(Order.class));

    }

}
