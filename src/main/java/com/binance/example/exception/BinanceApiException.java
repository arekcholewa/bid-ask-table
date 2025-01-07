package com.binance.example.exception;

public class BinanceApiException extends RuntimeException {

    public BinanceApiException(String message) {
        super(message);
    }
}
