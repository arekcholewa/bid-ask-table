package com.binance.example.model;

import java.util.List;

public class OrderBookDTO {

    private String lastUpdateId;
    private List<OrderBookDetails> bids;
    private List<OrderBookDetails> asks;

    public OrderBookDTO() {
    }

    public String getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(String lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public List<OrderBookDetails> getBids() {
        return bids;
    }

    public void setBids(List<OrderBookDetails> bids) {
        this.bids = bids;
    }

    public List<OrderBookDetails> getAsks() {
        return asks;
    }

    public void setAsks(List<OrderBookDetails> asks) {
        this.asks = asks;
    }
}
