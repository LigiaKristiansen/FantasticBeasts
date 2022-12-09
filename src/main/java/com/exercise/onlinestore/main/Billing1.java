package com.exercise.onlinestore.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Billing1
{
    @javafx.fxml.FXML
    private ImageView numer1;
    @javafx.fxml.FXML
    private TextField email;
    @javafx.fxml.FXML
    private TextField f_name;
    @javafx.fxml.FXML
    private TextField surname;
    @javafx.fxml.FXML
    private TextField streetaddress;
    @javafx.fxml.FXML
    private TextField postaladdress;
    @javafx.fxml.FXML
    private TextField zipcode;
    @javafx.fxml.FXML
    private ComboBox country;
    @javafx.fxml.FXML
    private TextField mobile;
    @javafx.fxml.FXML
    private TextField country_code;

    @javafx.fxml.FXML
    public void initialize() {
    }
    @Deprecated
    public void next(ActionEvent event)
    {
        try{
            Data.email.add(email.getText());
            Data.fname.add(f_name.getText());
            Data.surname.add(surname.getText());
            Data.streetaddress.add(streetaddress.getText());
            Data.postaladdress.add(postaladdress.getText());
            Data.zipcode.add(zipcode.getText());
            Data.country.add(""+country.getValue());
            Data.countrcode.add(country_code.getText());
            Data.mobile.add(mobile.getText());
            System.out.println("74844");

            System.out.println(Data.email);
            System.out.println(Data.fname);
            System.out.println(Data.surname);
            System.out.println(Data.streetaddress);
            System.out.println(Data.postaladdress);
            System.out.println(Data.zipcode);

            Parent home_page_parent = FXMLLoader.load(getClass().getResource("Billing_2.fxml"));

            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

//	    		                app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();


        }
        catch(Exception e)
        {}
    }
    @Deprecated
    public void proceed_to_delivery(ActionEvent event)
    {
        Data.email.add(email.getText());
        Data.fname.add(f_name.getText());
        Data.surname.add(surname.getText());
        Data.streetaddress.add(streetaddress.getText());
        Data.postaladdress.add(postaladdress.getText());
        Data.zipcode.add(zipcode.getText());
        Data.country.add(""+country.getValue());
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
    }




}
