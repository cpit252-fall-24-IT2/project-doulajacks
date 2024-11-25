package org.example.vncpit252;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label welcomeText;
    @FXML
    private TextArea  dialog ;

    @FXML
    private TextField nameEntryID;

    @FXML
    private TextField emailEntryID;

    @FXML
    private ChoiceBox<?> genderChoiceID;


    
    
    public void switchToSceneHomeSave(@SuppressWarnings("exports") ActionEvent event) throws IOException {
       switchScene(event, "save home page.fxml");
    }
    @SuppressWarnings("exports")
    public void switchToHomePage(ActionEvent event) throws IOException{
        switchScene(event, "home page.fxml");
    }

    @FXML
    void switchToInfoPage(ActionEvent event) throws IOException {
        switchScene(event, "info-builder-colliction.fxml");
    }

    public void switchScene(@SuppressWarnings("exports") ActionEvent event, String fxmlname) throws IOException {
        root= FXMLLoader.load(getClass().getResource(fxmlname));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exit() {
        Platform.exit();
    }
}