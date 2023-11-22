package com.systeminventory.controller;

import com.systeminventory.model.Cashier;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class cashierProfileCardController {
    @FXML
    private ImageView profileCardImage;

    @FXML
    private Label profileCardName;

    @FXML
    private Label profileCardNoPhone;
    @FXML
    private Label profileCardEmail;

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


    }
}
