package org.example.vncpit252;

import java.io.IOException;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.util.Duration;
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
     //time line so we can resit it
     Timeline tl;
    

   




















 //switchin scean related methouds
    public void switchScene(ActionEvent event, String fxmlname) throws IOException {
        try {
            String css = this.getClass().getResource("/org/example/vncpit252/styleSheet.css").toExternalForm();
            root = FXMLLoader.load(getClass().getResource(fxmlname));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();  // Add this line for debugging
        }
    }
    public void switchToScene(Scene newScene) {
        Stage stage = (Stage) scene.getWindow();
     }
    public void switchToHomePage(ActionEvent event) throws IOException {
        SharedData.writedOBJ();
        switchScene(event, "home_page.fxml");
        
    }
    public void switchToInfoPage(ActionEvent event) throws IOException {
        switchScene(event, "getData.fxml");
    }
    public void switchToQuizPage(ActionEvent event) throws IOException {
        switchScene(event, "quiz.fxml");
    }
    public void switchToDialog(ActionEvent event) throws Exception {
        switchScene(event, "dialog_Show.fxml");
    }
    public void switchToLoeadHomePage(ActionEvent event) throws IOException {
        switchScene(event, "load_home_page.fxml");
    }
    public void switchToLoadHomePageWithoutEvent() {
        try {
            // Load the FXML file for "load home page"
            Parent root = FXMLLoader.load(getClass().getResource("load_home_page.fxml"));

            // Retrieve the current stage
            Stage stage = (Stage) plzwork.getScene().getWindow(); // Replace 'plzwork' with any valid node in your scene

            // Set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Log the exception for debugging
        }
    }
    public void singletinoScean(ActionEvent event) throws Exception {
        SharedData.setPointer(0);
        SharedData.setIntalFlag(0);
        SharedData.setLastFlag(9);
        switchScene(event, "dialog_Show.fxml");
       
    }
    
    public void singeltonQuiz(ActionEvent event) throws Exception {
        SharedData.setPointer(0);
        SharedData.setIntalFlag(0);
        SharedData.setLastFlag(5);
        switchScene(event, "quiz.fxml");
    }
    public void prototypeQuiz(ActionEvent event) throws Exception {
        SharedData.setPointer(5);
        SharedData.setIntalFlag(5);
        SharedData.setLastFlag(10);
        switchScene(event, "quiz.fxml");
    }
    public void adapterQuiz(ActionEvent event) throws Exception {
        SharedData.setPointer(10);
        SharedData.setIntalFlag(10);
        SharedData.setLastFlag(15);
        switchScene(event, "quiz.fxml");
    }
    public void builderQuiz(ActionEvent event) throws Exception {
        SharedData.setPointer(15);
        SharedData.setIntalFlag(15);
        SharedData.setLastFlag(20);
        switchScene(event, "quiz.fxml");
    }
    public void proxyQuiz(ActionEvent event) throws Exception {
        SharedData.setPointer(20);
        SharedData.setIntalFlag(20);
        SharedData.setLastFlag(25);
        switchScene(event, "quiz.fxml");
    }
    public void flyweightQuiz(ActionEvent event) throws Exception {
        SharedData.setPointer(25);
        SharedData.setIntalFlag(25);
        SharedData.setLastFlag(30);
        switchScene(event, "quiz.fxml");
    }
    public void decoratorQuiz(ActionEvent event) throws Exception {
        SharedData.setPointer(30);
        SharedData.setIntalFlag(30);
        SharedData.setLastFlag(35);
        switchScene(event, "quiz.fxml");
    }
    public void observerQuiz (ActionEvent event) throws Exception {
        SharedData.setPointer(35);
        SharedData.setIntalFlag(35);
        SharedData.setLastFlag(40);
        switchScene(event, "quiz.fxml");
    }
    
    // end of switchin sean  related methouds 



    // text relatex methouds
    private void stopCurrentAnimation() {
        if (tl != null && tl.getStatus() == Timeline.Status.RUNNING) {
            tl.stop();  // Stop the animation if it's running
        }
    }
    public void animationText(String str){
        
        stopCurrentAnimation();
        String dialogue = str;  // The dialogue string
        plzwork.setText("");  // Initially set the TextArea to be empty

        tl = new Timeline();

        for (int i = 0; i < dialogue.length(); i++) {
            // Create a KeyFrame for each character to be displayed
            final int index = i;
            Duration duration = Duration.millis(index * 50);  // Duration for each character
            KeyValue keyValue = new KeyValue(plzwork.textProperty(), dialogue.substring(0, index + 1), Interpolator.LINEAR);
            KeyFrame keyFrame = new KeyFrame(duration, keyValue);
            tl.getKeyFrames().add(keyFrame);
            }

        tl.setCycleCount(1);  // Play once
        tl.play();  // Start the timeline

    }
    public void UpdateText() {
            if (SharedData.getPointer() <= SharedData.getLastFlag()) {
                
            animationText(dialogStrings[SharedData.getPointer()]);
            SharedData.setPointer(SharedData.getPointer()+1);
            plzwork.setEditable(false);
            plzwork.setWrapText(true);
        } else {
            switchToLoadHomePageWithoutEvent();
        }
    }
    public void goBackText() throws Exception {
        if (SharedData.getPointer() > SharedData.getIntalFlag()) { 
          
            SharedData.setPointer(SharedData.getPointer() - 1);
            
            animationText(dialogStrings[SharedData.getPointer()]);
            plzwork.setEditable(false);
            plzwork.setWrapText(true);
        } else {
            switchToLoadHomePageWithoutEvent();
        }
    }
    // end of text related methouds

// exit and save
    public void exit() {
        SharedData.writedOBJ();
        Platform.exit();
    }
// exit and save


//stil not functional enph
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
    //// end of stil not functional enph






























    

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
    
  

    
     

    
}
