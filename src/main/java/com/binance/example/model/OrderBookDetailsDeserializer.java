package com.binance.example.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class OrderBookDetailsDeserializer extends JsonDeserializer<OrderBookDetails> {

    @Override
    public OrderBookDetails deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        final String price = node.get(0).asText();
        final String amount = node.get(1).asText();

        OrderBookDetails orderDetails = new OrderBookDetails();
        orderDetails.setPrice(price);
        orderDetails.setAmount(amount);
        return orderDetails;
    }
}
