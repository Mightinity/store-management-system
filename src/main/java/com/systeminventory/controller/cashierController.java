package com.systeminventory.controller;

import com.systeminventory.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class cashierController {
    @FXML
    private Pane backgroundPopup;
    @FXML
    private Button buttonCashier;
    @FXML
    private Button buttonDashboard;
    @FXML
    private Button buttonProduct;
    @FXML
    private Button logoutDropdown;
    @FXML
    private Pane profileDropdown;
    @FXML
    private Button settingsDropdown;
    @FXML
    private Pane addProfilePopup;
    @FXML
    private Label addProfileNameLabel;
    @FXML
    private TextField addProfileNameField;
    @FXML
    private Label addProfileEmailLabel;
    @FXML
    private TextField addProfileEmailField;
    @FXML
    private Label addProfileNoPhoneLabel;
    @FXML
    private TextField addProfileNoPhoneField;
    @FXML
    private Label addProfileDateOfBirthLabel;
    @FXML
    private TextField addProfileDateOfBirthField;
    @FXML
    private Label addProfileAddressLabel;
    @FXML
    private TextField addProfileAddressField;
    @FXML
    private Label addProfileProfilePictureLabel;
    @FXML
    private Label addProfileProfileImagePathLabel;
    @FXML
    private Button addProfileApplyButton;
    @FXML
    private Button addProfileCancelButton;
    @FXML
    private Label addProfileProfileImageFullPathLabel;
    @FXML
    private Button buttonAddProfile;
    @FXML
    private Pane addProfileChooseFilePane;

    @FXML
    void onAddProfileChooseFilePaneMouseClick(MouseEvent event) {
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Select profile picture");
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
        File selectedFile = filechooser.showOpenDialog(App.getPrimaryStage());
        if(selectedFile != null){
            setLabelPropertiesTextFillWhite(addProfileProfilePictureLabel, "Profile picture:");
            addProfileProfileImagePathLabel.setText(selectedFile.getName());
            addProfileProfileImageFullPathLabel.setText(selectedFile.getPath());
        }
    }

    @FXML
    void onAddProfileChooseFilePaneMouseEnter(MouseEvent event) {
        addProfileChooseFilePane.setStyle("-fx-background-color: #ffa132;" + "-fx-background-radius: 5;" + "-fx-border-color: #f6f6f6;" + "-fx-border-radius: 5;");
    }

    @FXML
    void onAddProfileChooseFilePaneMouseExit(MouseEvent event) {
        addProfileChooseFilePane.setStyle("-fx-background-color: #fe8a00;" + "-fx-background-radius: 5;" + "-fx-border-color: #f6f6f6;" + "-fx-border-radius: 5;");
    }

    @FXML
    private void onButtonAddProfileMouseExit(MouseEvent mouseEvent) {
        buttonAddProfile.setStyle("-fx-background-color: #fe8a00;" + "-fx-background-radius: 20;");
    }

    @FXML
    private void onButtonAddProfileMouseEnter(MouseEvent mouseEvent) {
        buttonAddProfile.setStyle("-fx-background-color: #ffa132;" + "-fx-background-radius: 20;");
    }


    @FXML
    void onButtonDashboardClick(ActionEvent event) throws IOException {
        App.loadDashboardScene();

    }

    @FXML
    private void onButtonDashboardMouseEnter(MouseEvent mouseEvent) {
        buttonDashboard.setStyle("-fx-background-color: #697b7b;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #151d26;" + "-fx-background-radius: 20;" + "-fx-border-radius: 20;");

    }

    @FXML
    private void onButtonDashboardMouseExit(MouseEvent mouseEvent) {
        buttonDashboard.setStyle("-fx-background-color: #151d26;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #697b7b;" +  "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    void onButtonProductClick(ActionEvent event) throws IOException {
        App.loadProductScene();
    }

    @FXML
    void onButtonProductMouseEnter(MouseEvent event) {
        buttonProduct.setStyle("-fx-background-color: #697b7b;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #151d26;" + "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    void onButtonProductMouseExit(MouseEvent event) {
        buttonProduct.setStyle("-fx-background-color: #151d26;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #697b7b;" +  "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    void onButtonCashierClick(ActionEvent event) {
    }
    @FXML
    void onCashierProductMouseEnter(MouseEvent event) {
    }
    @FXML
    void onCashierProductMouseExit(MouseEvent event) {
    }

    @FXML
    void onLogoutClick(ActionEvent event) throws IOException {
        App.loadLogoutScene();
    }

    @FXML
    void onLogoutDropdownMouseEnter(MouseEvent event) {
        logoutDropdown.setStyle("-fx-background-color: #2f3d4e;" + "-fx-background-radius: 11");
    }

    @FXML
    void onLogoutDropdownMouseExit(MouseEvent event) {
        logoutDropdown.setStyle("-fx-background-color: #1c242e;" + "-fx-background-radius: 11");
    }

    @FXML
    void onProfileClick(MouseEvent event) {
        profileDropdown.setVisible(!profileDropdown.isVisible());
    }

    @FXML
    void onProfileDropdownMouseExit(MouseEvent event) {
        profileDropdown.setVisible(false);
    }

    @FXML
    void onSettingsDropdownMouseEnter(MouseEvent event) {
        settingsDropdown.setStyle("-fx-background-color: #2f3d4e;" + "-fx-background-radius: 11");
    }

    @FXML
    void onSettingsDropdownMouseExit(MouseEvent event) {
        settingsDropdown.setStyle("-fx-background-color: #1c242e;" + "-fx-background-radius: 11");
    }

    private void setLabelPropertiesTextFillWhite(Label label, String text){
        label.setText(text);
        label.setStyle("-fx-text-fill: #f6f6f6;");
    }

    @FXML
    void onButtonAddProfileClick(ActionEvent event) {
        addProfileNameField.setText("");
        addProfileEmailField.setText("");
        addProfileNoPhoneField.setText("");
        addProfileDateOfBirthField.setText("");
        addProfileAddressField.setText("");
        addProfileProfileImagePathLabel.setText("");
        setLabelPropertiesTextFillWhite(addProfileNameLabel, "Name:");
        setLabelPropertiesTextFillWhite(addProfileEmailLabel, "Email:");
        setLabelPropertiesTextFillWhite(addProfileNoPhoneLabel, "No phone:");
        setLabelPropertiesTextFillWhite(addProfileDateOfBirthLabel, "Date of birth:");
        setLabelPropertiesTextFillWhite(addProfileAddressLabel, "Address:");
        setLabelPropertiesTextFillWhite(addProfileProfilePictureLabel, "Profile picture:");
        backgroundPopup.setVisible(true);
        addProfilePopup.setVisible(true);
    }

    @FXML
    private void onAddProfileApplyButtonClick(ActionEvent actionEvent) {
        setLabelPropertiesTextFillWhite(addProfileNameLabel, "Name:");
        setLabelPropertiesTextFillWhite(addProfileEmailLabel, "Email:");
        setLabelPropertiesTextFillWhite(addProfileNoPhoneLabel, "No phone:");
        setLabelPropertiesTextFillWhite(addProfileDateOfBirthLabel, "Date of birth:");
        setLabelPropertiesTextFillWhite(addProfileAddressLabel, "Address:");
        setLabelPropertiesTextFillWhite(addProfileProfilePictureLabel, "Profile picture:");
        int status = 0;
        if (addProfileNameField.getText().isEmpty()){
            addProfileNameLabel.setText("Name: (Required)");
            addProfileNameLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (addProfileEmailField.getText().isEmpty()){
            addProfileEmailLabel.setText("Email: (Required)");
            addProfileEmailLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (addProfileNoPhoneField.getText().isEmpty()){
            addProfileNoPhoneLabel.setText("No phone: (Required)");
            addProfileNoPhoneLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (addProfileDateOfBirthField.getText().isEmpty()){
            addProfileDateOfBirthLabel.setText("Date of birth: (Required)");
            addProfileDateOfBirthLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (addProfileAddressField.getText().isEmpty()){
            addProfileAddressLabel.setText("Address: (Required)");
            addProfileAddressLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (addProfileProfileImagePathLabel.getText().isEmpty()){
            addProfileProfilePictureLabel.setText("Profile picture: (Required)");
            addProfileProfilePictureLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (status == 0){
            System.out.println(addProfileNameField.getText());
            System.out.println(addProfileEmailField.getText());
            System.out.println(addProfileNoPhoneField.getText());
            System.out.println(addProfileDateOfBirthField.getText());
            System.out.println(addProfileAddressField.getText());
            System.out.println(addProfileProfileImagePathLabel.getText());
        }
    }

    @FXML
    private void onAddProfileApplyButtonMouseEnter(MouseEvent mouseEvent) {
        addProfileApplyButton.setStyle("-fx-background-color: #33b8ff;" + "-fx-background-radius: 13");
    }

    @FXML
    private void onAddProfileApplyButtonMouseExit(MouseEvent mouseEvent) {
        addProfileApplyButton.setStyle("-fx-background-color: #00a6ff;" + "-fx-background-radius: 13");
    }

    @FXML
    private void onAddProfileCancelButtonClick(ActionEvent actionEvent) {
        backgroundPopup.setVisible(false);
        addProfilePopup.setVisible(false);
    }

    @FXML
    private void onAddProfileCancelButtonMouseEnter(MouseEvent mouseEvent) {
        addProfileCancelButton.setStyle("-fx-background-color: #e0005c;" + "-fx-background-radius: 13");
    }

    @FXML
    private void onAddProfileCancelButtonMouseExit(MouseEvent mouseEvent) {
        addProfileCancelButton.setStyle("-fx-background-color: #ff1474;" + "-fx-background-radius: 13");

    }
}
