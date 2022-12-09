package com.exercise.onlinestore.main;

import com.exercise.onlinestore.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class CartController implements Initializable {

    ArrayList<Order> orders;
    Integer totalPrice;
    @FXML
    public Label totalAmountHeader;
    @FXML
    public Label labelHeader;
    @FXML
    public ImageView navCart;
    @FXML
    public Image image;
    @FXML
    public ListView<String> myCart;
    private Stage stage;
    private Scene scene;
    private Parent root;
    ShopController shopController;
    ArrayList<String> itemsInCart = new ArrayList<String>();


    public void GetCart(){
        shopController.productMap.keySet();
        Set<String> orderKeys = shopController.productMap.keySet();
        for (String orderList:orderKeys) {
            Order order = shopController.productMap.get(orderList);
            orders.add(order);
            itemsInCart.add(order.getItemOrdered());

        }

        //myCart.getItems();
    }

    public CartController() {
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        myCart.getItems().addAll(itemsInCart);

    }

    public void showCartView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/cart.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

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


}