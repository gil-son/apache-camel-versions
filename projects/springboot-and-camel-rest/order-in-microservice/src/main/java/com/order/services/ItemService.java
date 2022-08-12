package com.order.services;

import com.order.dto.ItemDTO;
import com.order.entities.Item;
import com.order.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    @Transactional(readOnly = true)
    public List<ItemDTO> findAll() {
        List<Item> list = repository.findAll();
        // Lambda
        List<ItemDTO> listDTO = list.stream().map( x -> new ItemDTO(x)).collect(Collectors.toList());
        return listDTO;
    }
}
