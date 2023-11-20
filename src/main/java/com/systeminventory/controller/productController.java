package com.systeminventory.controller;

import com.systeminventory.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class productController {

    @FXML
    public Pane filterDropdown;
    @FXML
    public Button filterButton;
    public ImageView imageFIlter;
    @FXML
    private Pane profileDropdown;
    @FXML
    private Button settingsDropdown;
    @FXML
    private Button buttonCashier;
    @FXML
    private Button buttonProduct;
    @FXML
    private Button logoutDropdown;
    @FXML
    private Button buttonDashboard;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button buttonAddProduct;
    @FXML
    private Pane backgroundPopup;
    @FXML
    private Pane addProductPopup;

    @FXML
    void onButtonCashierClick(ActionEvent event) {

    }

    @FXML
    void onButtonDashboardClick(ActionEvent event) throws IOException {
        App.loadDashboardScene();
    }

    @FXML
    void onButtonProductClick(ActionEvent event) throws IOException {
    }

    @FXML
    void onLogoutClick(ActionEvent event) throws IOException {
        App.loadLogoutScene();
    }

    @FXML
    void onProfileClick(MouseEvent event) {
        if(profileDropdown.isVisible()){
            profileDropdown.setVisible(false);
        } else {
            profileDropdown.setVisible(true);
        }
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
    void onSettingsDropdownMouseEnter(MouseEvent event) {
        settingsDropdown.setStyle("-fx-background-color: #2f3d4e;" + "-fx-background-radius: 11");
    }

    @FXML
    void onSettingsDropdownMouseExit(MouseEvent event) {
        settingsDropdown.setStyle("-fx-background-color: #1c242e;" + "-fx-background-radius: 11");
    }

    @FXML
    private void onButtonProductMouseEnter(MouseEvent mouseEvent) {
    }

    @FXML
    private void onButtonProductMouseExit(MouseEvent mouseEvent) {
    }

    @FXML
    private void onCashierProductMouseEnter(MouseEvent mouseEvent) {
        buttonCashier.setStyle("-fx-background-color: #697b7b;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #151d26;" + "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    private void onCashierProductMouseExit(MouseEvent mouseEvent) {
        buttonCashier.setStyle("-fx-background-color: #151d26;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #697b7b;" +  "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    private void onProfileDropdownMouseExit(MouseEvent mouseEvent) {
        profileDropdown.setVisible(false);
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
    private void initialize() {
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }

    public void onFilterButtonClick(ActionEvent actionEvent) {
        filterDropdown.setVisible(!filterDropdown.isVisible());
    }

    @FXML
    public void onFilterButtonMouseEnter(MouseEvent mouseEvent) {
        filterButton.setStyle("-fx-background-color: #ffa132;" + "-fx-background-radius: 20;");
    }

    @FXML
    public void onFilterButtonMouseExit(MouseEvent mouseEvent) {
        filterButton.setStyle("-fx-background-color: #fe8a00;" + "-fx-background-radius: 20;");
    }
    @FXML
    public void onImageFilterMouseEnter(MouseEvent mouseEvent) {
        filterButton.setStyle("-fx-background-color: #ffa132;" + "-fx-background-radius: 20;");
    }

    @FXML
    public void onFilterDropdownMouseExit(MouseEvent mouseEvent) {
        filterDropdown.setVisible(false);
    }

    @FXML
    private void onImageFilterMouseClick(MouseEvent mouseEvent) {
        filterDropdown.setVisible(!filterDropdown.isVisible());
    }

    @FXML
    private void onButtonAddProductMouseExit(MouseEvent mouseEvent) {
        buttonAddProduct.setStyle("-fx-background-color: #fe8a00;" + "-fx-background-radius: 20;");
    }

    @FXML
    private void onButtonAddProductMouseEnter(MouseEvent mouseEvent) {
        buttonAddProduct.setStyle("-fx-background-color: #ffa132;" + "-fx-background-radius: 20;");
    }

    @FXML
    private void onButtonAddProductClick(ActionEvent actionEvent) {
        backgroundPopup.setVisible(true);
        addProductPopup.setVisible(true);
    }
}
