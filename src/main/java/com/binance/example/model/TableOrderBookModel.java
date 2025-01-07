package com.binance.example.model;

public class TableOrderBookModel {

    private int number;
    private String buyPrice;
    private String buyAmount;
    private String sellPrice;
    private String sellAmount;

    public TableOrderBookModel() {
    }

    public TableOrderBookModel(int number, String buyPrice, String buyAmount, String sellPrice, String sellAmount) {
        this.number = number;
        this.buyPrice = buyPrice;
        this.buyAmount = buyAmount;
        this.sellPrice = sellPrice;
        this.sellAmount = sellAmount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(String buyAmount) {
        this.buyAmount = buyAmount;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(String sellAmount) {
        this.sellAmount = sellAmount;
    }
}
