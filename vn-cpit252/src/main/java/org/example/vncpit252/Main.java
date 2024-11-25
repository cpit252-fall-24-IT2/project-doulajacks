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
        // Load initial FXML and CSS
        String css = this.getClass().getResource("styleSheet.css").toExternalForm();
        Parent root = FXMLLoader.load(getClass().getResource("base-dilog-layout.fxml")); // Ensure this FXML navigates to quiz
        Scene scene = new Scene(root);
        scene.getStylesheets().add(css);

        stage.setTitle("CPIT252 VN");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        // Run tests (can be wrapped in a debug flag for development only)
        new Test().runTests();
    }

    public static void main(String[] args) throws IOException {
        // Initialize quiz data
        SharedData.setQuestionStrings("/question.txt");
        SharedData.setAnswerStrings("/answer.txt");

        // Print questions for debugging (optional, remove for production)
        String[] questions = SharedData.getQuestionStrings();
        for (String question : questions) {
            System.out.println(question);
        }

        // Example SaveInfo objects
        SaveInfo user1 = new SaveInfo.SaveInfoBuilder("Saeed", "saeedappapp@gmail.com", "Male")
                .withIntrest("Video Games")
                .withCountry("Saudi Arabia")
                .withAge(21)
                .build();
        SaveInfo user2 = new SaveInfo.SaveInfoBuilder("Faris", "faris.gmail.com", "Male")
                .withIntrest("Football")
                .withCountry("Saudi Arabia")
                .withAge(22)
                .build();

        // Print user information (optional, remove for production)
        System.out.println(user1.toString());
        System.out.println(user2.toString());

        // Launch JavaFX application
        launch();
    }
}
