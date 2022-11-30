package com.exercise.onlinestore.main;


import com.exercise.onlinestore.model.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ShopController implements Initializable {
    public Label productDescriptionLabel;
    @FXML
    private VBox chosenProductCard;
    @FXML
    private Label productNameLabel;
    @FXML
    private Label productPriceLabel;

    @FXML
    private ImageView productImg;

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    private List<Product> products = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    private List<Product> getData() {
        List<Product> products = new ArrayList<>();
        Product product;

        product = new Product();
        product.setName("Bowtruckle");
        product.setDescription("The tiny, hand-sized Bowtruckles dwell within trees and, due to to their stick-like appearance," +
                " can camouflage into their environment. These creatures are also expert lock-pickers, which makes them useful pets to have.");
        product.setPrice(50000);
        product.setImgSrc("/img/Bowtruckle.png");
        //product.setImgSrc("/main/resources/img/Bowtruckle.png");
        product.setColor("6A7324");
        products.add(product);

        product = new Product();
        product.setName("Demiguise");
        product.setDescription("Demiguise resemble a cross between a sloth and a monkey and have long silver hair." +
                "Demiguise fur can be used to weave invisibility cloaks because these creature possess the ability to turn invisible. " +
                "They also have the ability to see the future. Both abilities make them difficult to catch.");
        product.setPrice(300000);
        product.setImgSrc("/img/Demiguise.png");
        product.setColor("A7745B");
        products.add(product);

        product = new Product();
        product.setName("Doxy");
        product.setDescription("Doxies are often referred to as \"biting fairies\" but are actually a different species." +
                " Like fairies, Doxies are small and have wings, but they also have sharp teeth, extra arms and legs, and large ears.");
        product.setPrice(20000);
        product.setImgSrc("/img/Doxy.png");
        product.setColor("E7C00F");
        products.add(product);

        product = new Product();
        product.setName("Fwooper");
        product.setDescription("Fwoopers are brightly colored birds, and while they look like fairly innocent creatures," +
                " they can be deadly. The birds' feathers are said to be brightly colored because they originated from Africa." +
                " The song of a Fwooper is enough to drive a person mad, so only one should be owned at any given time." +
                " Wizards who keep one of these birds are advised to put a silencing spell on the Fwooper to ensure the wizard retains their sanity.");
        product.setPrice(20000);
        product.setImgSrc("/img/Fwooper.png");
        product.setColor("F16C31");
        products.add(product);

        product = new Product();
        product.setName("Grindylow");
        product.setDescription("Grindylow are small water-demons and use their tentacles to navigate through their underwater habitat and are known to be aggressive in nature.");
        product.setPrice(20000);
        product.setImgSrc("/img/Grindylow.png");
        product.setColor("291D36");
        products.add(product);

        product = new Product();
        product.setName("Niffler");
        product.setDescription("Nifflers are small and adorable platypus-like creatures. They're often escaping and causing trouble. " +
                "These creatures have an attraction to anything shiny, which means they can be quite a menace.");
        product.setPrice(20000);
        product.setImgSrc("/img/Niffler.png");
        product.setColor("22371D");
        products.add(product);

        product = new Product();
        product.setName("Occamy");
        product.setDescription("Occamies are winged, serpentine creatures that hatch from eggs of pure silver." +
                " These fantastic animals can grow and shrink in size in order to fill available spaces.");
        product.setPrice(20000);
        product.setImgSrc("/img/Occamy.png");
        product.setColor("FB5D03");
        products.add(product);

        product = new Product();
        product.setName("SwoopingEvil");
        product.setDescription("The Swooping Evil hides itself in a small cocoon, but when it reveals itself," +
                " its quite intimidating to behold. The creature has bright blue wings like a butterfly but has a wolf-likeskull in place of a head." +
                " This creature is particularly dangerous because it eats human brains");
        product.setPrice(20000);
        product.setImgSrc("/img/SwoopingEvil.png");
        product.setColor("80080C");
        products.add(product);

        product = new Product();
        product.setName("Thunderbird");
        product.setDescription("The aptly named Thunderbird is a huge avian creature that can summon storms." +
                " From Arizona, The Thunderbird is a regal creature that is highly sensitive to danger.");
        product.setPrice(20000);
        product.setImgSrc("/img/Thunderbird.png");
        product.setColor("FFB605");
        products.add(product);

        product = new Product();
        product.setName("Zouwu");
        product.setDescription("The Zouwu is a gigantic feline creature, and, despite its intimidating size, it can be easily tamed." +
                " Zouwu has an apparent ability to apparate.");
        product.setPrice(20000);
        product.setImgSrc("/img/Zouwu.png");
        product.setColor("5F060E");
        products.add(product);

        return products;
    }


    private void setChosenProduct(Product product) {
        productNameLabel.setText(product.getName());
        productDescriptionLabel.setText(product.getDescription());
        productPriceLabel.setText(product.getPrice() + " " + Main.CURRENCY);
        image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(product.getImgSrc())));
        productImg.setImage(image);
        chosenProductCard.setStyle("-fx-background-color: #" + product.getColor() + ";\n" + "    -fx-background-radius: 30;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        products.addAll(getData());
        if (products.size() > 0) {
            setChosenProduct(products.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Product product) {
                    setChosenProduct(product);

                }

            };
        }
        Button addButton = new Button("ADD TO SUITCASE");
        addButton.setUserData(productNameLabel);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Node sourceComponent = (Node)actionEvent.getSource();
                String productName = (String)sourceComponent.getUserData();
                ShoppingCart shoppingCart = ShoppingCart.getINSTANCE();
                shoppingCart.addProducts(productName);
            }
        });

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < products.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(products.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(30));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showCartView(MouseEvent mouseEvent) {
    }
}