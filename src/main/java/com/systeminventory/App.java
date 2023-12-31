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

    public static Stage getPrimaryStage(){
        return primaryStage;
    }

    public static void loadLoginScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("loginLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Login - Store Inventory System");
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void loadLogoutScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("loginLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Login - Store Inventory System");
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

    public static void loadCashierScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("cashierLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Cashier - Store Inventory System");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void loadEmployeeDashboardScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("employeeProductLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Dashboard Employee - Store Inventory System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void loadEmployeeCashierScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("employeeCashierLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Dashboard Employee - Store Inventory System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}