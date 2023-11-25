package com.systeminventory.controller;

import com.systeminventory.interfaces.ProfileDetailsListener;
import com.systeminventory.model.Cashier;
import javafx.fxml.FXML;
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
    private Cashier cashier;
    private ProfileDetailsListener profileDetailsListener;

    public void setData(Cashier cashier, ProfileDetailsListener profileDetailsListener){
        this.cashier = cashier;
        this.profileDetailsListener = profileDetailsListener;
        String imagePath = cashier.getCashierImageSource();
        File file = new File(imagePath);
        if(file.exists()){
            Image image = new Image(file.toURI().toString());
            profileCardImage.setImage(image);
        }
        profileCardName.setText(cashier.getCashierName());
        profileCardNoPhone.setText(cashier.getCashierNoPhone());
        profileCardEmail.setText(cashier.getCashierEmail());
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
    private void cashierProfileBackgroundMouseClick(MouseEvent mouseEvent) {
        profileDetailsListener.clickProfileDetailsListener(cashier);
    }
}
