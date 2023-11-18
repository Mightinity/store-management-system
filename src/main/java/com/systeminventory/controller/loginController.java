package com.systeminventory.controller;

import com.systeminventory.features.loginFeatures;
import com.systeminventory.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
    private ImageView hideEye;
    @FXML
    private ImageView showEye;
    @FXML
    private TextField formPasswordShowField;
    @FXML
    private Button buttonLogin;

    @FXML
    private void onButtonLoginClick() throws IOException {
        labelEmailWarning.setText("");
        labelPasswordWarning.setText("");
        boolean statusLogin = loginFeatures.buttonLoginClick(formEmailField, formPasswordField, labelEmailWarning, labelPasswordWarning, formPasswordShowField, hideEye, showEye);
        if (statusLogin){
            App.loadDashboardScene();
        }
    }

    @FXML
    // SET PASSWORD TO PLAINTEXT
    private void onHideEyeClick(MouseEvent mouseEvent) {
        hideEye.setVisible(false);
        showEye.setVisible(true);
        formPasswordShowField.setText(formPasswordField.getText());
        formPasswordField.setVisible(false);
        formPasswordShowField.setVisible(true);

    }

    @FXML
    private void onShowEyeClick(MouseEvent mouseEvent) {
        showEye.setVisible(false);
        hideEye.setVisible(true);
        formPasswordField.setText(formPasswordShowField.getText());
        formPasswordShowField.setVisible(false);
        formPasswordField.setVisible(true);
    }

    @FXML
    private void onButtonLoginMouseEnter(MouseEvent mouseEvent) {
        buttonLogin.setStyle("-fx-background-color: #ffa132;" + "-fx-background-radius: 23");
    }

    @FXML
    private void onButtonLoginMouseExit(MouseEvent mouseEvent) {
        buttonLogin.setStyle("-fx-background-color: #fe8a00;" + "-fx-background-radius: 23");
    }
}
