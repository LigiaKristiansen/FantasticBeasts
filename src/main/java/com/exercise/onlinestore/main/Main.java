package com.exercise.onlinestore.main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;


public class Main extends Application {

    public static final String CURRENCY = " kr";

    public static void main(String[] args) {
        Application.launch(args); //Added Application here. Don't know if it's needed.
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        URL fxmlResource = getClass().getResource("/fxml/shop.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlResource);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles/style.css")).toExternalForm());
        primaryStage.setTitle("Fantastic Beasts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}