package com.exercise.onlinestore.main;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class StockTable {

    public void InitializeStockTable(TableColumn<Stock, String> item, TableColumn<Stock, Integer> inStock) {
        //Här initieras de olika cellerna så de kan ta emot data.
        item.setCellValueFactory(new PropertyValueFactory<>("item"));
        inStock.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        //För att kunna editera värdena så initieras en text klass som gör att man kan skriva in text i cellen. Man måste göra tabellen redigeringsbar i fxml.
        item.setCellFactory(TextFieldTableCell.forTableColumn());
        //Konverterar text till tal fångar ett felmeddelande om man skriver in tal men funktionen är ändå korrekt då text inte kan sparas.
        inStock.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        //---För att kunna redigera informationen i cellerna.
        item.setOnEditCommit(orderStringCellEditEvent -> {
            Stock order = orderStringCellEditEvent.getRowValue();
            order.setItem(orderStringCellEditEvent.getNewValue());
        });
        //Kod ovan kan skrivas som LAMBDA
        inStock.setOnEditCommit(orderStringCellEditEvent -> {
            Stock order = orderStringCellEditEvent.getRowValue();
            order.setInStock(orderStringCellEditEvent.getNewValue());
        });
        //---
    }
}
