package com.exercise.onlinestore.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Window4Controller implements Initializable {
    @FXML
    public Button addRow;
    @FXML
    public Button deleteRow;
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
    OrderTable orderTable = new OrderTable();
    StockTable stockTable = new StockTable();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orderTable.InitializeOrderTable(customerName, itemOrdered, orderNr, quantity);
        stockTable.InitializeStockTable(item,inStock);

        //Bara random värden som läggs in i tabellen
        tableViewOrder.getItems().add(new Order("Axel Axelsson", 1, "Huffelpuff", 1));
        tableViewOrder.getItems().add(new Order("Björn Börjesson", 2, "Flopperflopp", 1));
        tableViewOrder.getItems().add(new Order("Calle Capten", 3, "Dobe", 1));
        tableViewOrder.getItems().add(new Order("Daniel Dinerso", 4, "WoopWoop", 1));

        addRow.setOnAction(event -> tableViewStock.getItems().add(new Stock("", 0)));
        deleteRow.setOnAction(event -> tableViewStock.getItems().removeAll(tableViewStock.getSelectionModel().getSelectedItems()));
    }

    //Koden nedan används för att kunna byta scen.
    //Den byter ut rooten mot den root man namnger.
    //Stagen sätts till befintlig stag genom att typecasta befintlig källa scen och window till först en node som sen typecastas till en stage.
    //Nästa kodrad byter din Scen till den nya scenen i Parant root. Raden efter det sätter upp Scenen på din Stage och sen visas allt.
    public void switchToWindowShop(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/shop.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}