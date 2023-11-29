package com.systeminventory.controller;


import com.systeminventory.interfaces.EmployeeDetailsProductListener;
import com.systeminventory.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.File;

public class employeeProductCardController {
    @FXML
    private Pane infoButtonProduct;

    @FXML
    private Label keyProduct;

    @FXML
    private ImageView productCardImage;

    @FXML
    private Label productCardPrice;

    @FXML
    private Label productCardStock;

    @FXML
    private Label productCardTitle;

    private Product product;
    private EmployeeDetailsProductListener employeeDetailsProductListener;

    public void setData(Product product, EmployeeDetailsProductListener employeeDetailsProductListener){
        this.product = product;
        this.employeeDetailsProductListener = employeeDetailsProductListener;

        String imagePath = product.getImageSource();
        File file = new File(imagePath);

        if(file.exists()){
            Image image = new Image(file.toURI().toString());
            productCardImage.setImage(image);
        }
        productCardTitle.setText(product.getProductName());
        productCardPrice.setText(product.getProductSellingPrice());
        productCardStock.setText(product.getProductStock());
        keyProduct.setText(product.getKeyProduct());

    }
    @FXML
    private void onInfoButtonProductMouseClick(MouseEvent event) {
        employeeDetailsProductListener.clickEmployeeDetailsProductListener(product);
    }

    @FXML
    private void onInfoButtonProductMouseEnter(MouseEvent event) {
        infoButtonProduct.setStyle("-fx-background-color: #bea817;"+"-fx-background-radius: 5;");
    }

    @FXML
    private void onInfoButtonProductMouseExit(MouseEvent event) {
        infoButtonProduct.setStyle("-fx-background-color: #d3bb1a;"+"-fx-background-radius: 5;");
    }
}
