package com.order.dto;

import com.order.entities.Item;
import com.order.entities.Order;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String payment;
    private Instant startMoment;
    private Instant endMoment;
    private List<ItemDTO> items = new ArrayList<>();


    @PrePersist
    public void prePersist() {
        startMoment = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        endMoment = Instant.now();
    }

    public OrderDTO() {

    }


    public OrderDTO(Long id, String payment, Instant startMoment, Instant endMoment) {
        super();
        this.id = id;
        this.payment = payment;
        this.startMoment = startMoment;
        this.endMoment = endMoment;
    }


    public OrderDTO(Order entity) {
        this.id = entity.getId();
        this.payment = entity.getPayment();
        this.startMoment = entity.getStartMoment();
        this.endMoment = entity.getEndMoment();
    }


    // TO GET OTHER TABLE
    public OrderDTO(Order entity, List<Item> items) {
        this(entity);
        //items.forEach(i -> this.items.add(new ItemDTO(i)));

        for(int i=0; i < this.items.size(); i++) {
            Item item = new Item();
            this.items.add(new ItemDTO(item));
        }
    }

    // CREATED MODE
    public OrderDTO(List<ItemDTO> dto, Order entity) {
        this.id = entity.getId();
        this.payment = entity.getPayment();
        this.startMoment = entity.getStartMoment();
        this.endMoment = entity.getEndMoment();
        this.items = dto;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Instant getEndMoment() {
        return endMoment;
    }


    public void setEndMoment(Instant endMoment) {
        this.endMoment = endMoment;
    }


    public List<ItemDTO> getItems() {
        return items;
    }


    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    public String getPayment() {
        return payment;
    }


    public Instant getStartMoment() {
        return startMoment;
    }

    public void setStartMoment(Instant startMoment) {
        this.startMoment = startMoment;
    }
}
