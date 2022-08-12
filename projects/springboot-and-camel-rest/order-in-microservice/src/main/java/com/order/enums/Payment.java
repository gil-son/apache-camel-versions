package com.order.enums;

public enum Payment {
	
	APPROVED("approved"),
    WAITTING("waitting"),
    REPROVED("reproved");

    private String status;

    Payment(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
