package xyz.tomd.cameldemos.springboot.restdsl.service;

import org.springframework.stereotype.Service;
import xyz.tomd.cameldemos.springboot.restdsl.dto.Order;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private List<Order> list = new ArrayList<>();


    @PostConstruct
    public void initDB() {
        list.add(new Order(67L, "Mobile", 5000.0));
        list.add(new Order(89L, "Book", 400.0));
        list.add(new Order(45L, "AC", 15000.0));
        list.add(new Order(67L, "Shoes", 4000.0));
    }


    public List<Order> getOrders(){
        return this.list;
    }


    public Order addOrder(Order order) {
        list.add(order);
        return order;
    }


    public Order DuplicateValue(Order order) {
        Order o = order;
        o.setPrice(order.getPrice()*2);

        list.add(o);

        return o;

    }


}
