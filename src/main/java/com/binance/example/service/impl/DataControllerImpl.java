package com.binance.example.service.impl;

import com.binance.example.mapper.TableDataModelMapper;
import com.binance.example.model.OrderBookDTO;
import com.binance.example.model.TableOrderBookModel;
import com.binance.example.service.DataController;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javafx.application.Platform;
import javafx.collections.ObservableList;

public class DataControllerImpl implements DataController {

    private final ObservableList<TableOrderBookModel> list;

    public DataControllerImpl(ObservableList list) {
        this.list = list;
    }

    public void handleMessage(OrderBookDTO dto) {
        Observable.fromArray(dto)
                .subscribeOn(Schedulers.io())
                .map(TableDataModelMapper::mapFromApiResponse)
                .observeOn(Schedulers.from(Platform::runLater))
                .subscribe(list::setAll);
    }
}
