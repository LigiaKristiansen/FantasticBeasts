package com.exercise.onlinestore.main;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class OrderTableView extends Window4Controller {
    public OrderTableView() {
        //Här initieras de olika cellerna så de kan ta emot data.
        customerName.setCellValueFactory(new PropertyValueFactory<Order, String>("custName"));
        itemOrdered.setCellValueFactory(new PropertyValueFactory<Order, String>("itemOrdered"));
        orderNr.setCellValueFactory(new PropertyValueFactory<Order, Integer>("orderNr"));
        quantity.setCellValueFactory(new PropertyValueFactory<Order, Integer>("quantity"));

        //För att kunna editera värdena så initieras en text klass som gör att man kan skriva in text i cellen. Man måste göra tabellen redigeringsbar i fxml.
        customerName.setCellFactory(TextFieldTableCell.forTableColumn());
        itemOrdered.setCellFactory(TextFieldTableCell.forTableColumn());
        //Konverterar text till tal TODO Fungerar inte riktigt som det skall, får fel.
        try {
            orderNr.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            quantity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        } catch (NumberFormatException E) {
            System.out.println("Skriv ett tal!");
        }

        customerName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Order, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Order, String> orderStringCellEditEvent) {
                Order order = orderStringCellEditEvent.getRowValue();
                order.setCustName(orderStringCellEditEvent.getNewValue());
            }
        });
        itemOrdered.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Order, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Order, String> orderStringCellEditEvent) {
                Order order = orderStringCellEditEvent.getRowValue();
                order.setItemOrdered(orderStringCellEditEvent.getNewValue());
            }
        });
        orderNr.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Order, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Order, Integer> orderStringCellEditEvent) {
                Order order = orderStringCellEditEvent.getRowValue();
                order.setOrderNr(orderStringCellEditEvent.getNewValue());
            }
        });
        quantity.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Order, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Order, Integer> orderStringCellEditEvent) {
                Order order = orderStringCellEditEvent.getRowValue();
                order.setQuantity(orderStringCellEditEvent.getNewValue());
            }
        });

        //Bara random värden som läggs in i tabellen
        tableViewOrder.getItems().add(new Order("Axel Axelsson", 1, "Huffelpuff", 1));
        tableViewOrder.getItems().add(new Order("Björn Börjesson", 2, "Flopperflopp", 1));
        tableViewOrder.getItems().add(new Order("Calle Capten", 3, "Dobe", 1));
        tableViewOrder.getItems().add(new Order("Daniel Dinerso", 4, "WoopWoop", 1));
    }
}
