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
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.ResourceBundle;

public class CartController implements Initializable {
    ArrayList<Product> products;
    String name;
    double totalPrice;
    @FXML
    public Label totalAmountHeader;
    @FXML
    public Label labelHeader;
    @FXML
    public ImageView navCart;
    @FXML
    public Label totalItemsInCart;
    @FXML
    public Button addToCart;
    @FXML
    public Button removeFromCart;
    @FXML
    public Image image;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    ListView<Product> itemsInCart;
    CartController() {
        this.products = new ArrayList<>();
        this.name = " ";
        this.totalPrice = 0;
    }
    public void addToCart(Product product) {
        this.products.add(product);
    }
    public void showCart() {
        ListIterator<Product> iterator = products.listIterator();
        while(iterator.hasNext()) {
            Product product1 = iterator.next();
            System.out.println(product1);
        }
    }
    public void removeFromCart(Product i) {
        ListIterator<Product> iterator1 = products.listIterator();
        while(iterator1.hasNext()) {
            Product item2 = iterator1.next();
            if (item2.getName().equals(i.getName())) {
                this.products.remove(i);
                break;
            }
        }
    }
    public double getTotalPrice() {
        ListIterator<Product> iterator2 = products.listIterator();
        this.totalPrice = 0;
        while(iterator2.hasNext()) {
            Product product3 = iterator2.next();
            this.totalPrice = this.totalPrice + (product3.getPrice() + product3.getPrice());
        }
        return this.totalPrice;
    }



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        itemsInCart.getItems().addAll(products);
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