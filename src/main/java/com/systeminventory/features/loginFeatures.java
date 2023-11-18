package com.systeminventory.features;

import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class loginFeatures {

    public static boolean buttonLoginClick(TextField formEmailField, TextField formPasswordField, Label labelEmailWarning, Label labelPasswordWarning, TextField formPasswordShowField, ImageView hideEye, ImageView showEye) {

        boolean statusLogin = false;
        String email = formEmailField.getText().trim();
        String password = formPasswordField.getText().trim();
        String passwordShow = formPasswordShowField.getText().trim();

        if (hideEye.isVisible() || showEye.isVisible()) {
            if (email.isEmpty()) {
                labelEmailWarning.setText("Please fill the email!");
            } else if (!isValidEmail(email)) {
                labelEmailWarning.setText("Invalid email format!");
            } else if (hideEye.isVisible() && password.isEmpty() || showEye.isVisible() && passwordShow.isEmpty()) {
                labelPasswordWarning.setText("Please fill the password!");
            } else {
                statusLogin = true;
            }
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
