package com.exercise.onlinestore.main;


import com.exercise.onlinestore.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private final List<Product> products = new ArrayList<>();
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
    private Image image;
    private MyListener myListener;
    private Stage stage;
    private Scene scene;
    private Parent root;

    //------------------------------------------------------------------
    //Koden nedan används för att kunna byta scen.
    //Den byter ut rooten mot den root man namnger.
    //Stagen sätts till befintlig stag genom att typecasta befintlig källa scen och window till först en node som sen typecastas till en stage.
    //Nästa kodrad byter din Scen till den nya scenen i Parant root. Raden efter det sätter upp Scenen på din Stage och sen visas allt.
    public void switchToWindow4(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Window4.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //------------------------------------------------------------------

    private List<Product> getData() {
        List<Product> products = new ArrayList<>();
        Product product;

        product = new Product();
        product.setName("Bowtruckle");
        product.setPrice(20000);
        product.setImgSrc("/img/Bowtruckle.png");
        //product.setImgSrc("/main/resources/img/Bowtruckle.png");
        product.setColor("6A7324");
        products.add(product);

        product = new Product();
        product.setName("Demiguise");
        product.setPrice(20000);
        product.setImgSrc("/img/Demiguise.png");
        product.setColor("A7745B");
        products.add(product);

        product = new Product();
        product.setName("Doxy");
        product.setPrice(20000);
        product.setImgSrc("/img/Doxy.png");
        product.setColor("E7C00F");
        products.add(product);

        product = new Product();
        product.setName("Fwooper");
        product.setPrice(20000);
        product.setImgSrc("/img/Fwooper.png");
        product.setColor("F16C31");
        products.add(product);

        product = new Product();
        product.setName("Grindylow");
        product.setPrice(20000);
        product.setImgSrc("/img/Grindylow.png");
        product.setColor("291D36");
        products.add(product);

        product = new Product();
        product.setName("Niffler");
        product.setPrice(20000);
        product.setImgSrc("/img/Niffler.png");
        product.setColor("22371D");
        products.add(product);

        product = new Product();
        product.setName("Occamy");
        product.setPrice(20000);
        product.setImgSrc("/img/Occamy.png");
        product.setColor("FB5D03");
        products.add(product);

        product = new Product();
        product.setName("SwoopingEvil");
        product.setPrice(20000);
        product.setImgSrc("/img/SwoopingEvil.png");
        product.setColor("80080C");
        products.add(product);

        product = new Product();
        product.setName("Thunderbird");
        product.setPrice(20000);
        product.setImgSrc("/img/Thunderbird.png");
        product.setColor("FFB605");
        products.add(product);

        product = new Product();
        product.setName("Zouwu");
        product.setPrice(20000);
        product.setImgSrc("/img/Zouwu.png");
        product.setColor("5F060E");
        products.add(product);

        return products;
    }

    private void setChosenProduct(Product product) {
        productNameLabel.setText(product.getName());
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
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < products.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(products.get(i), myListener);

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

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}