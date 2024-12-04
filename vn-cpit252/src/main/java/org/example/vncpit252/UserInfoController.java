package org.example.vncpit252;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserInfoController {
     Stage stage;
     Scene scene;
     Parent root;
     


    @FXML
    private TextField nameField; // Name field
    @FXML
    private TextField countryField; // Country field
    @FXML
    private TextField ageField; // Age field
    @FXML
    private TextField interestField; // Interest field

    @FXML
    private CheckBox maleCheckBox; // Male gender checkbox
    @FXML
    private CheckBox femaleCheckBox; // Female gender checkbox
    @FXML
    private CheckBox otherCheckBox; // Other gender checkbox

    @FXML
    private Label resultLabel; // Result label to display messages

    @FXML
    private Button submitButton; // Submit button

    @FXML
    private void handleSubmitAction() {
        // Fetch input values
        String name = nameField.getText().trim();
        String country = countryField.getText().trim();
        String ageText = ageField.getText().trim();
        String interest = interestField.getText().trim();

        // Gender selection logic
        String gender = null;
        if (maleCheckBox.isSelected()) {
            gender = "Male";
        }
        if (femaleCheckBox.isSelected()) {
            if (gender != null) {
                resultLabel.setText("Please select only one gender.");
                resultLabel.setStyle("-fx-text-fill: red;");
                return;
            }
            gender = "Female";
        }
      

        // Validation
        if (name.isEmpty() || gender == null) {
            resultLabel.setText("Name and Gender are mandatory!");
            resultLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        // Validate age
        int age = 0;
        if (!ageText.isEmpty()) {
            try {
                age = Integer.parseInt(ageText);
                if (age < 0) {
                    throw new NumberFormatException("Negative age not allowed");
                }
            } catch (NumberFormatException e) {
                resultLabel.setText("Age must be a positive number!");
                resultLabel.setStyle("-fx-text-fill: red;");
                return;
            }
        }

        // Create SaveInfo object using builder
        SaveInfo saveInfo = new SaveInfo.SaveInfoBuilder(name, gender)
                .withCountry(country.isEmpty() ? null : country)
                .withAge(age)
                .withIntrest(interest.isEmpty() ? null : interest)
                .build();
                SharedData.setSaveInfo(saveInfo);
                System.out.println("we have set safe info obj");

        // Display success message and SaveInfo details
        resultLabel.setText("Form Submitted Successfully!\n" + saveInfo.toString());
        resultLabel.setStyle("-fx-text-fill: green;");
        System.out.println(saveInfo.toString());
        switchToLoadHomePageWithoutEvent();
    }


    
    //
     public void switchToHomePage(ActionEvent event) throws IOException {
        switchScene(event, "home_page.fxml");
        
    }
     public void switchScene(ActionEvent event, String fxmlname) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource(fxmlname));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();  // Add this line for debugging
        }
    }
    public void switchToLoadHomePageWithoutEvent() {
        try {
            // Load the FXML file for "load home page"
            Parent root = FXMLLoader.load(getClass().getResource("load_home_page.fxml"));

            // Retrieve the current stage
            Stage stage = (Stage) resultLabel.getScene().getWindow(); // Replace 'plzwork' with any valid node in your scene

            // Set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Log the exception for debugging
        }
    }
  
}