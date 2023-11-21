package com.systeminventory.controller;

import com.systeminventory.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class productCardContoller {

    @FXML
    private ImageView productCardImage;

    @FXML
    private Label productCardPrice;

    @FXML
    private Label productCardTitle;

    @FXML
    private Label productCardStock;

    public void setData(Product product){
//        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(product.getImageSource())));
//        productCardImage.setImage(image);
//        productCardTitle.setText(product.getProductName());
//        productCardPrice.setText(product.getProductPrice());
//        productCardStock.setText(product.getProductStock());

        String imagePath = product.getImageSource();
        File file = new File(imagePath);

        if(file.exists()){
            Image image = new Image(file.toURI().toString());
            productCardImage.setImage(image);
        }
        productCardTitle.setText(product.getProductName());
        productCardPrice.setText(product.getProductPrice());
        productCardStock.setText(product.getProductStock());

    }
}
