package com.exercise.onlinestore.main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Window4Controller implements Initializable {

    @FXML
    TableColumn<Order, String> customerName;

    @FXML
    TableColumn<Stock, Integer> inStock;

    @FXML
    TableColumn<Stock, String> item;

    @FXML
    TableColumn<Order, String> itemOrdered;

    @FXML
    MenuItem loadStockCsv;

    @FXML
    TableColumn<Order, Integer> orderNr;

    @FXML
    TableColumn<Order, Integer> quantity;

    @FXML
    MenuItem saveStockCsv;

    @FXML
    TableView<Order> tableViewOrder;

    @FXML
    TableView<Stock> tableViewStock;


    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

    //Koden nedan används för att kunna byta scen.
    //Den byter ut rooten mot den root man namnger.
    //Stagen sätts till befintlig stag genom att typecasta befintlig källa scen och window till först en node som sen typecastas till en stage.
    //Nästa kodrad byter din Scen till den nya scenen i Parant root. Raden efter det sätter upp Scenen på din Stage och sen visas allt.
    public void switchToWindowShop(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/shop.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}