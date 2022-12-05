package com.exercise.onlinestore.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Billing {
    @javafx.fxml.FXML
    private ImageView numer1;
    @javafx.fxml.FXML
    private ImageView number;
    @javafx.fxml.FXML
    private ImageView img_1;
    @javafx.fxml.FXML
    private ImageView img_2;
    @javafx.fxml.FXML
    private ImageView numer3;
    @javafx.fxml.FXML
    private ImageView img1;
    @javafx.fxml.FXML
    private ImageView img2;
    @javafx.fxml.FXML
    private ImageView img3;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void next1(ActionEvent event) {
        try {

            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/Billing_2.fxml"));

            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

//	    		                app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();

        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void next2(ActionEvent event) {
        try {

            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/Billing_3.fxml"));

            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

//	    		                app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();

        } catch (Exception e) {
        }
    }

    public void next3(ActionEvent event) {
        try {

            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/Billing_3.fxml"));

            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

//	    		                app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();

        } catch (Exception e) {
        }
    }

    public void nextVisitor(ActionEvent event) {
        try {
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/Billing_1.fxml"));

            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

//	    		                app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();

        } catch (Exception e) {
        }
    }
}