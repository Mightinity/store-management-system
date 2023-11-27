package com.systeminventory.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import com.systeminventory.App;
import com.systeminventory.interfaces.DeleteProductListener;
import com.systeminventory.interfaces.DetailsProductListener;
import com.systeminventory.interfaces.EditProductListener;
import com.systeminventory.model.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.text.NumberFormat;


public class productController {

    @FXML
    public Pane filterDropdown;
    @FXML
    public Button filterButton;
    public ImageView imageFIlter;
    @FXML
    private Pane profileDropdown;
    @FXML
    private Button settingsDropdown;
    @FXML
    private Button buttonCashier;
    @FXML
    private Button buttonProduct;
    @FXML
    private Button logoutDropdown;
    @FXML
    private Button buttonDashboard;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button buttonAddProduct;
    @FXML
    public Pane backgroundPopup;
    @FXML
    private Pane addProductPopup;
    @FXML
    private Button addProductApplyButton;
    @FXML
    private Button addProductCancelButton;
    @FXML
    private TextField addProductProductNameField;
    @FXML
    private TextField addProductOriginalPriceField;
    @FXML
    private TextField addProductSellingPriceField;
    @FXML
    private TextField addProductProductStockField;
    @FXML
    private Label addProductProductImagePathLabel;
    @FXML
    private Pane addProductChooseFilePane;
    @FXML
    private Label addProductProductImageLabel;
    @FXML
    private Label addProductSellingPriceLabel;
    @FXML
    private Label addProductOriginalPriceLabel;
    @FXML
    private Label addProductProductNameLabel;
    @FXML
    private Label addProductProductStockLabel;
    @FXML
    private GridPane productCardContainer;
    @FXML
    private Label addProductProductImageGetFullPathLabel;
    @FXML
    private TextField searchProductNameField;
    @FXML
    private Label confirmDeleteVariableProductName;
    @FXML
    private Button confirmDeleteDeleteButton;
    @FXML
    private Button confirmDeleteCancelButton;
    @FXML
    private Label confirmDeleteKeyProduct;
    @FXML
    public Pane confirmDeletePane;
    @FXML
    private Label addProductLabel;
    @FXML
    private Label keyProductOnPopUp;

    @FXML
    private Pane detailsProductPopup;
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
    private DeleteProductListener deleteProductListener;
    private EditProductListener editProductListener;
    private DetailsProductListener detailsProductListener;
    @FXML
    private Button downloadBarcodeDetailsProduct;
    @FXML
    private Button cancelButtonDetailsProduct;
    @FXML
    private Label idProductDetailsProduct;
    @FXML
    private Pane downloadAlertPopup;
    @FXML
    private Label varStatusDownload;
    @FXML
    private Button okButtonStatusDownloadPopup;
    @FXML
    private Label confirmDeleteKeyProduct1;
    @FXML
    private Pane backgroundPopupDownload;

    @FXML
    void onButtonCashierClick(ActionEvent event) throws IOException {
        App.loadCashierScene();
    }

    @FXML
    void onButtonDashboardClick(ActionEvent event) throws IOException {
        App.loadDashboardScene();
    }

    @FXML
    void onButtonProductClick(ActionEvent event) throws IOException {
    }

    @FXML
    void onLogoutClick(ActionEvent event) throws IOException {
        App.loadLogoutScene();
    }

    @FXML
    void onProfileClick(MouseEvent event) {
        profileDropdown.setVisible(!profileDropdown.isVisible());
    }

    @FXML
    void onLogoutDropdownMouseEnter(MouseEvent event) {
        logoutDropdown.setStyle("-fx-background-color: #2f3d4e;" + "-fx-background-radius: 11");
    }

    @FXML
    void onLogoutDropdownMouseExit(MouseEvent event) {
        logoutDropdown.setStyle("-fx-background-color: #1c242e;" + "-fx-background-radius: 11");
    }

    @FXML
    void onSettingsDropdownMouseEnter(MouseEvent event) {
        settingsDropdown.setStyle("-fx-background-color: #2f3d4e;" + "-fx-background-radius: 11");
    }

    @FXML
    void onSettingsDropdownMouseExit(MouseEvent event) {
        settingsDropdown.setStyle("-fx-background-color: #1c242e;" + "-fx-background-radius: 11");
    }

