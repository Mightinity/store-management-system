package com.systeminventory.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.systeminventory.App;
import com.systeminventory.interfaces.DeleteCashierListener;
import com.systeminventory.interfaces.ProfileDetailsListener;
import com.systeminventory.model.Cashier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class cashierController {
    @FXML
    private Pane backgroundPopup;
    @FXML
    private Button buttonCashier;
    @FXML
    private Button buttonDashboard;
    @FXML
    private Button buttonProduct;
    @FXML
    private Button logoutDropdown;
    @FXML
    private Pane profileDropdown;
    @FXML
    private Button settingsDropdown;
    @FXML
    private Pane addProfilePopup;
    @FXML
    private Label addProfileNameLabel;
    @FXML
    private TextField addProfileNameField;
    @FXML
    private Label addProfileEmailLabel;
    @FXML
    private TextField addProfileEmailField;
    @FXML
    private Label addProfileNoPhoneLabel;
    @FXML
    private TextField addProfileNoPhoneField;
    @FXML
    private Label addProfileDateOfBirthLabel;
    @FXML
    private TextField addProfileDateOfBirthField;
    @FXML
    private Label addProfileAddressLabel;
    @FXML
    private TextField addProfileAddressField;
    @FXML
    private Label addProfileProfilePictureLabel;
    @FXML
    private Label addProfileProfileImagePathLabel;
    @FXML
    private Button addProfileApplyButton;
    @FXML
    private Button addProfileCancelButton;
    @FXML
    private Label addProfileProfileImageFullPathLabel;
    @FXML
    private Button buttonAddProfile;
    @FXML
    private Pane addProfileChooseFilePane;
    @FXML
    private GridPane profileCardContainer;
    @FXML
    private Label profileDetailsVarFullName;
    @FXML
    private Label profileDetailsVarPhone;
    @FXML
    private Label profileDetailsVarDateOfBirth;
    @FXML
    private Label profileDetailsVarEmail;
    @FXML
    private Label profileDetailsVarAddress;
    @FXML
    public Pane paneSelectAProfile;

    private ProfileDetailsListener profileDetailsListener;
    private DeleteCashierListener deleteCashierListener;

    @FXML
    private ImageView profileDetailsVarImage;
    @FXML
    private TextField searchTermProfile;
    @FXML
    private Pane confirmDeleteProfilePane;
    @FXML
    private Label confirmDeleteVariableProfileName;
    @FXML
    private Button confirmDeleteDeleteButtonProfile;
    @FXML
    private Button confirmDeleteCancelButtonProfile;
    @FXML
    private Label confirmDeleteKeyProfile;

    private static String hashMD5(String input) {
        StringBuilder result = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] byteData = md.digest();

            for (byte aByteData : byteData) {
                result.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @FXML
    void onAddProfileChooseFilePaneMouseClick(MouseEvent event) {
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Select profile picture");
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
        File selectedFile = filechooser.showOpenDialog(App.getPrimaryStage());
        if(selectedFile != null){
            setLabelPropertiesTextFillWhite(addProfileProfilePictureLabel, "Profile picture:");
            addProfileProfileImagePathLabel.setText(selectedFile.getName());
            addProfileProfileImageFullPathLabel.setText(selectedFile.getPath());
        }
    }

    @FXML
    void onAddProfileChooseFilePaneMouseEnter(MouseEvent event) {
        addProfileChooseFilePane.setStyle("-fx-background-color: #ffa132;" + "-fx-background-radius: 5;" + "-fx-border-color: #f6f6f6;" + "-fx-border-radius: 5;");
    }

    @FXML
    void onAddProfileChooseFilePaneMouseExit(MouseEvent event) {
        addProfileChooseFilePane.setStyle("-fx-background-color: #fe8a00;" + "-fx-background-radius: 5;" + "-fx-border-color: #f6f6f6;" + "-fx-border-radius: 5;");
    }

    @FXML
    private void onButtonAddProfileMouseExit(MouseEvent mouseEvent) {
        buttonAddProfile.setStyle("-fx-background-color: #fe8a00;" + "-fx-background-radius: 20;");
    }

    @FXML
    private void onButtonAddProfileMouseEnter(MouseEvent mouseEvent) {
        buttonAddProfile.setStyle("-fx-background-color: #ffa132;" + "-fx-background-radius: 20;");
    }


    @FXML
    void onButtonDashboardClick(ActionEvent event) throws IOException {
        App.loadDashboardScene();

    }

    @FXML
    private void onButtonDashboardMouseEnter(MouseEvent mouseEvent) {
        buttonDashboard.setStyle("-fx-background-color: #697b7b;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #151d26;" + "-fx-background-radius: 20;" + "-fx-border-radius: 20;");

    }

    @FXML
    private void onButtonDashboardMouseExit(MouseEvent mouseEvent) {
        buttonDashboard.setStyle("-fx-background-color: #151d26;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #697b7b;" +  "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    void onButtonProductClick(ActionEvent event) throws IOException {
        App.loadProductScene();
    }

    @FXML
    void onButtonProductMouseEnter(MouseEvent event) {
        buttonProduct.setStyle("-fx-background-color: #697b7b;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #151d26;" + "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    void onButtonProductMouseExit(MouseEvent event) {
        buttonProduct.setStyle("-fx-background-color: #151d26;" + "-fx-border-color: #697b7b;" + "-fx-text-fill: #697b7b;" +  "-fx-background-radius: 20;" + "-fx-border-radius: 20;");
    }

    @FXML
    void onButtonCashierClick(ActionEvent event) {
    }
    @FXML
    void onCashierProductMouseEnter(MouseEvent event) {
    }
    @FXML
    void onCashierProductMouseExit(MouseEvent event) {
    }

    @FXML
    void onLogoutClick(ActionEvent event) throws IOException {
        App.loadLogoutScene();
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
    void onProfileClick(MouseEvent event) {
        profileDropdown.setVisible(!profileDropdown.isVisible());
    }

    @FXML
    void onProfileDropdownMouseExit(MouseEvent event) {
        profileDropdown.setVisible(false);
    }

    @FXML
    void onSettingsDropdownMouseEnter(MouseEvent event) {
        settingsDropdown.setStyle("-fx-background-color: #2f3d4e;" + "-fx-background-radius: 11");
    }

    @FXML
    void onSettingsDropdownMouseExit(MouseEvent event) {
        settingsDropdown.setStyle("-fx-background-color: #1c242e;" + "-fx-background-radius: 11");
    }

    private void setLabelPropertiesTextFillWhite(Label label, String text){
        label.setText(text);
        label.setStyle("-fx-text-fill: #f6f6f6;");
    }

    @FXML
    void onButtonAddProfileClick(ActionEvent event) {
        addProfileNameField.setText("");
        addProfileEmailField.setText("");
        addProfileNoPhoneField.setText("");
        addProfileDateOfBirthField.setText("");
        addProfileAddressField.setText("");
        addProfileProfileImagePathLabel.setText("");
        setLabelPropertiesTextFillWhite(addProfileNameLabel, "Name:");
        setLabelPropertiesTextFillWhite(addProfileEmailLabel, "Email:");
        setLabelPropertiesTextFillWhite(addProfileNoPhoneLabel, "No phone:");
        setLabelPropertiesTextFillWhite(addProfileDateOfBirthLabel, "Date of birth:");
        setLabelPropertiesTextFillWhite(addProfileAddressLabel, "Address:");
        setLabelPropertiesTextFillWhite(addProfileProfilePictureLabel, "Profile picture:");
        backgroundPopup.setVisible(true);
        addProfilePopup.setVisible(true);
    }

    @FXML
    private void onAddProfileApplyButtonClick(ActionEvent actionEvent) throws IOException {
        setLabelPropertiesTextFillWhite(addProfileNameLabel, "Name:");
        setLabelPropertiesTextFillWhite(addProfileEmailLabel, "Email:");
        setLabelPropertiesTextFillWhite(addProfileNoPhoneLabel, "No phone:");
        setLabelPropertiesTextFillWhite(addProfileDateOfBirthLabel, "Date of birth:");
        setLabelPropertiesTextFillWhite(addProfileAddressLabel, "Address:");
        setLabelPropertiesTextFillWhite(addProfileProfilePictureLabel, "Profile picture:");
        int status = 0;
        if (addProfileNameField.getText().isEmpty()){
            addProfileNameLabel.setText("Name: (Required)");
            addProfileNameLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (addProfileEmailField.getText().isEmpty()){
            addProfileEmailLabel.setText("Email: (Required)");
            addProfileEmailLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (addProfileNoPhoneField.getText().isEmpty()){
            addProfileNoPhoneLabel.setText("No phone: (Required)");
            addProfileNoPhoneLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (addProfileDateOfBirthField.getText().isEmpty()){
            addProfileDateOfBirthLabel.setText("Date of birth: (Required)");
            addProfileDateOfBirthLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (addProfileAddressField.getText().isEmpty()){
            addProfileAddressLabel.setText("Address: (Required)");
            addProfileAddressLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (addProfileProfileImagePathLabel.getText().isEmpty()){
            addProfileProfilePictureLabel.setText("Profile picture: (Required)");
            addProfileProfilePictureLabel.setStyle("-fx-text-fill: #ff1474;");
            status++;
        }
        if (status == 0){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String jsonPath = "./src/main/java/com/systeminventory/assets/json/cashierList.json";
            String imageProfilePath = "./src/main/java/com/systeminventory/assets/imagesCashier/";

            try (InputStream inputStream = new FileInputStream(jsonPath)){
                InputStreamReader reader = new InputStreamReader(inputStream);
                JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

                List<String> profileKeys = new ArrayList<>(jsonObject.keySet());
//                Collections.sort(profileKeys);
                int nextKeyNumber = profileKeys.size()+1;
                String newProfileKey = "cashier"+nextKeyNumber;

                while (profileKeys.contains(newProfileKey)){
                    nextKeyNumber++;
                    newProfileKey = "product"+nextKeyNumber;
                }

                JsonObject newProfileData = new JsonObject();

                String imageFileName = addProfileProfileImagePathLabel.getText();
                Path sourceImagePath = Paths.get(addProfileProfileImageFullPathLabel.getText());
                Path targetImagePath = Paths.get(imageProfilePath, imageFileName);

                newProfileData.addProperty("Name", addProfileNameField.getText());
                newProfileData.addProperty("Email", addProfileEmailField.getText());
                newProfileData.addProperty("Phone", addProfileNoPhoneField.getText());
                newProfileData.addProperty("DateOfBirth", addProfileDateOfBirthField.getText());
                newProfileData.addProperty("Address", addProfileAddressField.getText());
                newProfileData.addProperty("Image", imageProfilePath+imageFileName);
                newProfileData.addProperty("Password", hashMD5("123456"));

                try{
                    Files.copy(sourceImagePath, targetImagePath, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException err){
                    err.printStackTrace();
                }

                jsonObject.add(newProfileKey, newProfileData);

                try (Writer writer = new FileWriter(jsonPath)){
                    gson.toJson(jsonObject, writer);
                }

            } catch (IOException err){
                err.printStackTrace();
            }
            App.loadCashierScene();
        }
    }

    @FXML
    private void onAddProfileApplyButtonMouseEnter(MouseEvent mouseEvent) {
        addProfileApplyButton.setStyle("-fx-background-color: #33b8ff;" + "-fx-background-radius: 13");
    }

    @FXML
    private void onAddProfileApplyButtonMouseExit(MouseEvent mouseEvent) {
        addProfileApplyButton.setStyle("-fx-background-color: #00a6ff;" + "-fx-background-radius: 13");
    }

    @FXML
    private void onAddProfileCancelButtonClick(ActionEvent actionEvent) {
        backgroundPopup.setVisible(false);
        addProfilePopup.setVisible(false);
    }

    @FXML
    private void onAddProfileCancelButtonMouseEnter(MouseEvent mouseEvent) {
        addProfileCancelButton.setStyle("-fx-background-color: #e0005c;" + "-fx-background-radius: 13");
    }

    @FXML
    private void onAddProfileCancelButtonMouseExit(MouseEvent mouseEvent) {
        addProfileCancelButton.setStyle("-fx-background-color: #ff1474;" + "-fx-background-radius: 13");
    }

    public void deleteProfileData(String keyProfile){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonPath = "./src/main/java/com/systeminventory/assets/json/cashierList.json";

        try (InputStream inputStream = new FileInputStream(jsonPath)){
            InputStreamReader reader = new InputStreamReader(inputStream);
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            jsonObject.remove(keyProfile);
            try (Writer writer = new FileWriter(jsonPath)){
                gson.toJson(jsonObject, writer);
            }
            App.loadCashierScene();
        } catch (IOException err){
            err.printStackTrace();
        }
    }

    @FXML
    private void onConfirmDeleteDeleteButtonProfileClick(ActionEvent event) {
        deleteProfileData(confirmDeleteKeyProfile.getText());
        confirmDeleteVariableProfileName.setText("");
        confirmDeleteKeyProfile.setText("");
        confirmDeleteProfilePane.setVisible(false);
        backgroundPopup.setVisible(false);
    }
    @FXML
    private void onConfirmDeleteDeleteButtonProfileMouseEnter(MouseEvent event) {
        confirmDeleteDeleteButtonProfile.setStyle("-fx-background-color: #e0005c;"+"-fx-background-radius: 13;");
    }
    @FXML
    private void onConfirmDeleteDeleteButtonProfileMouseExit(MouseEvent event) {
        confirmDeleteDeleteButtonProfile.setStyle("-fx-background-color: #ff1474;"+"-fx-background-radius: 13;");
    }
    @FXML
    private void onConfirmDeleteCancelButtonProfileMouseEnter(MouseEvent event) {
        confirmDeleteCancelButtonProfile.setStyle("-fx-background-color: #19a6b7;" + "-fx-background-radius: 13;");
    }
    @FXML
    private void onConfirmDeleteCancelButtonProfileMouseExit(MouseEvent mouseEvent) {
        confirmDeleteCancelButtonProfile.setStyle("-fx-background-color: #1ecbe1;" + "-fx-background-radius: 13;");
    }
    @FXML
    private void onConfirmDeleteCancelButtonProfileClick(ActionEvent event) {
        backgroundPopup.setVisible(false);
        confirmDeleteProfilePane.setVisible(false);
        confirmDeleteKeyProfile.setText("");
        confirmDeleteVariableProfileName.setText("");
    }

//    public void setDataCashierProfileDetails(String keyProfile){
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//        String jsonPath = "./src/main/java/com/systeminventory/assets/json/cashierList.json";
//
//        try (InputStream inputStream = new FileInputStream(jsonPath)){
//            InputStreamReader reader = new InputStreamReader(inputStream);
//            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
//            JsonObject cashierData = jsonObject.getAsJsonObject(keyProfile);
//            System.out.println(cashierData);
//            profileDetailsVarFullName.setText(cashierData.get("Name").getAsString());
//            profileDetailsVarPhone.setText(cashierData.get("Phone").getAsString());
//            profileDetailsVarDateOfBirth.setText(cashierData.get("DateOfBirth").getAsString());
//            profileDetailsVarEmail.setText(cashierData.get("Email").getAsString());
//            profileDetailsVarAddress.setText(cashierData.get("Address").getAsString());
//        } catch (IOException err){
//            err.printStackTrace();
//        }
//    }

    private List<Cashier> readProfileFromJson(String searchTerm) {
        profileCardContainer.getChildren().clear();
        List<Cashier> listCashier = new ArrayList<>();

        Gson gson = new Gson();

        String jsonPath = "./src/main/java/com/systeminventory/assets/json/cashierList.json";

        try (InputStream inputStream = new FileInputStream(jsonPath)) {
            InputStreamReader reader = new InputStreamReader(inputStream);
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            List<String> profileKeys = new ArrayList<>(jsonObject.keySet());
            // Collections.sort(productKeys); // Opsional: sort jika diperlukan

            for (String profileName : profileKeys) {
                JsonObject cashierData = jsonObject.getAsJsonObject(profileName);
                String searchText = cashierData.get("Name").getAsString();

                if(searchTerm.isEmpty() || searchText.toLowerCase().contains(searchTerm.toLowerCase())){
                    Cashier cashier = new Cashier();
                    cashier.setCashierName(cashierData.get("Name").getAsString());
                    cashier.setCashierNoPhone(cashierData.get("Phone").getAsString());
                    cashier.setCashierImageSource(cashierData.get("Image").getAsString());
                    cashier.setCashierEmail(cashierData.get("Email").getAsString());
                    cashier.setCashierAddress(cashierData.get("Address").getAsString());
                    cashier.setCashierDateOfBirth(cashierData.get("DateOfBirth").getAsString());
                    cashier.setKeyCashier(profileName);

                    listCashier.add(cashier);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listCashier;
    }

    private void openConfirmDeleteProfileDialog(Cashier cashier){
        backgroundPopup.setVisible(true);
        confirmDeleteProfilePane.setVisible(true);
        confirmDeleteKeyProfile.setText(cashier.getKeyCashier());
        confirmDeleteVariableProfileName.setText(cashier.getCashierName()+"?");

    }

    private void setChosenProfile(Cashier cashier){
        paneSelectAProfile.setVisible(false);
        profileDetailsVarFullName.setText(cashier.getCashierName());
        profileDetailsVarEmail.setText(cashier.getCashierEmail());
        profileDetailsVarPhone.setText(cashier.getCashierNoPhone());
        profileDetailsVarDateOfBirth.setText(cashier.getCashierDateOfBirth());
        profileDetailsVarAddress.setText(cashier.getCashierAddress());
        String imagePath = cashier.getCashierImageSource();
        File file = new File(imagePath);
        if(file.exists()){
            Image image = new Image(file.toURI().toString());
            profileDetailsVarImage.setImage(image);
        }
    }

    @FXML
    public void initialize() throws IOException {

        List<Cashier> listCashier = new ArrayList<>(readProfileFromJson(""));
        profileCardContainer.getChildren().clear();

//        if (!listCashier.isEmpty()){
//            setChosenProfile(listCashier.get(0));
        profileDetailsListener = new ProfileDetailsListener() {
            @Override
            public void clickProfileDetailsListener(Cashier cashier) {
                setChosenProfile(cashier);
            }
        };

        deleteCashierListener = new DeleteCashierListener() {
            @Override
            public void clickDeleteCashierListener(Cashier cashier) {
                openConfirmDeleteProfileDialog(cashier);
            }
        };

        int column = 0;
        int row = 1;

        for(Cashier cashier : listCashier){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("cashierProfileCard.fxml"));
            VBox cardProfile = fxmlLoader.load();
            cashierProfileCardController cardController = fxmlLoader.getController();
            cardController.setData(cashier, profileDetailsListener, deleteCashierListener);

            profileCardContainer.add(cardProfile,column,row++);
            GridPane.setMargin(cardProfile, new Insets(15));

        }

    }

    private void handleEnterKeyProfileSearch(KeyEvent keyEvent) throws IOException{
        if(keyEvent.getCode() == KeyCode.ENTER){
            List<Cashier> listCashier = new ArrayList<>(readProfileFromJson(searchTermProfile.getText()));
            profileCardContainer.getChildren().clear();

            profileDetailsListener = new ProfileDetailsListener() {
                @Override
                public void clickProfileDetailsListener(Cashier cashier) {
                    setChosenProfile(cashier);
                }
            };

            deleteCashierListener = new DeleteCashierListener() {
                @Override
                public void clickDeleteCashierListener(Cashier cashier) {
                    openConfirmDeleteProfileDialog(cashier);
                }
            };
            int column = 0;
            int row = 1;
            for(Cashier cashier : listCashier){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(App.class.getResource("cashierProfileCard.fxml"));
                VBox cardProfile = fxmlLoader.load();
                cashierProfileCardController cardController = fxmlLoader.getController();
                cardController.setData(cashier, profileDetailsListener, deleteCashierListener);

                profileCardContainer.add(cardProfile,column,row++);
                GridPane.setMargin(cardProfile, new Insets(15));

            }
        }
    }

    @FXML
    private void searchTermProfileKeyPress(KeyEvent keyEvent) throws IOException{
        handleEnterKeyProfileSearch(keyEvent);
    }
}
