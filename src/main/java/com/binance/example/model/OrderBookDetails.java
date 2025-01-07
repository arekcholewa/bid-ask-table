package com.binance.example.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = OrderBookDetailsDeserializer.class)
public class OrderBookDetails {

    private String price;
    private String amount;

    public OrderBookDetails() {
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
