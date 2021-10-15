package com.basic01.entities;

import java.util.ArrayList;
import java.util.List;

public class Address {

	private String status;
	private Integer code;
	private Integer total;
	private List<AddressComplement> listAddresses = new ArrayList<>();
	
	public Address(){}

	public Address(String status, Integer code, Integer total, List<AddressComplement> listAddresses) {
		this.status = status;
		this.code = code;
		this.total = total;
		this.listAddresses = listAddresses;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<AddressComplement> getDatas() {
		return listAddresses;
	}
	
}
