package com.order.controllers;

import com.order.dto.OrderDTO;
import com.order.entities.Order;
import com.order.repositories.OrderRepository;
import com.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {


    @Autowired
    OrderService service;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping(value = "cascaded-list" )
    public ResponseEntity<List<OrderDTO>> findAllIrregularCascadedList(){
        List<OrderDTO> list = service.findAllIrregularCascadedList();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "list" )
    public ResponseEntity<List<OrderDTO>> findAll(){
        List<OrderDTO> list = service.findAllList();
        return ResponseEntity.ok().body(list);
    }


    @PostMapping(value = "simple")
    public Order simpleInsert(@RequestBody Order order){ // Case exist an error in Validate, it is blocked here
        return orderRepository.save(order);
    }



    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto){ // Case exist an error in Validate, it is blocked here
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
