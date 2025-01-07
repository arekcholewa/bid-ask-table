package com.binance.example.service.impl;

import com.binance.example.model.OrderBookDTO;
import com.binance.example.service.DataController;
import com.binance.example.mapper.TableDataModelMapper;
import com.binance.example.model.TableOrderBookModel;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javafx.application.Platform;
import javafx.collections.ObservableList;

import java.util.List;

public class DataControllerImpl implements DataController {

    private final ObservableList<TableOrderBookModel> list;

    public DataControllerImpl(ObservableList list) {
        this.list = list;
    }

    public void handleMessage(OrderBookDTO dto) {
        List<TableOrderBookModel> tableOrderBookModels = TableDataModelMapper.mapFromApiResponse(dto);

        Observable.fromArray(tableOrderBookModels)
                .observeOn(Schedulers.io())
                .subscribe(data -> Platform.runLater(() -> list.setAll(data)));
    }
}
