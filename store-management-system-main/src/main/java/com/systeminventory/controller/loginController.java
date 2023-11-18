package com.systeminventory.controller;

import com.systeminventory.features.loginFeatures;
import com.systeminventory.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class loginController {
    @FXML
    private TextField formEmailField;
    @FXML
    private TextField formPasswordField;
    @FXML
    private Label labelEmailWarning;
    @FXML
    private Label labelPasswordWarning;

    @FXML
    private void onButtonLoginClick() throws IOException {
        labelEmailWarning.setText("");
        labelPasswordWarning.setText("");
        boolean statusLogin = loginFeatures.buttonLoginClick(formEmailField, formPasswordField, labelEmailWarning, labelPasswordWarning);
        if (statusLogin){
            App.loadDashboardScene();
        }
    }
}
