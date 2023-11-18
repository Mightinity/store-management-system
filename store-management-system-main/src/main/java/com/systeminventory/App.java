package com.systeminventory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {

    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws IOException{
        primaryStage = stage;
        loadLoginScene();

    }

    public static void loadLoginScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("loginLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Login - Store Inventory System");
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void loadDashboardScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("dashboardLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Dashboard - Store Inventory System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void loadProductScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("productLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Product - Store Inventory System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}