package com.exercise.onlinestore.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {

    @FXML
    BorderPane contentPane;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void showHomeView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/store-ui.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showShopView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/shop.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*public void showShopView() throws IOException {
        contentPane.setCenter(new ShopView().getView());
    }*/

    public void showEmployeeView() {
        contentPane.setCenter(new Label("Employee View"));
    }


    public void showCartView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/cart.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}




