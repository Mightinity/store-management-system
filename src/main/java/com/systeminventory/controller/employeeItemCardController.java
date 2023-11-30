package com.systeminventory.controller;

import com.systeminventory.interfaces.DeleteItemCashierListener;
import com.systeminventory.model.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class employeeItemCardController {
    @FXML
    private Pane buttonDeleteItem;
    @FXML
    private Label varIdProduct;
    @FXML
    private Label varProductName;
    @FXML
    private Label varQuantity;
    @FXML
    private Label varPrice;
    @FXML
    private Label varTotalPrices;
    @FXML
    private Label varNoitem;

    private Item item;
    private DeleteItemCashierListener deleteItemCashierListener;

    public void setData(Item item, DeleteItemCashierListener deleteitemCashierListener){
        this.item = item;
        this.deleteItemCashierListener = deleteitemCashierListener;
        varNoitem.setText(item.getNoItem());
        varIdProduct.setText(item.getIdItem());
        varProductName.setText(item.getItemName());
        varQuantity.setText(item.getItemQuantity());
        varPrice.setText(item.getItemPrice());
        varTotalPrices.setText(item.getItemTotalPrice());
    }

    @FXML
    private void buttonDeleteItemMouseClick(MouseEvent mouseEvent) {
        deleteItemCashierListener.clickDeleteItemCashierListener(item);
    }

    @FXML
    private void buttonDeleteItemMouseEnter(MouseEvent mouseEvent) {
        buttonDeleteItem.setStyle("-fx-background-color: #e0005c;"+"-fx-background-radius: 5");
    }

    @FXML
    private void buttonDeleteItemMouseExit(MouseEvent mouseEvent) {
        buttonDeleteItem.setStyle("-fx-background-color: #ff1474;"+"-fx-background-radius: 5");
    }
}
