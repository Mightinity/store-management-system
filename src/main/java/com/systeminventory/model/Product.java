package com.systeminventory.model;

public class Product {
    private String productName;
    private String imageSource;
    private String productPrice;
    private String productStock;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductStock() {
        return productStock;
    }

    public void setProductStock(String productStock) {
        this.productStock = productStock;
    }
}
