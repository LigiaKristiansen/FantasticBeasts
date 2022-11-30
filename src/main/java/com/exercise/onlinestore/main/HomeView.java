package com.exercise.onlinestore.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

public class HomeView {

    private Parent view;

    public HomeView() throws IOException {
        URL fxmlResource = getClass().getResource("/fxml/store-ui.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlResource);
        Parent root = loader.load();

        this.view = root;
    }

    public Parent getView() {
        return this.view;
    }
}
