package com.systeminventory.controller;

import com.systeminventory.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class dashboardController {

    @FXML
    private Button dashboardButton;
    @FXML
    private ScrollPane dashboardPane;
    @FXML
    private Button productButton;
    @FXML
    private AreaChart<CategoryAxis, NumberAxis> reportChart;
    @FXML
    private void onClickDashboardButton(ActionEvent event) {
    }
    @FXML
    private void onClickProductButton(ActionEvent event) throws IOException {
        App.loadProductScene();
    }
}
