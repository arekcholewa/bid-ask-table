package com.binance.example.mapper;

import com.binance.example.model.OrderBookDTO;
import com.binance.example.model.OrderBookDetails;
import com.binance.example.model.TableOrderBookModel;

import java.util.LinkedList;
import java.util.List;

public class TableDataModelMapper {

    public static List<TableOrderBookModel> mapFromApiResponse(OrderBookDTO orderBookDTO) {
        List<OrderBookDetails> asks = orderBookDTO.getAsks();
        List<OrderBookDetails> bids = orderBookDTO.getBids();

        List<TableOrderBookModel> tableOrderBooks = new LinkedList<>();
        for (int i = 0; i < asks.size() && i < bids.size(); i++) {
            tableOrderBooks.add(new TableOrderBookModel( i + 1,
                    bids.get(i).getPrice(),
                    bids.get(i).getAmount(),
                    asks.get(i).getPrice(),
                    asks.get(i).getAmount()));
        }
        return tableOrderBooks;
    }
}
