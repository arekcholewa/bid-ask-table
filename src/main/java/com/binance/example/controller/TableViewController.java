package com.binance.example.controller;

import com.binance.example.service.DataController;
import com.binance.example.CloseableActionsHolder;
import com.binance.example.client.BinanceApiWebSocketClient;
import com.binance.example.model.TableOrderBookModel;
import com.binance.example.service.impl.DataControllerImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.Closeable;
import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

    @FXML
    private TableView<TableOrderBookModel> tableView;
    @FXML
    private TableColumn<TableOrderBookModel, Integer> number;
    @FXML
    private TableColumn<TableOrderBookModel, String> buyPrice;
    @FXML()
    private TableColumn<TableOrderBookModel, String> buyAmount;
    @FXML
    private TableColumn<TableOrderBookModel, String> sellPrice;
    @FXML
    private TableColumn<TableOrderBookModel, String> sellAmount;

    public ObservableList<TableOrderBookModel> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        buyPrice.setCellValueFactory(new PropertyValueFactory<>("buyPrice"));
        buyAmount.setCellValueFactory(new PropertyValueFactory<>("buyAmount"));
        sellPrice.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        sellAmount.setCellValueFactory(new PropertyValueFactory<>("sellAmount"));

        tableView.setItems(list);
        runTableModelUpdate(list);
    }

    private void runTableModelUpdate(ObservableList<TableOrderBookModel> list) {
        DataController controller = new DataControllerImpl(list);
        BinanceApiWebSocketClient binanceApiWebSocketClient = new BinanceApiWebSocketClient();
        Closeable closeable = binanceApiWebSocketClient.getPartialBookData("btcusdt", 20, controller);

        CloseableActionsHolder.getInstance().addClosable(closeable);
    }
}
