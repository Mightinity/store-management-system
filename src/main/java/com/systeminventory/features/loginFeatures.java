package com.systeminventory.features;

import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class loginFeatures {

    public static boolean buttonLoginClick(TextField formEmailField, TextField formPasswordField, Label labelEmailWarning, Label labelPasswordWarning) {

        boolean statusLogin = false;
        String email = formEmailField.getText().trim();
        String password = formPasswordField.getText().trim();

        if (email.isEmpty()) {
            labelEmailWarning.setText("Please fill the email!");
        } else if (!isValidEmail(email)){
            labelEmailWarning.setText("Invalid email format!");
        } else if (password.isEmpty()) {
            labelPasswordWarning.setText(("Please fill the password!"));
        } else {
            statusLogin = true;
        }
        return statusLogin;
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
