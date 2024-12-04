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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {
    // Arrays of text and important paths
    String[] dialogStrings = SharedData.getDialogStrings();
    SaveInfo save ;


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
     @FXML
     private Label savename;
    








     

 











 //switchin scean related methouds
 public void switchScene(ActionEvent event, String fxmlname) throws IOException {
    try {
        String css = this.getClass().getResource("/org/example/vncpit252/styleSheet.css").toExternalForm();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlname));  // Create a new loader instance
        root = loader.load();  // Load the new scene
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();  // Add this line for debugging
    }
}
    // public void switchToScene(Scene newScene) {
    //     Stage stage = (Stage) scene.getWindow();
    //  }

    public void switchToHomePage(ActionEvent event) throws IOException {
        
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
    public void switchToLoeadHomePage(ActionEvent event) throws IOException, Exception {
        switchScene(event, "load_home_page.fxml");
        
    }
    //from dialog
    public void switchToLoadHomePageWithoutEvent1() {
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
    public void switchWithNoEvent(String xml) {
        try {
            // Load the FXML file for the new scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource(xml));
    
            // Ensure the controller is set properly only if needed
            // loader.setController(this); // This line can be removed if you have the controller set in the FXML already
    
            // Load the root node from FXML
            Parent root = loader.load();
    
            // Retrieve the current stage from any node (not necessarily 'exitID')
            Stage stage = (Stage) ((Node) exitID).getScene().getWindow(); // You can use any valid node
    
            // Create a new scene with the loaded FXML content
            Scene scene = new Scene(root);
    
            // Optionally add a stylesheet if required
            String css = this.getClass().getResource("/org/example/vncpit252/styleSheet.css").toExternalForm();
            scene.getStylesheets().add(css);
    
            // Set the new scene on the stage and show it
            stage.setScene(scene);
            stage.show();
    
        } catch (IOException e) {
            // Print detailed information about the error to help with debugging
            System.err.println("Error loading FXML: " + xml);
            e.printStackTrace();
        }
    }
    
    public void switchToLoadHomePageWithoutEvent() throws Exception {
        save = SharedData.getSaveInfo();
        if (save == null) {
            switchWithNoEvent("getData.fxml");
        } else {
            // NOT WORKING
            // Text txt = new Text(save.getName());
            // setSafeName(txt.getText()); 



             // Correct this part, passing the actual text value to the label
            switchWithNoEvent("load_home_page.fxml");
            
        }
    }
    
    public void singletinoScean(ActionEvent event) throws Exception {
        SharedData.setPointer(0);
        SharedData.setIntalFlag(0);
        SharedData.setLastFlag(9);
        switchScene(event, "dialog_Show.fxml");
       
    }
    public void proScean(ActionEvent event) throws Exception {
        SharedData.setPointer(10);
        SharedData.setIntalFlag(10);
        SharedData.setLastFlag(14);
        switchScene(event, "dialog_Show.fxml");
       
    }
    public void AdapterScean(ActionEvent event) throws Exception {
        SharedData.setPointer(15);
        SharedData.setIntalFlag(15);
        SharedData.setLastFlag(20);
        switchScene(event, "dialog_Show.fxml");
       
    }
    public void builderScean(ActionEvent event) throws Exception {
        SharedData.setPointer(21);
        SharedData.setIntalFlag(21);
        SharedData.setLastFlag(25);
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
    public void UpdateText() throws Exception {
            if (SharedData.getPointer() <= SharedData.getLastFlag()) {
                
            animationText(dialogStrings[SharedData.getPointer()]);
            SharedData.setPointer(SharedData.getPointer()+1);
            plzwork.setEditable(false);
            plzwork.setWrapText(true);
        } else {
            switchToLoadHomePageWithoutEvent1();
        }
    }
    public void goBackText() throws Exception {
        if (SharedData.getPointer() > SharedData.getIntalFlag()) { 
          
            SharedData.setPointer(SharedData.getPointer() - 1);
            
            animationText(dialogStrings[SharedData.getPointer()]);
            plzwork.setEditable(false);
            plzwork.setWrapText(true);
        } else {
            switchToLoadHomePageWithoutEvent1();
        }
    }
    // end of text related methouds

// exit and save
    public void exit() throws Exception {
        SharedData.writedOBJ();
        Platform.exit();
    }
// exit and save


//stil not functional enph
    // @FXML
    // void saveInfo(ActionEvent event) throws IOException {
    //     SaveInfo currentInfo = new SaveInfo.SaveInfoBuilder(nameEntryID.getText(), emailEntryID.getText(), "male" /* Change this to ChoiceBox value */).build();
    //     stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //     stage.setUserData(currentInfo);
    //     switchScene(event, "load_home_page.fxml");
    // }

    // @FXML
    // void printInfo(ActionEvent event) {
    //     stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //     System.out.println(stage.getUserData());
    // }
    //// end of stil not functional enph

    public void setSafeName() {
        save=SharedData.getSaveInfo();
        savename.setText(save.getName());
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
    
  

    
     

    
}
