package com.binance.example.client;

import com.binance.example.service.DataController;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

import java.io.Closeable;

public class BinanceApiWebSocketClient {

    private static final String BASE_URL = "wss://stream.binance.com:9443/ws/";
    private static final String DEPTH = "@depth";

    private static final int NORMAL_CLOSE_CODE = 1000;

    private OkHttpClient httpClient;

    public BinanceApiWebSocketClient() {
        this.httpClient = new OkHttpClient();
    }

    public Closeable getPartialBookData(String symbol, int depthValue, DataController controller) {
        Request request = new Request.Builder()
                .url(BASE_URL + symbol + DEPTH + depthValue)
                .build();

        BinanceWebSocketListener listener = new BinanceWebSocketListener(controller);
        WebSocket webSocket = httpClient.newWebSocket(request, listener);
        return () -> {
            listener.onClosing(webSocket, NORMAL_CLOSE_CODE, null);
            webSocket.close(NORMAL_CLOSE_CODE, null);
            listener.onClosed(webSocket, NORMAL_CLOSE_CODE, null);
        };
    }
}
