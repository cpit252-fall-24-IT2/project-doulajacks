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

    public void switchToLearningResources(ActionEvent event) throws IOException {
        // Get button id from event toString
        String buttonString = event.toString();
        String idName = "resourcesButton"; // all ids start with this string
        int startIndex = buttonString.indexOf(idName);
        int endIndex = startIndex + (idName.length()+1);
        String buttonID = buttonString.substring(startIndex, endIndex);
        ResourcesController.setResources(buttonID);

        switchScene(event, "learning_resources_page.fxml");
    }

    @FXML
    public void singletinoScean(ActionEvent event) throws Exception {
        SharedData.setPointer(0);
        SharedData.setIntalFlag(0);
        SharedData.setLastFlag(9);
        switchScene(event, "dialog_Show.fxml");
    }
    @FXML
    public void singeltonQuiz(ActionEvent event) throws Exception {
        SharedData.setPointer(0);
        SharedData.setIntalFlag(0);
        SharedData.setLastFlag(5);
        switchScene(event, "quiz.fxml");
    }

    @FXML
    public void prototypeQuiz(ActionEvent event) throws Exception {
        SharedData.setPointer(5);
        SharedData.setIntalFlag(5);
        SharedData.setLastFlag(10);
        switchScene(event, "quiz.fxml");
    }

    @FXML
    public void adapterQuiz(ActionEvent event) throws Exception {
        SharedData.setPointer(10);
        SharedData.setIntalFlag(10);
        SharedData.setLastFlag(15);
        switchScene(event, "quiz.fxml");
    }



    @FXML
    public void builderQuiz(ActionEvent event) throws Exception {
        SharedData.setPointer(15);
        SharedData.setIntalFlag(15);
        SharedData.setLastFlag(20);
        switchScene(event, "quiz.fxml");
    }


    @FXML
    public void proxyQuiz(ActionEvent event) throws Exception {
        SharedData.setPointer(20);
        SharedData.setIntalFlag(20);
        SharedData.setLastFlag(25);
        switchScene(event, "quiz.fxml");
    }

    @FXML
    public void flyweightQuiz(ActionEvent event) throws Exception {
        SharedData.setPointer(25);
        SharedData.setIntalFlag(25);
        SharedData.setLastFlag(30);
        switchScene(event, "quiz.fxml");
    }
    @FXML
    public void decoratorQuiz(ActionEvent event) throws Exception {
        SharedData.setPointer(30);
        SharedData.setIntalFlag(30);
        SharedData.setLastFlag(35);
        switchScene(event, "quiz.fxml");
    }

    @FXML
    public void observerQuiz (ActionEvent event) throws Exception {
        SharedData.setPointer(35);
        SharedData.setIntalFlag(35);
        SharedData.setLastFlag(40);
        switchScene(event, "quiz.fxml");
    }

    
        @FXML
        public void setText() {
            plzwork.setText(dialogStrings[SharedData.getPointer()]);  // Clear any existing text
            SharedData.setPointer(SharedData.getPointer()+1);
            plzwork.setEditable(false);
            plzwork.setWrapText(true);
    }

    public void switchScene(ActionEvent event, String fxmlname) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(fxmlname)));
        stage.setScene(scene);
        stage.show();
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
