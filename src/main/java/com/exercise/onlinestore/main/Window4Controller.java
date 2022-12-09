package com.exercise.onlinestore.main;

import com.exercise.onlinestore.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    public Tab stockTab;
    public Tab orderTab;
    @FXML
    TableColumn<Order, String> customerName;

    @FXML
    TableColumn<Product, Integer> inStock;
    @FXML
    TableColumn<Product, String> name;
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
    TableView<Product> tableViewStock;
    OrderTable orderTable = new OrderTable();
    StockTable stockTable = new StockTable();
    ShopController shopController = new ShopController();
    @FXML
    private TableColumn<Product, String> description;
    @FXML
    private TableColumn<Product, Double> price;

    private void StockAddDelete() {
        addRow.setOnAction(event -> tableViewStock.getItems().add(new Product("", 0, "", 0)));
        deleteRow.setOnAction(event -> tableViewStock.getItems().removeAll(tableViewStock.getSelectionModel().getSelectedItems()));
    }

    private void OrderAddDelete() {
        addRow.setOnAction(event -> tableViewOrder.getItems().add(new Order("", 0, "", 0)));
        deleteRow.setOnAction(event -> tableViewOrder.getItems().removeAll(tableViewOrder.getSelectionModel().getSelectedItems()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orderTable.InitializeOrderTable(customerName, itemOrdered, orderNr, quantity);
        stockTable.InitializeStockTable(name, price, description, inStock);

        //Bara random värden som läggs in i tabellen
        tableViewOrder.getItems().add(new Order("Axel Axelsson", 1, "Zouwu", 1));
        tableViewOrder.getItems().add(new Order("Björn Börjesson", 2, "Thunderbird", 1));
        tableViewOrder.getItems().add(new Order("Calle Capten", 3, "SwoopingEvil", 1));
        tableViewOrder.getItems().add(new Order("Daniel Dinerso", 4, "Occamy", 1));

        tableViewStock.getItems().addAll(shopController.getData());
        StockAddDelete();
        stockTab.setOnSelectionChanged(event -> {
            if (stockTab.isSelected()) {
                StockAddDelete();
            }
        });
        orderTab.setOnSelectionChanged(eventTab -> {
            if (orderTab.isSelected()) {
                OrderAddDelete();
            }
        });
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

    public void CellOrderNrCommit(TableColumn.CellEditEvent<Order, Integer> orderIntegerCellEditEvent) {
        if (tableViewOrder.getItems().stream().equals(orderIntegerCellEditEvent.getNewValue() )) {
            return;
        } else {
            System.out.println("Value is not unique.");

        }

    }
}