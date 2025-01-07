package com.binance.example.client;

import com.binance.example.exception.BinanceApiException;
import com.binance.example.model.OrderBookDTO;
import com.binance.example.service.DataController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class BinanceWebSocketListener extends WebSocketListener {

    private static final ObjectMapper mapper = new ObjectMapper();

    private ObjectReader reader;

    private DataController controller;

    public BinanceWebSocketListener(DataController controller) {
        this.controller = controller;
        reader = mapper.readerFor(OrderBookDTO.class);
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        try {
            OrderBookDTO value = reader.readValue(text);
            controller.handleMessage(value);
        } catch (JsonProcessingException e) {
            throw new BinanceApiException("Error getting data from the websocket " + e.getMessage());
        }
        super.onMessage(webSocket, text);
    }
}
