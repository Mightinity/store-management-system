package com.systeminventory.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.systeminventory.App;
import com.systeminventory.model.Cashier;
import com.systeminventory.model.ProfileCard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.*;

public class cashierProfileCardController {
    @FXML
    private ImageView profileCardImage;
    @FXML
    private Label profileCardName;
    @FXML
    private Label profileCardNoPhone;
    @FXML
    private Label profileCardEmail;
    @FXML
    private AnchorPane cashierProfileBackground;
    @FXML
    private Label keyCashierProfile;

    public void setData(Cashier cashier){
        String imagePath = cashier.getCashierImageSource();
        File file = new File(imagePath);
        if(file.exists()){
            Image image = new Image(file.toURI().toString());
            profileCardImage.setImage(image);
        }
        profileCardName.setText(cashier.getCashierName());
        profileCardNoPhone.setText(cashier.getCashierNoPhone());
        profileCardEmail.setText(cashier.getCashierEmail());
        keyCashierProfile.setText(cashier.getKeyCashier());
    }

    @FXML
    private void cashierProfileBackgroundMouseEnter(MouseEvent mouseEvent) {
        cashierProfileBackground.setStyle("-fx-background-color: #344450;"+"-fx-background-radius: 17;"+"-fx-border-color: #fe8a00;"+"-fx-border-radius: 17");
    }

    @FXML
    private void cashierProfileBackgroundMouseExit(MouseEvent mouseEvent) {
        cashierProfileBackground.setStyle("-fx-background-color: #202a31;"+"-fx-background-radius: 17;"+"-fx-border-color: #fe8a00;"+"-fx-border-radius: 17");
    }

    @FXML
    private void cashierProfileBackgroundMouseClick(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(App.class.getResource("cashierLayout.fxml"));
        fxmlLoader.load();
        cashierController controllerFromCashier = fxmlLoader.getController();
        controllerFromCashier.setDataCashierProfileDetails(keyCashierProfile.getText());
    }
}
