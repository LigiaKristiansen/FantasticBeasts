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
    private Stage window;

    public static final String CURRENCY = " ʛ";
    @Override
    public void start(Stage stage) throws IOException{

        URL fxmlResource = getClass().getResource("/fxml/store-ui.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlResource);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles/style.css")).toExternalForm());
        stage.setTitle("Fantastic Beasts");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args); //Added Application here. Don't know if it's needed.
    }
}