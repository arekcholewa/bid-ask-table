package com.binance.example;

import javafx.event.Event;
import javafx.event.EventHandler;

import java.io.IOException;

public class OnCloseEventHandler implements EventHandler {

    @Override
    public void handle(Event event) {
        CloseableActionsHolder.getInstance().getCloseableSet().forEach(closeable -> {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
