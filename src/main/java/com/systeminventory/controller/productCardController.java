package com.systeminventory.controller;

import com.systeminventory.App;
import com.systeminventory.model.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class productCardController {

    @FXML
    private ImageView productCardImage;
    @FXML
    private Label productCardPrice;
    @FXML
    private Label productCardTitle;
    @FXML
    private Label productCardStock;
    @FXML
    private Pane deleteButtonProduct;
    @FXML
    private Pane editButtonProduct;
    @FXML
    private Pane infoButtonProduct;
    @FXML
    private Label keyProduct;

    public void setData(Product product){

        String imagePath = product.getImageSource();
        File file = new File(imagePath);

        if(file.exists()){
            Image image = new Image(file.toURI().toString());
            productCardImage.setImage(image);
        }
        productCardTitle.setText(product.getProductName());
        productCardPrice.setText(product.getProductPrice());
        productCardStock.setText(product.getProductStock());
        keyProduct.setText(product.getKeyProduct());

    }

    @FXML
    private void onDeleteButtonProductMouseClick(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(App.class.getResource("productLayout.fxml"));
        fxmlLoader.load();
        productController controllerFromProduct = fxmlLoader.getController();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete product");
        alert.setContentText("Apakah yakin ingin menghapus product "+productCardTitle.getText());
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isEmpty()){
            System.out.println("Alert close");
        } else if (result.get() == ButtonType.OK){
            System.out.println("Delete product "+productCardTitle.getText());
        } else if (result.get() == ButtonType.CANCEL){
            System.out.println("Cancel");
        }
//        controllerFromProduct.openConfirmDeleteDialog(keyProduct.getText(), productCardTitle.getText());
    }

    @FXML
    private void onDeleteButtonProductMouseEnter(MouseEvent mouseEvent) {
        deleteButtonProduct.setStyle("-fx-background-color: #e0005c;"+"-fx-background-radius: 5;");
    }

    @FXML
    private void onDeleteButtonProductMouseExit(MouseEvent mouseEvent) {
        deleteButtonProduct.setStyle("-fx-background-color: #ff1474;"+"-fx-background-radius: 5;");
    }

    @FXML
    private void onEditButtonProductMouseClick(MouseEvent mouseEvent) {
    }

    @FXML
    private void onEditButtonProductMouseEnter(MouseEvent mouseEvent) {
        editButtonProduct.setStyle("-fx-background-color: #14ff8e;"+"-fx-background-radius: 5;");
    }

    @FXML
    private void onEditButtonProductMouseExit(MouseEvent mouseEvent) {
        editButtonProduct.setStyle("-fx-background-color: #00e074;"+"-fx-background-radius: 5;");

    }

    @FXML
    private void onInfoButtonProductMouseClick(MouseEvent mouseEvent) {
    }

    @FXML
    private void onInfoButtonProductMouseEnter(MouseEvent mouseEvent) {
        infoButtonProduct.setStyle("-fx-background-color: #e7d039;"+"-fx-background-radius: 5;");
    }

    @FXML
    private void onInfoButtonProductMouseExit(MouseEvent mouseEvent) {
        infoButtonProduct.setStyle("-fx-background-color: #d3bb1a;"+"-fx-background-radius: 5;");
    }
}
