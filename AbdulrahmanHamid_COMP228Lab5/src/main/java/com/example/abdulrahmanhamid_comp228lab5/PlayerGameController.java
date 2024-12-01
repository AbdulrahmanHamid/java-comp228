package com.example.abdulrahmanhamid_comp228lab5;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.format.DateTimeFormatter;


public class PlayerGameController {

    @FXML
    private Label playerInformationLabel;
    @FXML
    private Label firstNameLabel;

    @FXML
    private TextField firstNameField;

    @FXML
    private Label lastNameLabel;

    @FXML
    private TextField lastNameField;

    @FXML
    private Label addressLabel;

    @FXML
    private TextField addressField;

    @FXML
    private Label provinceLabel;

    @FXML
    private TextField provinceField;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private TextField postalCodeField;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private TextField phoneNumberField;


    @FXML
    private Label updateByIdLabel;

    @FXML
    private TextField updateByIdField;

    @FXML
    private Label gameInformationLabel;

    @FXML
    private Label gameNameLabel;

    @FXML
    private TextField gameNameField;

    @FXML
    private Label gameScoreLabel;

    @FXML
    private TextField gameScoreField;

    @FXML
    private Label gameDatePlayedLabel;

    @FXML
    private DatePicker gameDatePlayedField;

    @FXML
    private Button playerInformationButton;

    @FXML
    private Button updateByIdButton;

    @FXML
    private Button createNewPlayerButton;

    @FXML
    private Button submitButton;

    @FXML
    private Button CButton;



    // A method called when the display button is clicked
    @FXML
    private void onCreateNewGamePlayerButton() {
        DatabaseManager dbm = new DatabaseManager();


        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String address = addressField.getText();
        String province = provinceField.getText();
        String postal = postalCodeField.getText();
        String phoneNumber = phoneNumberField.getText();
        String gameName = gameNameField.getText();
        int gameScore = Integer.parseInt(gameScoreField.getText());
        String date = gameDatePlayedField.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Validate input
        if (firstName.isBlank() ||lastName.isBlank() || address.isBlank() || province.isBlank()  || postal.isBlank() || phoneNumber.isBlank() ||gameName.isBlank() ||  date.isEmpty() ) {
            showAlert("Input Error", "Please fill in all fields to create a player");
            return;
        }

        try {
            // to check the phone number to be only numbers
            long phoneNumberInt = Long.parseLong(phoneNumber);

            // adding all the information to the database
            dbm.addGamePlayer(firstName,lastName,address,postal,province,phoneNumber,gameName,date,gameScore);
            // clear all fields after adding them to the database
            firstNameField.clear();
            addressField.clear();
            provinceField.clear();
            lastNameField.clear();
            postalCodeField.clear();
            phoneNumberField.clear();
            gameNameField.clear();
            gameScoreField.clear();
            gameDatePlayedField.setValue(null);

        } catch (NumberFormatException e) {
            showAlert("Input Error", "phone number and score must be a valid number.");
        }catch (Exception e){
            showAlert("Input Error", e.getMessage());
        }

    }

    // to check for player id if you want to update
    @FXML
    private void onCheckPlayerInformationButton() {
        DatabaseManager dbm = new DatabaseManager();
        dbm.readPlayer();
    }
    // a method to update the player information
    @FXML
    private void onUpdateByIdButton() {
        DatabaseManager dbm = new DatabaseManager();

            int playerId = Integer.parseInt(updateByIdField.getText());
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String address = addressField.getText();
            String postalCode = postalCodeField.getText();
            String province = provinceField.getText();
            String phoneNumber = phoneNumberField.getText();

        try {
            // update player information only
            dbm.updatePlayer(playerId, firstName, lastName, address, postalCode, province, phoneNumber);

            // clear input fields
            updateByIdField.clear();
            firstNameField.clear();
            lastNameField.clear();
            addressField.clear();
            postalCodeField.clear();
            provinceField.clear();
            phoneNumberField.clear();
            gameNameField.clear();
            gameScoreField.clear();
            gameDatePlayedField.setValue(null);
        } catch (Exception e) {
            showAlert("Error", "An error occurred: " + e.getMessage());
        }
    }

    // a method to display all the data in the database when clicked
    @FXML
    private void onDisplayAllButton() {
        DatabaseManager dbm = new DatabaseManager();
        dbm.readData();
    }
    // Utility method to show alert dialog
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // there is nothing to initialize
    @FXML
    private void initialize() {

    }



}