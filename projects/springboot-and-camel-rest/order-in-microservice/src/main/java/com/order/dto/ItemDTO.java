package com.order.dto;

import com.order.entities.Item;
import com.order.entities.Order;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class ItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private Instant date;
    private Order order;

    public ItemDTO() {

    }


    public ItemDTO(Long id, String name,  Double price, Integer quantity,  Order order, Instant date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.date = date;

    }

    public ItemDTO( Item entity ) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.quantity = entity.getQuantity();
        this.date = entity.getDate();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return Objects.equals(id, itemDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
