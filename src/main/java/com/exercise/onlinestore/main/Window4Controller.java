package com.exercise.onlinestore.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Window4Controller {

    @FXML
    private TableColumn<?, ?> costomerName;

    @FXML
    private TableColumn<?, ?> inStock;

    @FXML
    private TableColumn<?, ?> item;

    @FXML
    private TableColumn<?, ?> item2;

    @FXML
    private MenuItem loadStockCsv;

    @FXML
    private TableColumn<?, ?> orderNr;

    @FXML
    private TableColumn<?, ?> quantity;

    @FXML
    private MenuItem saveStockCsv;


    private Stage stage;
    private Scene scene;
    private Parent root;

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
