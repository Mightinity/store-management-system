package com.systeminventory.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.systeminventory.App;
import com.systeminventory.interfaces.EmployeeDetailsProductListener;
import com.systeminventory.model.Employee;
import com.systeminventory.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class employeeProductController {
    @FXML
    private Button buttonProduct;
    @FXML
    private Button buttonCashier;
    @FXML
    private Button buttonHistory;
    @FXML
    private ImageView profileImage;
    @FXML
    private Button filterButton;
    @FXML
    private TextField searchProductNameField;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private GridPane productCardContainer;
    @FXML
    private Pane profileDropdown;
    @FXML
    private Label varNameSettingsProfileDropdown;
    @FXML
    private Button settingsDropdown;
    @FXML
    private Button logoutDropdown;
    @FXML
    private Pane filterDropdown;
    @FXML
    private Pane backgroundPopup;
    @FXML
    private Pane detailsProductPopup;
    @FXML
    private Button cancelButtonDetailsProduct;
    @FXML
    private Label varProductNameDetailsProduct;
    @FXML
    private Label varOriginalPriceDetailsProduct;
    @FXML
    private Label varSellingPriceDetailsProduct;
    @FXML
    private Label varProductStockDetailsProduct;
    @FXML
    private ImageView barcodeImageDetailsProduct;
    @FXML
    private Button downloadBarcodeDetailsProduct;
    @FXML
    private Label idProductDetailsProduct;

    private EmployeeDetailsProductListener employeeDetailsProductListener;
    @FXML
    private Pane downloadAlertPopup;
    @FXML
    private Label varStatusDownload;
    @FXML
    private Button okButtonStatusDownloadPopup;
    @FXML
    private Label confirmDeleteKeyProduct;
    @FXML
    private Pane backgroundPopupDownload;

    @FXML
    private void onButtonProductClick(ActionEvent actionEvent) {
    }

    @FXML
    private void onButtonProductMouseEnter(MouseEvent mouseEvent) {
    }

    @FXML
    private void onButtonProductMouseExit(MouseEvent mouseEvent) {
    }

    @FXML
    private void onButtonCashierClick(ActionEvent actionEvent) throws IOException {
        App.loadEmployeeCashierScene();
    }

    @FXML
    private void onButtonCashierMouseEnter(MouseEvent mouseEvent) {
        buttonCashier.setStyle("-fx-background-color: #697b7b;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #151d26;" + "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    private void onButtonCashierMouseExit(MouseEvent mouseEvent) {
        buttonCashier.setStyle("-fx-background-color: #151d26;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #697b7b;" +  "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    private void onButtonHistoryClick(ActionEvent actionEvent) {
    }

    @FXML
    private void onButtonHistoryMouseEnter(MouseEvent mouseEvent) {
        buttonHistory.setStyle("-fx-background-color: #697b7b;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #151d26;" + "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    private void onButtonHistoryMouseExit(MouseEvent mouseEvent) {
        buttonHistory.setStyle("-fx-background-color: #151d26;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #697b7b;" + "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    private void onProfileClick(MouseEvent mouseEvent) {
        profileDropdown.setVisible(!profileDropdown.isVisible());
    }

    @FXML
    private void onFilterButtonClick(ActionEvent actionEvent) {
        filterDropdown.setVisible(!filterDropdown.isVisible());
    }

    @FXML
    private void onFilterButtonMouseEnter(MouseEvent mouseEvent) {
        filterButton.setStyle("-fx-background-color: #ffa132;" + "-fx-background-radius: 20;");
    }

    @FXML
    private void onFilterButtonMouseExit(MouseEvent mouseEvent) {
        filterButton.setStyle("-fx-background-color: #fe8a00;" + "-fx-background-radius: 20;");
    }

    @FXML
    private void searchTermKeyPress(KeyEvent keyEvent) {
    }

    @FXML
    private void onProfileDropdownMouseExit(MouseEvent mouseEvent) {
        profileDropdown.setVisible(false);
    }

    @FXML
    private void onSettingsDropdownMouseEnter(MouseEvent mouseEvent) {
        settingsDropdown.setStyle("-fx-background-color: #2f3d4e;" + "-fx-background-radius: 11");
    }

    @FXML
    private void onSettingsDropdownMouseExit(MouseEvent mouseEvent) {
        settingsDropdown.setStyle("-fx-background-color: #1c242e;" + "-fx-background-radius: 11");
    }

    @FXML
    private void onLogoutClick(ActionEvent actionEvent) throws IOException {
        App.loadLogoutScene();
    }

    @FXML
    private void onLogoutDropdownMouseEnter(MouseEvent mouseEvent) {
        logoutDropdown.setStyle("-fx-background-color: #2f3d4e;" + "-fx-background-radius: 11");
    }

    @FXML
    private void onLogoutDropdownMouseExit(MouseEvent mouseEvent) {
        logoutDropdown.setStyle("-fx-background-color: #1c242e;" + "-fx-background-radius: 11");
    }

    @FXML
    private void onFilterDropdownMouseExit(MouseEvent mouseEvent) {
        filterDropdown.setVisible(false);
    }

    @FXML
    private void cancelButtonDetailsProductMouseClick(MouseEvent mouseEvent) {
        detailsProductPopup.setVisible(false);
        backgroundPopup.setVisible(false);
    }

    @FXML
    private void cancelButtonDetailsProductMouseEnter(MouseEvent mouseEvent) {
        cancelButtonDetailsProduct.setStyle("-fx-background-color: #e0005c;"+"-fx-background-radius: 13;");
    }

    @FXML
    private void cancelButtonDetailsProductMouseExit(MouseEvent mouseEvent) {
        cancelButtonDetailsProduct.setStyle("-fx-background-color: #ff1474;"+"-fx-background-radius: 13;");
    }

    private void downloadImage(String imageUrl, File destination) throws IOException {
        URL url = new URL(imageUrl);
        URLConnection connection = url.openConnection();
        try (InputStream inputStream = connection.getInputStream();
             FileOutputStream outputStream = new FileOutputStream(destination)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    @FXML
    private void downloadBarcodeDetailsProductMouseClick(MouseEvent mouseEvent) {
        String imageUrl = "https://barcodeapi.org/api/code128/"+idProductDetailsProduct.getText(); // change auto -> code128
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Barcode Image");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("PNG Images", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialFileName("SIMS_BARCODE_"+idProductDetailsProduct.getText()+".png");

        File file = fileChooser.showSaveDialog(new Stage());
        if(file != null){
            downloadAlertPopup.setVisible(true);
            backgroundPopupDownload.setVisible(true);
            try{
                downloadImage(imageUrl, file);
                varStatusDownload.setText("Downloading Successfully");
                okButtonStatusDownloadPopup.setVisible(true);
            } catch (IOException err){
                varStatusDownload.setText("Download Failed!");
                okButtonStatusDownloadPopup.setVisible(true);
            }
        }
    }

    @FXML
    private void downloadBarcodeDetailsProductMouseEnter(MouseEvent mouseEvent) {
        downloadBarcodeDetailsProduct.setStyle("-fx-background-color: #ffa132;"+"-fx-background-radius: 13;");
    }

    @FXML
    private void downloadBarcodeDetailsProductMouseExit(MouseEvent mouseEvent) {
        downloadBarcodeDetailsProduct.setStyle("-fx-background-color: #fe8a00;"+"-fx-background-radius: 13;");
    }

    public void openDetailsProductPopup(Product product){
        String apiBarcodePath = "https://barcodeapi.org/api/code128/";
        backgroundPopup.setVisible(true);
        detailsProductPopup.setVisible(true);
        varProductNameDetailsProduct.setText(product.getProductName());
        int originalPrice = Integer.parseInt(product.getProductOriginalPrice().replace(",",""));
        int sellingPrice = Integer.parseInt(product.getProductSellingPrice().replace(",",""));
        NumberFormat formatNumber = NumberFormat.getNumberInstance();
        String formattedOriginalPrice = formatNumber.format(originalPrice);
        String formattedSellingPrice = formatNumber.format(sellingPrice);
        varOriginalPriceDetailsProduct.setText(formattedOriginalPrice);
        varSellingPriceDetailsProduct.setText(formattedSellingPrice);
        varProductStockDetailsProduct.setText(product.getProductStock());
        Image image = new Image(apiBarcodePath+product.getIdProduct());
        barcodeImageDetailsProduct.setImage(image);
        idProductDetailsProduct.setText(product.getIdProduct());
    }

    private List<Product> readProductsFromJson(String searchTerm) {
        productCardContainer.getChildren().clear();
        List<Product> listProducts = new ArrayList<>();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonPath = "./src/main/java/com/systeminventory/assets/json/productList.json";

        try (InputStream inputStream = new FileInputStream(jsonPath)) {
            InputStreamReader reader = new InputStreamReader(inputStream);
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            List<String> productKeys = new ArrayList<>(jsonObject.keySet());
            // Collections.sort(productKeys); // Opsional: sort jika diperlukan

            for (String productName : productKeys) {
                JsonObject productData = jsonObject.getAsJsonObject(productName);
                String searchText = productData.get("Title").getAsString();
                if (searchTerm.isEmpty() || searchText.toLowerCase().contains(searchTerm.toLowerCase())){
                    Product product = new Product();
                    int sellingPrice = productData.get("SellingPrice").getAsInt(); // Mengambil nilai SellingPrice sebagai integer
                    NumberFormat formatNumber = NumberFormat.getNumberInstance(); // Format angka
                    String formattedSellingPrice = formatNumber.format(sellingPrice);
                    product.setKeyProduct(productName); // productname == object keyproduct on json
                    product.setProductName(productData.get("Title").getAsString());
                    product.setImageSource(productData.get("Image").getAsString());
                    product.setProductSellingPrice(formattedSellingPrice); // Set nilai SellingPrice yang telah diformat pada objek product
                    product.setProductOriginalPrice(productData.get("OriginalPrice").getAsString());
                    product.setProductStock(productData.get("Stock").getAsString());
                    product.setIdProduct(productData.get("idProduct").getAsString());
                    listProducts.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listProducts;
    }

    private void handleRealTimeSearch(String searchQuery) throws IOException {
        productCardContainer.getChildren().clear();

        employeeDetailsProductListener = new EmployeeDetailsProductListener() {
            @Override
            public void clickEmployeeDetailsProductListener(Product product) {
                openDetailsProductPopup(product);
            }
        };

        int column = 0;
        int row = 1;

        List<Product> listProducts = new ArrayList<>(readProductsFromJson(searchQuery));

        for (Product product : listProducts) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("employeeProductCard.fxml"));
            VBox cardProduct = fxmlLoader.load();
            employeeProductCardController cardController = fxmlLoader.getController();
            cardController.setData(product, employeeDetailsProductListener);

            if (column == 5) {
                column = 0;
                ++row;
            }

            productCardContainer.add(cardProduct, column++, row);
            GridPane.setMargin(cardProduct, new Insets(15));
        }
    }

    @FXML
    public void initialize() throws IOException {
        int column = 0;
        int row = 1;

        employeeDetailsProductListener = new EmployeeDetailsProductListener() {
            @Override
            public void clickEmployeeDetailsProductListener(Product product) {
                openDetailsProductPopup(product);
            }
        };

        List<Product> listProducts = new ArrayList<>(readProductsFromJson(""));
        for(Product product : listProducts){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("employeeProductCard.fxml"));
            VBox cardProduct = fxmlLoader.load();
            employeeProductCardController cardController = fxmlLoader.getController();
            cardController.setData(product, employeeDetailsProductListener);
            if(column == 5){
                column = 0;
                ++row;
            }

            productCardContainer.add(cardProduct,column++,row);
            GridPane.setMargin(cardProduct, new Insets(15));
        }
        searchProductNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                handleRealTimeSearch(newValue);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    private void okButtonStatusDownloadPopupClick(ActionEvent actionEvent) {
    }

    @FXML
    private void okButtonStatusDownloadPopupMouseEnter(MouseEvent mouseEvent) {
    }

    @FXML
    private void okButtonStatusDownloadPopupMouseExit(MouseEvent mouseEvent) {
    }
}
