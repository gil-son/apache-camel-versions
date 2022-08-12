package com.order.services;

import com.order.dto.OrderDTO;
import com.order.dto.ItemDTO;
import com.order.entities.Item;
import com.order.entities.Order;
import com.order.repositories.ItemRepository;
import com.order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Transactional(readOnly = true)


    public List<OrderDTO> findAllIrregularCascadedList() {
        List<Order> list = orderRepository.findAll();
        // Lambda
        //List<OrderDTO> listDTO = list.stream().map( x -> new OrderDTO(x)).collect(Collectors.toList());

        List<OrderDTO> listDTO = new ArrayList<>();
        List<ItemDTO> listItemDTO = new ArrayList<>();


        for( Order order : list ) {

            Item item = new Item();
            item.setId(2L);
            item.setName("aaa");
            item.setPrice(100.0);
            item.setQuantity(1);
            item.setDate(Instant.now());

            List<Item> itemList = new ArrayList<>();
            itemList.add(item);

            // get oder id

            // loop to find list item

            // for to add
            for(Item ite : itemList){
                ItemDTO dto = new ItemDTO(ite);
                listItemDTO.add(dto);
            }


            order.setPayment("edited");

            OrderDTO dto = new OrderDTO(listItemDTO, order);
             listDTO.add(dto);
        }

        System.out.println("listDTO:"+ listDTO);

        return listDTO;
    }


    public List<OrderDTO> findAllList() {
        List<Order> list = orderRepository.findAll();
        // Lambda
        List<OrderDTO> listDTO = list.stream().map( x -> new OrderDTO(x)).collect(Collectors.toList());
        return listDTO;
    }



    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order entity = new Order();

        entity.setPayment(dto.getPayment());
        entity.setStartMoment(dto.getStartMoment());
        entity.setEndMoment(dto.getEndMoment());


        entity.getItems().clear();

        for(ItemDTO itemDTO : dto.getItems()) {
            Item item = itemRepository.getOne(itemDTO.getId());
            entity.getItems().add(item);
        }

        entity = orderRepository.save(entity);
        // OrderDTO objDTO = new OrderDTO(entity);
        return new OrderDTO(entity);
    }
}
