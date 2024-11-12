package com.example.abdulrahmanhamid_comp228lab4;

import javafx.collections.FXCollections;

import javafx.fxml.FXML;
import javafx.scene.control.*;


public class HelloController {

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameField;

    @FXML
    private Label addressLabel;

    @FXML
    private TextField addressField;

    @FXML
    private Label provinceLabel;

    @FXML
    private TextField provinceField;

    @FXML
    private Label cityLabel;

    @FXML
    private TextField cityField;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private TextField postalCodeField;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Label emailLabel;

    @FXML
    private TextField emailField;

    @FXML
    private Label extraActivityLabel;

    @FXML
    private CheckBox studentCouncilCheckBox;
    @FXML
    private CheckBox volunteerWorkCheckBox;

    @FXML
    private Label selectProgram;
    @FXML
    private RadioButton button1;
    @FXML
    private RadioButton button2;
    @FXML
    private final ToggleGroup group = new ToggleGroup();

    @FXML
    private ComboBox<String>  coursesComboBox = new ComboBox<>();

    @FXML
    private ListView<String> listView = new ListView<String>();

    @FXML
    private Button submitButton;

    @FXML
    private TextArea messageArea;

    // A method called when the display button is clicked
    @FXML
    private void onSubmitButtonClick() {
        String name = nameField.getText();
        String address = addressField.getText();
        String province = provinceField.getText();
        String city = cityField.getText();
        String postal = postalCodeField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();
        boolean studentCouncil = studentCouncilCheckBox.isSelected();
        boolean volunteerWork = volunteerWorkCheckBox.isSelected();
        String extraActivity;
        // open text area to scroll
        messageArea.setDisable(false);
        // Validate input
        if (name.isBlank() || address.isBlank() || province.isBlank() || city.isBlank() || postal.isBlank() || phoneNumber.isBlank() || email.isBlank()) {
            showAlert("Input Error", "Please fill in all fields.");
            return;
        }


        //check if checkboxes are checked
        if(volunteerWork && studentCouncil) {
            extraActivity = "Extra Activity: \n1.Student Council \n2.volunteer Work";
        }else if(studentCouncil) {
            extraActivity = "Extra Activity: \n1.Student Council";
        }else if(volunteerWork) {
            extraActivity = "Extra Activity: \n1.Volunteer Work";
        }else {
            extraActivity = "Extra Activity: \nStudent doesn't have extra ectivity";
        }

        try {
            // to check the phone number to be only numbers
            long phoneNumberInt = Long.parseLong(phoneNumber);

            //display the courses in the textarea
            String courses = "";
            for(String c : listView.getItems()){
                courses += c + "\n";
            }

            // Display  message with the collected information
            messageArea.setText(String.format("%s, %s, %s, %s,%s \nPhone Number: %s\nEmail: %s\nCourses:\n%s\n%s",
                    name, address, province, city, postal, phoneNumber, email, courses, extraActivity));

            // Clear input fields
            nameField.clear();
            addressField.clear();
            provinceField.clear();
            cityField.clear();
            postalCodeField.clear();
            phoneNumberField.clear();
            emailField.clear();
            button1.setSelected(false);
            button2.setSelected(false);
            coursesComboBox.setValue(null);
            listView.getItems().clear();
            studentCouncilCheckBox.setSelected(false);
            volunteerWorkCheckBox.setSelected(false);
        } catch (NumberFormatException e) {
            showAlert("Input Error", "phone number must be a valid number.");
        }
    }

    // Utility method to show alert dialog
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void initialize() {
        //adding the radio button to one group
        button1.setToggleGroup(group);
        button2.setToggleGroup(group);

        // locked when start the application
        coursesComboBox.setDisable(true);
        messageArea.setDisable(true);
    }

    //a method called when switching between programmes
    @FXML
    private void toggle(){
        // when toggled open the combobox
        coursesComboBox.setDisable(false);
        //check which radio button is selected
        if (button1.isSelected()) {
            coursesComboBox.setItems(FXCollections.observableArrayList("Java", "C#", "Python", "HTML"));
        } else if ( button2.isSelected()) {
            coursesComboBox.setItems(FXCollections.observableArrayList("Finance", "English", "Accounting", "Marketing"));
        }
    }

    //method is called when selecting a course and handle it
    @FXML
    private void CourseSelection() {

        String selectedCourse = coursesComboBox.getSelectionModel().getSelectedItem();
        //check if there is selection and if the item is not in the list if it is in the list throw error
        if (selectedCourse != null && !listView.getItems().contains(selectedCourse)) {
            listView.getItems().add(selectedCourse);
        }else if (listView.getItems().contains(selectedCourse)) {
            showAlert("Duplicate course", selectedCourse +" is already in the list");
        }

    }

}