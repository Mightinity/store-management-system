package com.systeminventory.controller;

import com.systeminventory.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class employeeCashierController {
    @FXML
    private Button buttonProduct;
    @FXML
    private Button buttonCashier;
    @FXML
    private Button buttonHistory;
    @FXML
    private ImageView profileImage;
    @FXML
    private Pane profileDropdown;
    @FXML
    private Label varNameSettingsProfileDropdown;
    @FXML
    private Button settingsDropdown;
    @FXML
    private Button logoutDropdown;
    @FXML
    private Label valTotalItems;
    @FXML
    private Label varTotalPrices;

    @FXML
    private void onButtonProductClick(ActionEvent actionEvent) throws IOException {
        App.loadEmployeeDashboardScene();
    }

    @FXML
    private void onButtonProductMouseEnter(MouseEvent mouseEvent) {
        buttonProduct.setStyle("-fx-background-color: #697b7b;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #151d26;" + "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    private void onButtonProductMouseExit(MouseEvent mouseEvent) {
        buttonProduct.setStyle("-fx-background-color: #151d26;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #697b7b;" +  "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    private void onButtonCashierClick(ActionEvent actionEvent) {
    }

    @FXML
    private void onButtonCashierMouseEnter(MouseEvent mouseEvent) {
    }

    @FXML
    private void onButtonCashierMouseExit(MouseEvent mouseEvent) {
    }

    @FXML
    private void onButtonHistoryClick(ActionEvent actionEvent) {
    }

    @FXML
    private void onButtonHistoryMouseEnter(MouseEvent mouseEvent) {
    }

    @FXML
    private void onButtonHistoryMouseExit(MouseEvent mouseEvent) {
    }

    @FXML
    private void onProfileClick(MouseEvent mouseEvent) {
        profileDropdown.setVisible(!profileDropdown.isVisible());
    }

    @FXML
    private void onProfileDropdownMouseExit(MouseEvent mouseEvent) {
        profileDropdown.setVisible(false);
    }

    @FXML
    private void onSettingsDropdownMouseEnter(MouseEvent mouseEvent) {
        settingsDropdown.setStyle("-fx-background-color: #2f3d4e;" + "-fx-background-radius: 11");
    }

    @FXML
    private void onSettingsDropdownMouseExit(MouseEvent mouseEvent) {
        settingsDropdown.setStyle("-fx-background-color: #1c242e;" + "-fx-background-radius: 11");
    }

    @FXML
    private void onLogoutClick(ActionEvent actionEvent) throws IOException {
        App.loadLogoutScene();
    }

    @FXML
    private void onLogoutDropdownMouseEnter(MouseEvent mouseEvent) {
        logoutDropdown.setStyle("-fx-background-color: #2f3d4e;" + "-fx-background-radius: 11");
    }

    @FXML
    private void onLogoutDropdownMouseExit(MouseEvent mouseEvent) {
        logoutDropdown.setStyle("-fx-background-color: #1c242e;" + "-fx-background-radius: 11");

    }
}
