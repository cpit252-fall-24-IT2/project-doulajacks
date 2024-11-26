package org.example.vncpit252;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String css = this.getClass().getResource("/org/example/vncpit252/styleSheet.css").toExternalForm();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home_page.fxml"));
            Parent root = loader.load();
        
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add(css);
            
            stage.setTitle("CPIT252 VN");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading FXML file.");
        }
    }

    public static void main(String[] args) throws IOException {
       
        SharedData.setQuestionStrings();
        SharedData.setAnswerStrings();
        SharedData.setDialogStrings();
        

        launch();
        
    }
    
    
}