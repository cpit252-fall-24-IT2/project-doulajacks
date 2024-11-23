package org.example.vncpit252;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    public void switchToSceneHomeSave(@SuppressWarnings("exports") ActionEvent event) throws IOException {
       root= FXMLLoader.load(getClass().getResource("save home page.fxml"));
       stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }
    @SuppressWarnings("exports")
    public void switchToHomePage(ActionEvent event) throws IOException{
        root= FXMLLoader.load(getClass().getResource("home page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}