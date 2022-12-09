package com.exercise.onlinestore.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class CartController {
    @FXML
    private VBox cartPane;

    private Label totalPriceLabel;
    private Stage stage;
    private Scene scene;
    private Parent root;

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
    public void showEmployeeView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/Window4.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showBillingView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/Billing_1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void initialize() throws FileNotFoundException {
        List<CartEntry> entries = ShoppingCart.getINSTANCE().getEntries();
        cartPane.getChildren().clear();

        if (entries.isEmpty()) {
            Label emptyLabel = new Label("Empty Suitcase");
            cartPane.getChildren().add(emptyLabel);
        } else {
            Label shoppingCartTitle = new Label("Shopping Cart");
            cartPane.getChildren().add(shoppingCartTitle);

            for (CartEntry cartEntry : entries) {
                HBox productView = cartEntryView(cartEntry);
                cartPane.getChildren().add(productView);
            }
            Separator separator = new Separator();
            separator.setOrientation(Orientation.HORIZONTAL);
            cartPane.getChildren().add(separator);

            HBox totalView = totalView(ShoppingCart.getINSTANCE().calculateTotal());
            cartPane.getChildren().add(totalView);
        }
    }

    private HBox totalView(double totalPrice){
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER);

        Label totalLabel = new Label("Total:");
        totalLabel.setStyle("-fx-font-size:15pt");

        this.totalPriceLabel = new Label(String.valueOf(totalPrice));

        layout.getChildren().addAll(totalLabel, this.totalPriceLabel);
        return layout;
    }
    private HBox cartEntryView(CartEntry cartEntry) throws FileNotFoundException {
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER_LEFT);

        FileInputStream input = new FileInputStream("/src/main/resources/img/" + cartEntry.getProduct().getImgSrc());
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);

        Label productName = new Label(cartEntry.getProduct().getName());
        productName.setPrefWidth(100);
        productName.setStyle("-fx-font-size:15pt; -fx-padding:5px");

        Label quantity = new Label(String.valueOf(cartEntry.getQuantity()));
        quantity.setStyle("-fx-padding:5px");

        Button plusButton = new Button("+");
        plusButton.setStyle("-fx-padding:5px");
        plusButton.setUserData(cartEntry.getProduct().getName());
        plusButton.setOnAction( e -> {
            String name = (String) ((Node) e.getSource()).getUserData();
            ShoppingCart.getINSTANCE().addProducts(name);
            quantity.setText(String.valueOf(ShoppingCart.getINSTANCE().getQuantity(name)));
            this.totalPriceLabel.setText(String.valueOf(ShoppingCart.getINSTANCE().calculateTotal()));
        });

        Button minusButton = new Button("-");
        minusButton.setStyle("-fx-padding:5px");
        minusButton.setUserData(cartEntry.getProduct().getName());
        minusButton.setOnAction( e -> {
            String name = (String) ((Node) e.getSource()).getUserData();
            ShoppingCart.getINSTANCE().removeProduct(name);
            quantity.setText(String.valueOf(ShoppingCart.getINSTANCE().getQuantity(name)));
            this.totalPriceLabel.setText(String.valueOf(ShoppingCart.getINSTANCE().calculateTotal()));
        });

        Label price = new Label(String.valueOf("£ "+cartEntry.getProduct().getPrice()));
        price.setStyle("-fx-padding:5px");

        layout.getChildren().addAll(imageView,productName, plusButton, quantity, minusButton, price);

        return layout;
    }

}


/*public class CartController implements Initializable {

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


}*/
