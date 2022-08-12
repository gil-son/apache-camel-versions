package com.order.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String payment;

    @Column( columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant startMoment;

    @Column( columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant endMoment;

    @OneToMany(mappedBy = "order") // 'order' is the oposito of the 'item'
    private List<Item> items = new ArrayList<>();

   
    @PrePersist
	public void prePersist() {
    	startMoment = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		endMoment = Instant.now();
	}
	
    public Order() {
    	
    }


	public Order(Long id, String payment, Instant startMoment, Instant endMoment, List<Item> items) {
		super();
		this.id = id;
		this.payment = payment;
		this.startMoment = startMoment;
		this.endMoment = endMoment;
		this.items = items;
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


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Instant getStartMoment() {
		return startMoment;
	}

	public void setStartMoment(Instant startMoment) {
		this.startMoment = startMoment;
	}
}
