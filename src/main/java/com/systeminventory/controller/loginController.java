package com.systeminventory.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.systeminventory.features.loginFeatures;
import com.systeminventory.App;
import com.systeminventory.model.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

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

    private void handleEnterKey(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            labelEmailWarning.setText("");
            labelPasswordWarning.setText("");
            boolean statusLogin = loginFeatures.validFillForm(formEmailField, formPasswordField, labelEmailWarning, labelPasswordWarning, formPasswordShowField, hideEye, showEye);
            if (statusLogin) {

                String email = formEmailField.getText().trim();
                String password = formPasswordField.getText().trim();

//                App.loadCashierDashboardScene();
                if (email.equals("admin@admin.com") && password.equals("admin")){
                    App.loadDashboardScene();
                } else if (isCashierCredentialsValid(email, password)) {
                    App.loadCashierDashboardScene();
                } else {
                    labelEmailWarning.setText("Invalid email or password");
                }
            }
        }
    }

    private boolean isCashierCredentialsValid(String enteredEmail, String enteredPassword){
        Gson gson = new Gson();
        String jsonPath = "./src/main/java/com/systeminventory/assets/json/cashierList.json";
        try(InputStream inputStream = new FileInputStream(jsonPath)){
            InputStreamReader reader = new InputStreamReader(inputStream);
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            List<String> profileKeys = new ArrayList<>(jsonObject.keySet());

            for (String employeeCashier : profileKeys){
                JsonObject employeeData = jsonObject.getAsJsonObject(employeeCashier);

                String employeeEmail = employeeData.get("Email").getAsString();
                String employeePassword = employeeData.get("Password").getAsString();

                if (enteredEmail.equals(employeeEmail) && hashMD5(enteredPassword).equals(employeePassword)) {
                    return true;
                }
            }
        } catch (IOException err){
            err.printStackTrace();
        }
        return false;
    }


    private static String hashMD5(String input) {
        StringBuilder result = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] byteData = md.digest();

            for (byte aByteData : byteData) {
                result.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @FXML
    private void onButtonLoginClick() throws IOException {
        labelEmailWarning.setText("");
        labelPasswordWarning.setText("");
        boolean statusLogin = loginFeatures.validFillForm(formEmailField, formPasswordField, labelEmailWarning, labelPasswordWarning, formPasswordShowField, hideEye, showEye);
        if (statusLogin){
            App.loadDashboardScene();
        }
    }

    @FXML
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

    @FXML
    private void onKeyPressLogin(KeyEvent keyEvent) throws IOException {
        handleEnterKey(keyEvent);
    }

    @FXML
    private void onKeyPressEmail(KeyEvent keyEvent) throws IOException {
        handleEnterKey(keyEvent);
    }

    @FXML
    private void onKeyPressPassword(KeyEvent keyEvent) throws IOException {
        handleEnterKey(keyEvent);
    }
}
