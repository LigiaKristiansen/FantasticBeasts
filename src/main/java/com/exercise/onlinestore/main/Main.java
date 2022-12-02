package com.exercise.onlinestore.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;


public class Main extends Application {
    public static final String CURRENCY = " ʛ";
    private Stage window;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        //Här kopplas scenen till fxml filen. Programmet för att kunna köra fxml läggs även till.
        //Tidigare: URL fxmlResource = getClass().getResource("/fxml/shop.fxml");
        URL fxmlResource = getClass().getResource("/fxml/store-ui.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlResource);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        //Viriabel för länken till vår css för att lättare kunna använda den på flera scener.
        String css = Objects.requireNonNull(this.getClass().getResource("/styles/style.css")).toExternalForm();
        //Här läggs css filen med variabl(css) till.
        scene.getStylesheets().add(css);
        //Här skapas första scenen
        primaryStage.setTitle("Fantastic Beasts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}