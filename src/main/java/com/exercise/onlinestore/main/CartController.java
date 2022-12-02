package com.exercise.onlinestore.main;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class CartController {
    @FXML
    private VBox cartPane;

/*    @FXML
    public void initialize(){
        List<CartEntry> entries = ShoppingCart.getINSTANCE().getEntries();
        cartPane.getChildren().clear();

        if(entries.isEmpty()){
            Label emptyLabel = new Label("Empty Cart");
            cartPane.getChildren().add(emptyLabel);
        }
        else{
            Label shoppingCartTitle = new Label("Shopping Cart");
            cartPane.getChildren().add(shoppingCartTitle);*/

/* TODO skall koden vara kvar?
                for(CartEntry cartEntry:entries){
                HBox hBox = new HBox();
                Label productName = new Label(cartEntry.getProduct().getName());
                hBox.getChildren().add(productName);
                cartPane.getChildren().add(hBox);
            }
        }
    }

/* TODO skall koden vara kvar?
        private HBox cartEntryView(CartEntry cartEntry) throws FileNotFoundException{
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER_LEFT);

        FileInputStream input = new FileInputStream("src/main/resources/img" + cartEntry.getProduct().getImgSrc());
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        Label productName = new Label(cartEntry.getProduct().getName());

        Label quantity = new Label(String.valueOf(cartEntry.getQuantity()));

        Button plusButton = new Button("+");
        Button minusButton = new Button("-");

        Label price = new Label(cartEntry.getProduct().getPrice() + Main.CURRENCY);

        layout.getChildren().addAll(imageView,productName, plusButton, quantity, minusButton, price);


        return layout;
    }*/
}
