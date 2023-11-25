package com.systeminventory.controller;

import com.systeminventory.interfaces.DeleteProductListener;
import com.systeminventory.interfaces.DetailsProductListener;
import com.systeminventory.interfaces.EditProductListener;
import com.systeminventory.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;

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

    private Product product;
    private DeleteProductListener deleteProductListener;
    private EditProductListener editProductListener;
    private DetailsProductListener detailsProductListener;

    public void setData(Product product, DeleteProductListener deleteProductListener, EditProductListener editProductListener, DetailsProductListener detailsProductListener){
        this.product = product;
        this.deleteProductListener = deleteProductListener;
        this.editProductListener = editProductListener;
        this.detailsProductListener = detailsProductListener;
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
    private void onDeleteButtonProductMouseClick(MouseEvent mouseEvent) throws IOException {
        deleteProductListener.clickDeleteProductListener(product);
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
        editProductListener.clickEditProductListener(product);
    }

    @FXML
    private void onEditButtonProductMouseEnter(MouseEvent mouseEvent) {
        editButtonProduct.setStyle("-fx-background-color: #00c164;"+"-fx-background-radius: 5;");
    }

    @FXML
    private void onEditButtonProductMouseExit(MouseEvent mouseEvent) {
        editButtonProduct.setStyle("-fx-background-color: #00e074;"+"-fx-background-radius: 5;");

    }

    @FXML
    private void onInfoButtonProductMouseClick(MouseEvent mouseEvent) {
        detailsProductListener.clickDetailsProductListener(product);
    }

    @FXML
    private void onInfoButtonProductMouseEnter(MouseEvent mouseEvent) {
        infoButtonProduct.setStyle("-fx-background-color: #bea817;"+"-fx-background-radius: 5;");
    }

    @FXML
    private void onInfoButtonProductMouseExit(MouseEvent mouseEvent) {
        infoButtonProduct.setStyle("-fx-background-color: #d3bb1a;"+"-fx-background-radius: 5;");
    }
}
