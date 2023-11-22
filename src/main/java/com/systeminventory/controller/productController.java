package com.systeminventory.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import com.systeminventory.App;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.*;
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
    private Pane backgroundPopup;
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

    private static String findLastProductKey(List<Product> listProducts){
        if(!listProducts.isEmpty()){
            Product lastProduct = listProducts.get(listProducts.size() - 1);
            return "product" + (listProducts.size());
        }
        return "product0";
    }

    private void setLabelPropertiesTextFillWhite(Label label, String text){
        label.setText(text);
        label.setStyle("-fx-text-fill: #f6f6f6;");
    }
    @FXML
    private void onAddProductApplyButtonClick(ActionEvent actionEvent) throws IOException {
        setLabelPropertiesTextFillWhite(addProductProductNameLabel, "Product name:");
        setLabelPropertiesTextFillWhite(addProductOriginalPriceLabel, "Original price:");
        setLabelPropertiesTextFillWhite(addProductSellingPriceLabel, "Selling price:");
        setLabelPropertiesTextFillWhite(addProductProductImageLabel, "Product image:");
        setLabelPropertiesTextFillWhite(addProductProductStockLabel, "Product stock:");
        int status = 0;
        if (addProductProductNameField.getText().isEmpty()){
            addProductProductNameLabel.setText("Product name: (Required)");
            addProductProductNameLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (addProductOriginalPriceField.getText().isEmpty()){
            addProductOriginalPriceLabel.setText("Original price: (Required)");
            addProductOriginalPriceLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (addProductSellingPriceField.getText().isEmpty()){
            addProductSellingPriceLabel.setText("Selling price: (Required)");
            addProductSellingPriceLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (addProductProductImagePathLabel.getText().isEmpty()){
            addProductProductImageLabel.setText("Product image: (Required)");
            addProductProductImageLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (addProductProductStockField.getText().isEmpty()){
            addProductProductStockLabel.setText("Product stock: (Required)");
            addProductProductStockLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (status == 0){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Random random = new Random();

            String jsonPath = "./src/main/java/com/systeminventory/assets/json/productList.json";
            String imageProductPath = "./src/main/java/com/systeminventory/assets/imagesProduct/";

            try (InputStream inputStream = new FileInputStream(jsonPath)){
                InputStreamReader reader = new InputStreamReader(inputStream);
                JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

                List<String> productKeys = new ArrayList<>(jsonObject.keySet());
//                Collections.sort(productKeys);
                int nextKeyNumber = productKeys.size()+1;
                String newProductKey = "product"+nextKeyNumber;

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
            App.loadProductScene();
        }
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

    private List<Product> readProductsFromJson() {
        productCardContainer.getChildren().clear();
        List<Product> listProducts = new ArrayList<>();

        Gson gson = new Gson();

        String jsonPath = "./src/main/java/com/systeminventory/assets/json/productList.json";

        try (InputStream inputStream = new FileInputStream(jsonPath)) {
            InputStreamReader reader = new InputStreamReader(inputStream);
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            List<String> productKeys = new ArrayList<>(jsonObject.keySet());
            // Collections.sort(productKeys); // Opsional: sort jika diperlukan

            for (String productName : productKeys) {
                JsonObject productData = jsonObject.getAsJsonObject(productName);

                Product product = new Product();
                product.setProductName(productData.get("Title").getAsString());
                product.setImageSource(productData.get("Image").getAsString());

                // Mengambil nilai SellingPrice sebagai integer
                int sellingPrice = productData.get("SellingPrice").getAsInt();

                // Format angka tanpa simbol mata uang
                NumberFormat formatNumber = NumberFormat.getNumberInstance();
                String formattedSellingPrice = formatNumber.format(sellingPrice);

                // Set nilai SellingPrice yang telah diformat pada objek product
                product.setProductPrice(formattedSellingPrice);

                product.setProductStock(productData.get("Stock").getAsString());

                listProducts.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listProducts;
    }


    @FXML
    public void initialize() throws IOException {

        productCardContainer.getChildren().clear();

        int column = 0;
        int row = 1;

        List<Product> listProducts = new ArrayList<>(readProductsFromJson());
        for(Product product : listProducts){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("productCard.fxml"));
            VBox cardProduct = fxmlLoader.load();
            productCardController cardController = fxmlLoader.getController();
            cardController.setData(product);

            if(column == 5){
                column = 0;
                ++row;
            }

            productCardContainer.add(cardProduct,column++,row);
            GridPane.setMargin(cardProduct, new Insets(15));

        }
    }

}
