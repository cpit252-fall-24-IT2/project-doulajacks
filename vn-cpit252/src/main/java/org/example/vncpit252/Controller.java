package org.example.vncpit252;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    // Arrays of text and important paths
    String[] dialogStrings = SharedData.getDialogStrings();

    // Variables for switching scenes
     Stage stage;
     Scene scene;
     Parent root;

    // Variables for styling and adding elements
    @FXML
     TextArea plzwork;
    @FXML 
     Button exitID ;
    
  
    
    

    
    

    @FXML
     TextField nameEntryID;

    @FXML
     TextField emailEntryID;

    @FXML
     ChoiceBox<?> genderChoiceID;
    

   

    @FXML
    public void switchToHomePage(ActionEvent event) throws IOException {
        switchScene(event, "home_page.fxml");
        
    }

    public void switchToInfoPage(ActionEvent event) throws IOException {
        switchScene(event, "getData.fxml");
    }

    public void switchToLoeadHomePage(ActionEvent event) throws IOException {
        switchScene(event, "load_home_page.fxml");
    }

    public void switchToQuizPage(ActionEvent event) throws IOException {
        switchScene(event, "quiz.fxml");
    }

    public void switchToDialog(ActionEvent event) throws Exception {
        switchScene(event, "dialog_Show.fxml");
    }

    @FXML
    public void singletinoScean(ActionEvent event) throws Exception {
        SharedData.setPointer(0);
        SharedData.setIntalFlag(0);
        SharedData.setLastFlag(9);
        
        
        switchScene(event, "dialog_Show.fxml");
        setText();
        
        
        
        
    }


        
    
    
        @FXML
        public void setText() {
   

   

        
            plzwork.setText(dialogStrings[SharedData.getPointer()]);  // Clear any existing text
            plzwork.setEditable(false);
            plzwork.setWrapText(true);
        

        
    
    
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

    public void exit() {
        SharedData.writedOBJ();
        Platform.exit();
    }

    @FXML
    void saveInfo(ActionEvent event) throws IOException {
        SaveInfo currentInfo = new SaveInfo.SaveInfoBuilder(nameEntryID.getText(), emailEntryID.getText(), "male" /* Change this to ChoiceBox value */).build();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setUserData(currentInfo);
        switchScene(event, "load_home_page.fxml");
    }

    @FXML
    void printInfo(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        System.out.println(stage.getUserData());
    }
}