    @FXML
    private void onButtonProductMouseEnter(MouseEvent mouseEvent) {
    }

    @FXML
    private void onButtonProductMouseExit(MouseEvent mouseEvent) {
    }

    @FXML
    private void onCashierProductMouseEnter(MouseEvent mouseEvent) {
        buttonCashier.setStyle("-fx-background-color: #697b7b;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #151d26;" + "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    private void onCashierProductMouseExit(MouseEvent mouseEvent) {
        buttonCashier.setStyle("-fx-background-color: #151d26;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #697b7b;" +  "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    private void onProfileDropdownMouseExit(MouseEvent mouseEvent) {
        profileDropdown.setVisible(false);
    }

    @FXML
    private void onButtonDashboardMouseEnter(MouseEvent mouseEvent) {
        buttonDashboard.setStyle("-fx-background-color: #697b7b;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #151d26;" + "-fx-background-radius: 20;" + "-fx-border-radius: 20;");

    }

    @FXML
    private void onButtonDashboardMouseExit(MouseEvent mouseEvent) {
        buttonDashboard.setStyle("-fx-background-color: #151d26;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #697b7b;" +  "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }


    public void onFilterButtonClick(ActionEvent actionEvent) {
        filterDropdown.setVisible(!filterDropdown.isVisible());
    }

    @FXML
    public void onFilterButtonMouseEnter(MouseEvent mouseEvent) {
        filterButton.setStyle("-fx-background-color: #ffa132;" + "-fx-background-radius: 20;");
    }

    @FXML
    public void onFilterButtonMouseExit(MouseEvent mouseEvent) {
        filterButton.setStyle("-fx-background-color: #fe8a00;" + "-fx-background-radius: 20;");
    }
    @FXML
    public void onImageFilterMouseEnter(MouseEvent mouseEvent) {
        filterButton.setStyle("-fx-background-color: #ffa132;" + "-fx-background-radius: 20;");
    }

    @FXML
    public void onFilterDropdownMouseExit(MouseEvent mouseEvent) {
        filterDropdown.setVisible(false);
    }

    @FXML
    private void onImageFilterMouseClick(MouseEvent mouseEvent) {
        filterDropdown.setVisible(!filterDropdown.isVisible());
    }

    @FXML
    private void onButtonAddProductMouseExit(MouseEvent mouseEvent) {
        buttonAddProduct.setStyle("-fx-background-color: #fe8a00;" + "-fx-background-radius: 20;");
    }

    @FXML
    private void onButtonAddProductMouseEnter(MouseEvent mouseEvent) {
        buttonAddProduct.setStyle("-fx-background-color: #ffa132;" + "-fx-background-radius: 20;");
    }

    private void setLabelPropertiesTextFillWhite(Label label, String text){
        label.setText(text);
        label.setStyle("-fx-text-fill: #f6f6f6;");
    }
    @FXML
    private void onAddProductApplyButtonClick(ActionEvent actionEvent) throws IOException {
        String jsonPath = "./src/main/java/com/systeminventory/assets/json/productList.json";
        String imageProductPath = "./src/main/java/com/systeminventory/assets/imagesProduct/";
        setLabelPropertiesTextFillWhite(addProductProductNameLabel, "Product name:");
        setLabelPropertiesTextFillWhite(addProductOriginalPriceLabel, "Original price:");
        setLabelPropertiesTextFillWhite(addProductSellingPriceLabel, "Selling price:");
        setLabelPropertiesTextFillWhite(addProductProductImageLabel, "Product image:");
        setLabelPropertiesTextFillWhite(addProductProductStockLabel, "Product stock:");
        TextField[] fields = { addProductProductNameField, addProductOriginalPriceField, addProductSellingPriceField, addProductProductStockField };
        Label[] labels = { addProductProductNameLabel, addProductOriginalPriceLabel, addProductSellingPriceLabel, addProductProductStockLabel };
        if (addProductLabel.getText().equals("Add Product")){
            int status = 0;
            for (int i = 0; i < fields.length;i++){
                TextField field = fields[i];
                Label label = labels[i];
                if(field.getText().isEmpty()){
                    label.setText(label.getText()+" (Required)");
                    label.setStyle("-fx-text-fill: #ff1474;");
                }
            }
            if (addProductProductImagePathLabel.getText().isEmpty()){
                addProductProductImageLabel.setText("Product image: (Required)");
                addProductProductImageLabel.setStyle("-fx-text-fill: #ff1474;");
                status++;
            }
            if (status == 0){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Random random = new Random();

                try (InputStream inputStream = new FileInputStream(jsonPath)){
                    InputStreamReader reader = new InputStreamReader(inputStream);
                    JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

                    List<String> productKeys = new ArrayList<>(jsonObject.keySet());
                    //Collections.sort(productKeys);
                    int nextKeyNumber = productKeys.size()+1;
                    String newProductKey = "product"+nextKeyNumber;

                    while (productKeys.contains(newProductKey)){
                        nextKeyNumber++;
                        newProductKey = "product"+nextKeyNumber;
                    }

                    JsonObject newProductData = new JsonObject();
                    int originalPrice = Integer.parseInt(addProductOriginalPriceField.getText());
                    int sellingPrice = Integer.parseInt(addProductSellingPriceField.getText());
                    int stock = Integer.parseInt(addProductProductStockField.getText());

                    String imageFileName = addProductProductImagePathLabel.getText();
                    Path sourceImagePath = Paths.get(addProductProductImageGetFullPathLabel.getText());
                    Path targetImagePath = Paths.get(imageProductPath, imageFileName);

                    newProductData.addProperty("idProduct", generateIdProduct(random));
                    newProductData.addProperty("Title", addProductProductNameField.getText());
                    newProductData.addProperty("OriginalPrice", originalPrice);
                    newProductData.addProperty("SellingPrice", sellingPrice);
                    newProductData.addProperty("Image", imageProductPath+imageFileName);
                    newProductData.addProperty("Stock", stock);

                    try{
                        Files.copy(sourceImagePath, targetImagePath, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException err){
                        err.printStackTrace();
                    }

                    jsonObject.add(newProductKey, newProductData);

                    try (Writer writer = new FileWriter(jsonPath)){
                        gson.toJson(jsonObject, writer);
                    }

                } catch (IOException err){
                    err.printStackTrace();
                }
            }
        } else if (addProductLabel.getText().equals("Edit Product")){
            int status = 0;
            for (int i = 0; i < fields.length;i++){
                TextField field = fields[i];
                Label label = labels[i];
                if(field.getText().isEmpty()){
                    label.setText(label.getText()+" (Required)");
                    label.setStyle("-fx-text-fill: #ff1474;");
                }
            }
            if (addProductProductImagePathLabel.getText().isEmpty()){
                addProductProductImageLabel.setText("Product image: (Required)");
                addProductProductImageLabel.setStyle("-fx-text-fill: #ff1474;");
                status++;
            }
            if (status == 0){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                try (InputStream inputStream = new FileInputStream(jsonPath)){
                    InputStreamReader reader = new InputStreamReader(inputStream);
                    JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

                    JsonObject productKey = jsonObject.getAsJsonObject(keyProductOnPopUp.getText());

                    if (keyProductOnPopUp.getText() != null){
                        int originalPrice = Integer.parseInt(addProductOriginalPriceField.getText());
                        int sellingPrice = Integer.parseInt(addProductSellingPriceField.getText());
                        int stock = Integer.parseInt(addProductProductStockField.getText());

                        String imageFileName = addProductProductImagePathLabel.getText();
                        if (!(imageProductPath+imageFileName).equals(productKey.get("Image").getAsString())){
                            Path newSourceImagePath = Paths.get(addProductProductImageGetFullPathLabel.getText());
                            Path targetImagePath = Paths.get(imageProductPath, imageFileName);

                            try {
                                Files.copy(newSourceImagePath, targetImagePath, StandardCopyOption.REPLACE_EXISTING);
                            } catch (IOException err){
                                err.printStackTrace();
                            }
                        }

                        productKey.addProperty("Title", addProductProductNameField.getText());
                        productKey.addProperty("OriginalPrice", originalPrice);
                        productKey.addProperty("SellingPrice", sellingPrice);
                        productKey.addProperty("Image", imageProductPath+imageFileName);
                        productKey.addProperty("Stock", stock);

                        try (Writer writer = new FileWriter(jsonPath)){
                            gson.toJson(jsonObject, writer);
                        }
                    }
                } catch (IOException err){
                    err.printStackTrace();
                }

            }
        }
        App.loadProductScene();
    }

    private static String generateIdProduct(Random random){
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < 12; i++){
            char randomCharacter = randomCharacter(random);
            randomString.append(randomCharacter);
        }
        return randomString.toString();
    }

    private static char randomCharacter(Random random){
        String characters = "ABDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int index = random.nextInt(characters.length());
        return characters.charAt(index);
    }

    @FXML
    private void onAddProductCancelButtonClick(ActionEvent actionEvent) {
        backgroundPopup.setVisible(false);
        addProductPopup.setVisible(false);
    }

    @FXML
    private void onAddProductApplyButtonMouseEnter(MouseEvent mouseEvent) {
        addProductApplyButton.setStyle("-fx-background-color: #33b8ff;" + "-fx-background-radius: 13");
    }

    @FXML
    private void onAddProductApplyButtonMouseExit(MouseEvent mouseEvent) {
        addProductApplyButton.setStyle("-fx-background-color: #00a6ff;" + "-fx-background-radius: 13");
    }

    @FXML
    private void onAddProductCancelButtonMouseEnter(MouseEvent mouseEvent) {
        addProductCancelButton.setStyle("-fx-background-color: #e0005c;" + "-fx-background-radius: 13");
    }

    @FXML
    private void onAddProductCancelButtonMouseExit(MouseEvent mouseEvent) {
        addProductCancelButton.setStyle("-fx-background-color: #ff1474;" + "-fx-background-radius: 13");
    }


    @FXML
    private void onAddProductChooseFilePaneMouseEnter(MouseEvent mouseEvent) {
        addProductChooseFilePane.setStyle("-fx-background-color: #ffa132;" + "-fx-background-radius: 5;" + "-fx-border-color: #f6f6f6;" + "-fx-border-radius: 5;");
    }

    @FXML
    private void onAddProductChooseFilePaneMouseExit(MouseEvent mouseEvent) {
        addProductChooseFilePane.setStyle("-fx-background-color: #fe8a00;" + "-fx-background-radius: 5;" + "-fx-border-color: #f6f6f6;" + "-fx-border-radius: 5;");
    }

    @FXML
    private void onAddProductChooseFilePaneMouseClick(MouseEvent mouseEvent) {
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Select product image");
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
        File selectedFile = filechooser.showOpenDialog(App.getPrimaryStage());
        if(selectedFile != null){
            setLabelPropertiesTextFillWhite(addProductProductImageLabel, "Product image:");
            addProductProductImagePathLabel.setText(selectedFile.getName());
            addProductProductImageGetFullPathLabel.setText(selectedFile.getPath());
        }
    }

    @FXML
    private void onAddProductOriginalPriceKeyTyped(KeyEvent keyEvent) {
        addProductOriginalPriceField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if(!newValue.matches("\\d*")){
                    addProductOriginalPriceField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @FXML
    private void onAddProductSellingPriceKeyTyped(KeyEvent keyEvent) {
        addProductSellingPriceField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if(!newValue.matches("\\d*")){
                    addProductSellingPriceField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @FXML
    private void onAddProductProductStockKeyTyped(KeyEvent keyEvent) {
        addProductProductStockField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if(!newValue.matches("\\d*")){
                    addProductProductStockField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @FXML
    private void onButtonAddProductClick(ActionEvent actionEvent) throws IOException {
        addProductLabel.setText("Add Product");
        addProductProductNameField.setText("");
        addProductOriginalPriceField.setText("");
        addProductSellingPriceField.setText("");
        addProductProductImagePathLabel.setText("");
        addProductProductStockField.setText("");
        setLabelPropertiesTextFillWhite(addProductProductNameLabel, "Product name:");
        setLabelPropertiesTextFillWhite(addProductOriginalPriceLabel, "Original price:");
        setLabelPropertiesTextFillWhite(addProductSellingPriceLabel, "Selling price:");
        setLabelPropertiesTextFillWhite(addProductProductImageLabel, "Product image:");
        setLabelPropertiesTextFillWhite(addProductProductStockLabel, "Product stock:");
        backgroundPopup.setVisible(true);
        addProductPopup.setVisible(true);
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

    @FXML
    public void initialize() throws IOException {

        productCardContainer.getChildren().clear();

        DeleteProductListener deleteProductListener = this::openConfirmDeleteProductDialog;
        EditProductListener editProductListener = this::openEditProductPopup;
        DetailsProductListener detailsProductListener = this::openDetailsProductPopup;

        int column = 0;
        int row = 1;

        List<Product> listProducts = new ArrayList<>(readProductsFromJson(""));
        for(Product product : listProducts){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("productCard.fxml"));
            VBox cardProduct = fxmlLoader.load();
            productCardController cardController = fxmlLoader.getController();
            cardController.setData(product, deleteProductListener, editProductListener, detailsProductListener);
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

    public void openEditProductPopup(Product product){
        setLabelPropertiesTextFillWhite(addProductProductNameLabel, "Product name:");
        setLabelPropertiesTextFillWhite(addProductOriginalPriceLabel, "Original price:");
        setLabelPropertiesTextFillWhite(addProductSellingPriceLabel, "Selling price:");
        setLabelPropertiesTextFillWhite(addProductProductImageLabel, "Product image:");
        setLabelPropertiesTextFillWhite(addProductProductStockLabel, "Product stock:");
        addProductLabel.setText("Edit Product");
        keyProductOnPopUp.setText(product.getKeyProduct());
        addProductProductNameField.setText(product.getProductName());
        addProductOriginalPriceField.setText(product.getProductOriginalPrice());
        addProductSellingPriceField.setText(product.getProductSellingPrice().replaceAll(",",""));
        addProductProductImagePathLabel.setText(product.getImageSource().substring(57));
        addProductProductImageGetFullPathLabel.setText(product.getImageSource());
        addProductProductStockField.setText(product.getProductStock());
        backgroundPopup.setVisible(true);
        addProductPopup.setVisible(true);
    }

    public void openConfirmDeleteProductDialog(Product product) {
        backgroundPopup.setVisible(true);
        confirmDeletePane.setVisible(true);
        confirmDeleteKeyProduct.setText(product.getKeyProduct());
        confirmDeleteVariableProductName.setText(product.getProductName() + "?");
    }

    public void deleteProductData(String keyProduct){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonPath = "./src/main/java/com/systeminventory/assets/json/productList.json";

        try (InputStream inputStream = new FileInputStream(jsonPath)){
            InputStreamReader reader = new InputStreamReader(inputStream);
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            jsonObject.remove(keyProduct);
            try (Writer writer = new FileWriter(jsonPath)){
                gson.toJson(jsonObject, writer);
            }
            App.loadProductScene();
        } catch (IOException err){
            err.printStackTrace();
        }
    }

    @FXML
    private void onConfirmDeleteDeleteButtonClick(ActionEvent actionEvent) {
        deleteProductData(confirmDeleteKeyProduct.getText());
        confirmDeleteVariableProductName.setText("");
        confirmDeleteKeyProduct.setText("");
        confirmDeletePane.setVisible(false);
        backgroundPopup.setVisible(false);
    }

    @FXML
    private void onConfirmDeleteDeleteButtonMouseEnter(MouseEvent mouseEvent) {
        confirmDeleteDeleteButton.setStyle("-fx-background-color: #19a6b7;"+"-fx-background-radius: 13;");
    }

    @FXML
    private void onConfirmDeleteDeleteButtonMouseExit(MouseEvent mouseEvent) {
        confirmDeleteDeleteButton.setStyle("-fx-background-color: #1ecbe1;"+"-fx-background-radius: 13;");
    }

    @FXML
    private void onConfirmDeleteCancelButtonClick(ActionEvent actionEvent) {
        confirmDeleteVariableProductName.setText("");
        confirmDeleteKeyProduct.setText("");
        confirmDeletePane.setVisible(false);
        backgroundPopup.setVisible(false);
    }

    @FXML
    private void onConfirmDeleteCancelButtonMouseEnter(MouseEvent mouseEvent) {
        confirmDeleteCancelButton.setStyle("-fx-background-color: #e0005c;" + "-fx-background-radius: 13;");
    }

    @FXML
    private void onConfirmDeleteCancelButtonMouseExit(MouseEvent mouseEvent) {
        confirmDeleteCancelButton.setStyle("-fx-background-color: #ff1474;" + "-fx-background-radius: 13;");
    }

    //
    // NEW METHOD SEARCHING (REALTIME SEARCHING)
    //
    private void handleRealTimeSearch(String searchQuery) throws IOException {
        productCardContainer.getChildren().clear();

        deleteProductListener = this::openConfirmDeleteProductDialog;
        editProductListener = this::openEditProductPopup;
        detailsProductListener = this::openDetailsProductPopup;

        int column = 0;
        int row = 1;

        List<Product> listProducts = new ArrayList<>(readProductsFromJson(searchQuery));

        for (Product product : listProducts) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("productCard.fxml"));
            VBox cardProduct = fxmlLoader.load();
            productCardController cardController = fxmlLoader.getController();
            cardController.setData(product, deleteProductListener, editProductListener, detailsProductListener);

            if (column == 5) {
                column = 0;
                ++row;
            }

            productCardContainer.add(cardProduct, column++, row);
            GridPane.setMargin(cardProduct, new Insets(15));
        }
    }

//
//  OLD METHOD SEARCHING (NOT REALTIME SEARCHING)
//
//    private void handleEnterKey(KeyEvent keyEvent) throws IOException {
//        productCardContainer.getChildren().clear();
//
//        deleteProductListener = this::openConfirmDeleteProductDialog;
//        editProductListener = this::openEditProductPopup;
//        detailsProductListener = this::openDetailsProductPopup;
//
//        int column = 0;
//        int row = 1;
//        List<Product> listProducts;
//
//        if (keyEvent.getCode() == KeyCode.ENTER) {
//            listProducts = new ArrayList<>(readProductsFromJson(searchProductNameField.getText()));
//        } else if (keyEvent.getCode() == KeyCode.BACK_SPACE && searchProductNameField.getText().isEmpty()) {
//            listProducts = new ArrayList<>(readProductsFromJson(""));
//        } else {
//            listProducts = new ArrayList<>(readProductsFromJson(searchProductNameField.getText()keyEvent.getCharacter()));
//        }
//
//        for (Product product : listProducts) {
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(App.class.getResource("productCard.fxml"));
//            VBox cardProduct = fxmlLoader.load();
//            productCardController cardController = fxmlLoader.getController();
//            cardController.setData(product, deleteProductListener, editProductListener, detailsProductListener);
//
//            if (column == 5) {
//                column = 0;
//                ++row;
//            }
//
//            productCardContainer.add(cardProduct, column++, row);
//            GridPane.setMargin(cardProduct, new Insets(15));
//        }
//    }

    @FXML
    private void searchTermKeyPress(KeyEvent keyEvent) throws IOException {
        String searchText = searchProductNameField.getText();
        handleRealTimeSearch(searchText);
    }

    @FXML
    private void downloadBarcodeDetailsProductMouseEnter(MouseEvent mouseEvent) {
        downloadBarcodeDetailsProduct.setStyle("-fx-background-color: #ffa132;"+"-fx-background-radius: 13;");
    }

    @FXML
    private void downloadBarcodeDetailsProductMouseExit(MouseEvent mouseEvent) {
        downloadBarcodeDetailsProduct.setStyle("-fx-background-color: #fe8a00;"+"-fx-background-radius: 13;");
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
    private void downloadBarcodeDetailsProductMouseClick(MouseEvent mouseEvent) throws InterruptedException {
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

    @FXML
    private void okButtonStatusDownloadPopupClick(ActionEvent actionEvent) {
        downloadAlertPopup.setVisible(false);
        backgroundPopupDownload.setVisible(false);
    }

    @FXML
    private void okButtonStatusDownloadPopupMouseEnter(MouseEvent mouseEvent) {
        okButtonStatusDownloadPopup.setStyle("-fx-background-color: #009cef;"+"-fx-background-radius: 13;");
    }

    @FXML
    private void okButtonStatusDownloadPopupMouseExit(MouseEvent mouseEvent) {
        okButtonStatusDownloadPopup.setStyle("-fx-background-color: #00a6ff;"+"-fx-background-radius: 13;");
    }
}
