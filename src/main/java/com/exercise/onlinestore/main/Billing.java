package com.exercise.onlinestore.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Billing {

    @javafx.fxml.FXML
    public ImageView numer1;
    @javafx.fxml.FXML
    public TextField email = new TextField();
    @javafx.fxml.FXML
    public TextField f_name;
    @javafx.fxml.FXML
    public TextField surname;
    @javafx.fxml.FXML
    public TextField address;
    @javafx.fxml.FXML
    public TextField post_add;
    @javafx.fxml.FXML
    public TextField zip;
    @javafx.fxml.FXML
    public ComboBox country;
    @javafx.fxml.FXML
    public TextField mobile;
    @javafx.fxml.FXML
    public TextField country_code;
    @javafx.fxml.FXML
    public RadioButton first = new RadioButton();
    @javafx.fxml.FXML
    public RadioButton second = new RadioButton();
    @javafx.fxml.FXML
    public RadioButton pay_directly = new RadioButton();
    @javafx.fxml.FXML
    public RadioButton pay_now = new RadioButton();
    @javafx.fxml.FXML
    public RadioButton buy_now = new RadioButton();
    public ImageView numer3;
    public ImageView img1;
    public ImageView img2;
    public ImageView img3;
    public ImageView number;
    public ImageView img_1;
    public ImageView img_2;

    @javafx.fxml.FXML
    public void initialize() {
        //  country.getSelectionModel().selectFirst();
        if (first.isSelected()) second.setSelected(false);
        else first.setSelected(false);

    }

    public String getpattern() {
        String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return pattern;
    }

    @Deprecated
    public void paydirectly(ActionEvent event) {
        pay_now.setSelected(false);
        buy_now.setSelected(false);
    }

    @Deprecated
    public void paynow(ActionEvent event) {
        pay_directly.setSelected(false);
        buy_now.setSelected(false);
    }

    @Deprecated
    public void buynow(ActionEvent event) {
        pay_now.setSelected(false);
        pay_directly.setSelected(false);
    }

    @Deprecated
    public void firstclick(ActionEvent event) {
        second.setSelected(false);
    }

    @Deprecated
    public void secondclick(ActionEvent event) {
        first.setSelected(false);
    }

    @Deprecated
    public void next1(ActionEvent event) {
        try {
            System.out.println(country.getValue());
            Data.email.add(email.getText());
            Data.fname.add(f_name.getText());
            Data.surname.add(surname.getText());
            Data.streetaddress.add(address.getText());
            Data.postaladdress.add(post_add.getText());
            Data.zipcode.add(zip.getText());
            Data.country.add("" + country.getValue());
            Data.countrcode.add(country_code.getText());
            Data.mobile.add(mobile.getText());
            System.out.println(Data.email);
            System.out.println(Data.fname);
            System.out.println(Data.surname);
            System.out.println(Data.streetaddress);
            System.out.println(Data.postaladdress);
            System.out.println(Data.zipcode);
            System.out.println(Data.country);
            System.out.println(Data.countrcode);
            System.out.println(Data.mobile);


            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/Billing_2.fxml"));

            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

//	    		                app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();

        } catch (Exception e) {
            System.out.println("Exeption catched " +e);
        }
    }

    @Deprecated
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