package com.systeminventory.controller;

import com.systeminventory.interfaces.DeleteCashierListener;
import com.systeminventory.interfaces.ProfileDetailsListener;
import com.systeminventory.model.Cashier;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

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
    private DeleteCashierListener deleteCashierListener;
    @FXML
    private Pane deleteButtonProfileCard;
    @FXML
    private Pane editButtonProfileCard;

    public void setData(Cashier cashier, ProfileDetailsListener profileDetailsListener, DeleteCashierListener deleteCashierListener){
        this.cashier = cashier;
        this.profileDetailsListener = profileDetailsListener;
        this.deleteCashierListener = deleteCashierListener;
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

    @FXML
    private void deleteButtonProfileCardMouseClick(MouseEvent mouseEvent) {
        deleteCashierListener.clickDeleteCashierListener(cashier);
    }

    @FXML
    private void deleteButtonProfileCardMouseEnter(MouseEvent mouseEvent) {
        deleteButtonProfileCard.setStyle("-fx-background-color: #e0005c;"+"-fx-background-radius: 5;");
    }

    @FXML
    private void deleteButtonProfileCardMouseExit(MouseEvent mouseEvent) {
        deleteButtonProfileCard.setStyle("-fx-background-color: #ff1474;"+"-fx-background-radius: 5;");
    }

    @FXML
    private void editButtonProfileCardMouseClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void editButtonProfileCardMouseEnter(MouseEvent mouseEvent) {
        editButtonProfileCard.setStyle("-fx-background-color: #00954d;"+"-fx-background-radius: 5;");
    }

    @FXML
    private void editButtonProfileCardMouseExit(MouseEvent mouseEvent) {
        editButtonProfileCard.setStyle("-fx-background-color: #00c868;"+"-fx-background-radius: 5;");
    }
}
