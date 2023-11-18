package com.systeminventory.controller;

import com.systeminventory.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

import java.io.IOException;

public class productController {

    @FXML
    private Button dashboardButton;

    @FXML
    private Button productButton;

    @FXML
    private ScrollPane productPane;

    @FXML
    private void onClickDashboardButton(ActionEvent event) throws IOException {
        App.loadDashboardScene();
    }

    @FXML
    private void onClickProductButton(ActionEvent event) {

    }

}
