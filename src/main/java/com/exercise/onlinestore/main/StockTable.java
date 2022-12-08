package com.exercise.onlinestore.main;

import com.exercise.onlinestore.model.Product;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class StockTable {

    public void InitializeStockTable(TableColumn<Product, String> name,TableColumn<Product, Double> price,TableColumn<Product, String> description, TableColumn<Product, Integer> inStock) {
        //Här initieras de olika cellerna så de kan ta emot data.
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        inStock.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        //För att kunna editera värdena så initieras en text klass som gör att man kan skriva in text i cellen. Man måste göra tabellen redigeringsbar i fxml.
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        description.setCellFactory(TextFieldTableCell.forTableColumn());
        //Konverterar text till tal fångar ett felmeddelande om man skriver in tal men funktionen är ändå korrekt då text inte kan sparas.
        price.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        inStock.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        //---För att kunna redigera informationen i cellerna.
        name.setOnEditCommit(stringCellEditEvent -> {
            Product product = stringCellEditEvent.getRowValue();
            product.setName(stringCellEditEvent.getNewValue());
        });
        price.setOnEditCommit(doubleCellEditEvent -> {
            Product product = doubleCellEditEvent.getRowValue();
            product.setPrice(doubleCellEditEvent.getNewValue());
        });
        description.setOnEditCommit(stringCellEditEvent -> {
            Product product = stringCellEditEvent.getRowValue();
            product.setDescription(stringCellEditEvent.getNewValue());
        });
        inStock.setOnEditCommit(integerCellEditEvent -> {
            Product product = integerCellEditEvent.getRowValue();
            product.setInStock(integerCellEditEvent.getNewValue());
        });
        //---
    }
}
