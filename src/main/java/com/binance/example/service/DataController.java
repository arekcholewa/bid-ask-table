package com.binance.example.service;

import com.binance.example.model.OrderBookDTO;

public interface DataController {
    void handleMessage(OrderBookDTO dto);
}
