package com.exercise.onlinestore.main;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;


public class OrderTable {

    public void InitializeOrderTable(TableColumn<Order, String> customerName, TableColumn<Order, String> itemOrdered, TableColumn<Order, Integer> orderNr, TableColumn<Order, Integer> quantity) {
        //Här initieras de olika cellerna så de kan ta emot data.
        customerName.setCellValueFactory(new PropertyValueFactory<>("custName"));
        itemOrdered.setCellValueFactory(new PropertyValueFactory<>("itemOrdered"));
        orderNr.setCellValueFactory(new PropertyValueFactory<>("orderNr"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //För att kunna editera värdena så initieras en text klass som gör att man kan skriva in text i cellen. Man måste göra tabellen redigeringsbar i fxml.
        customerName.setCellFactory(TextFieldTableCell.forTableColumn());
        itemOrdered.setCellFactory(TextFieldTableCell.forTableColumn());
        //Konverterar text till tal fångar ett felmeddelande om man skriver in tal men funktionen är ändå korrekt då text inte kan sparas.
        orderNr.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        quantity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        //---För att kunna redigera informationen i cellerna.
        customerName.setOnEditCommit(orderStringCellEditEvent -> {
            Order order = orderStringCellEditEvent.getRowValue();
            order.setCustName(orderStringCellEditEvent.getNewValue());
        });
        //Kod ovan kan skrivas som LAMBDA
        itemOrdered.setOnEditCommit(orderStringCellEditEvent -> {
            Order order = orderStringCellEditEvent.getRowValue();
            order.setItemOrdered(orderStringCellEditEvent.getNewValue());
        });
        orderNr.setOnEditCommit(orderStringCellEditEvent -> {
            Order order = orderStringCellEditEvent.getRowValue();
            order.setOrderNr(orderStringCellEditEvent.getNewValue());
        });
        quantity.setOnEditCommit(orderStringCellEditEvent -> {
            Order order = orderStringCellEditEvent.getRowValue();
            order.setQuantity(orderStringCellEditEvent.getNewValue());
        });
        //---
    }
}
